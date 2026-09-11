# Kindergarten Expense Tracker

Offline-first Android application for tracking kindergarten fees, installments, receipts, expenses, and account balance.

## Implemented

- Children: add individually, bulk-import by pasting one name per line, rename, and safely deactivate while preserving payment history.
- Fees: yearly amount, full-year or two-installment mode, and due dates.
- Payments: mandatory camera receipt photo; layout-aware Czech cash-receipt OCR for receipt number, payer/child name, total amount, and date; editable review/correction; optional notes, status, remaining balance, editing, and deletion.
- Expenses: mandatory camera receipt photo, OCR review/correction, paper receipt count number, date, amount, supplier, description, optional note, editing, and deletion.
- Reports: matching XLSX and PDF financial exports with a summary, separate half-year payment amounts, expense details, and embedded payment/expense receipt photos; Android email/share sheet.
- Backup: complete JSON export/import—including Base64-encoded receipt images—through Android's document picker and daily automatic refresh of a selected Google Drive, Dropbox, or local document.
- Accessibility: high-contrast light color palette, dark readable body text, larger typography, bold section headings, and clearly differentiated navigation states.
- Languages: Czech is the initial app language, with an English/Czech selector in Settings and persisted per-app language choice.

## Editing translations

The canonical English text is stored in `app/src/main/res/values/strings.xml`. The editable Czech draft is stored in `app/src/main/res/values-cs/strings.xml`. To improve Czech wording, edit only the text between the tags in the Czech file and keep every `name` attribute unchanged. Positional placeholders such as `%1$s` must also be retained because the app replaces them with runtime values.

When a new English string is added, add a matching entry with the same `name` to the Czech file. The two language files currently contain matching resource keys. Users can change the language under Settings → Language; Android persists the selection and recreates the UI immediately.

## Importing children

On the Dashboard, tap **Import children**, paste one child name per line, choose the shared enrollment date, review the live count, and confirm. The importer trims whitespace, ignores empty lines, and skips names that duplicate either an existing active child or an earlier pasted line. Duplicate matching ignores capitalization and Czech diacritics. Existing child records and payment history are not modified.

## Build requirements

### Recommended: VS Code Dev Container

1. Install Docker, VS Code, and the VS Code Dev Containers extension.
2. Open this repository in VS Code.
3. Run **Dev Containers: Reopen in Container** from the command palette.
4. Wait for container creation and the Gradle wrapper/toolchain check to complete.
5. Build and test with `./gradlew test assembleDebug`.

The development container is defined by `.devcontainer/Dockerfile` and `.devcontainer/devcontainer.json`. It includes JDK 17, Gradle 8.0.2, Android SDK Platform 34, Build Tools 34.0.0, platform tools, and Android-related VS Code extensions. The project uses Android Gradle Plugin 8.1.4, and the Gradle dependency cache is stored in a persistent Docker volume.

The generated debug APK is written to `app/build/outputs/apk/debug/app-debug.apk`.

The latest clean verification completed successfully for debug and release unit-test variants and generated the debug APK without source, Room, or compile-SDK compatibility warnings. Android may still report that the bundled ML Kit native OCR library cannot be stripped; it is packaged unchanged and this does not block the build.

#### VS Code Gradle JVM

The current Java extension uses its bundled JRE 21 for the Java language server, while this project deliberately runs Gradle 8.0.2 with JDK 17. The Dev Container config sets `java.import.gradle.java.home` to the container's JDK 17 installation so Gradle project import does not fail with `Unsupported class file major version 65`.

After changing or rebuilding the container, run **Developer: Reload Window**. If an earlier failed JRE 21 import left stale script caches, run `./gradlew --stop && rm -rf /home/vscode/.gradle/caches/8.0.2/scripts*` in the container terminal, then run **Java: Clean Java Language Server Workspace**.

### Alternative: Android Studio

1. Install Android Studio with Android SDK 34 and its bundled JDK 17.
2. Open this directory as an Android Studio project.
3. Allow Gradle synchronization to complete.
4. Run the `app` configuration on an Android 8.0 (API 26) or newer device/emulator.

## Important email behavior

Manual PDF/CSV email sharing is implemented using Android's secure share sheet. Fully unattended scheduled email is intentionally not implemented with a stored SMTP password. Production-safe automatic delivery requires either Gmail OAuth/API integration or a small authenticated backend.

## Data and privacy

- Core data and receipt images are stored locally in app-private storage.
- OCR runs on-device using Google ML Kit.
- The app requests internet/network-state access for cloud document providers and scheduled backup.
- It does not request broad external-storage, account, or direct camera permissions.

## Receipt workflow

Creating a payment or expense starts the system camera immediately. After a successful photo, on-device OCR attempts to extract relevant fields and opens an editable confirmation form. The user reviews or corrects the OCR result, adds information such as notes, and saves. Saving is blocked until OCR has finished and a non-empty receipt image is attached. Cancelling removes the unsaved photo.

For the standard Czech “PŘÍJMOVÝ POKLADNÍ DOKLAD” payment form, OCR uses both the printed labels and their physical positions to locate the handwritten receipt number, payer name, and total. After the initial full-page pass, the app performs multiple enlarged OCR passes on the three corresponding handwritten field regions, including a color-separation pass that removes the gray/black form and preserves blue or purple pen strokes. Parsed totals are checked against the configured full-year and half-year fee values; an implausible merged number is left blank rather than saved as a payment. This prevents the large preprinted seven-digit form serial from being mistaken for the handwritten receipt order number. The recognized payer is matched against active children without case or Czech-diacritic sensitivity, and the matching child is selected automatically. Receipt numbers are stored and remain editable before saving.

Handwritten OCR remains best-effort and may misread or omit values depending on handwriting, lighting, focus, perspective, and pen color. The confirmation form is therefore authoritative: the user must review and correct the receipt number, child, amount, and date before saving. Further handwriting-recognition tuning is a low-priority enhancement rather than a release blocker.

Tap an existing payment or expense to edit its saved fields. The existing receipt is retained by default; using “Retake receipt photo” replaces it only after the updated record is saved successfully. Cancelling an edit discards a newly taken replacement and preserves the original record and image. Long-press remains the delete action.

Every current payment and expense is expected to have a receipt image. Backup format version 2 embeds those images inside the JSON backup, so restoring recreates both database records and app-private receipt files. A backup is rejected rather than silently omitting a missing image. Legacy format-version-1 backups can still be imported for compatibility, but their historical image paths may not be portable.

## Spreadsheet export

The Reports screen exports a real `.xlsx` workbook with the financial summary at the top, followed by the payment and expense tables on one worksheet. Payment rows contain the receipt number, child name, separate first- and second-half amount columns, and the receipt photograph embedded in the workbook. A payment equal to the configured yearly fee is always divided evenly between the two half-year columns, regardless of its stored installment classification; smaller first- and second-half installment records are placed in their corresponding columns. Expense rows contain the physical count number, supplier, amount, description, note, and embedded expense-receipt photograph. The summary contains the active-child count, expected amount, collected amount, and current balance after expenses.

The PDF export follows the same order and data structure in a landscape table layout. It places the summary first, repeats table headings when payment or expense rows continue onto a new page, and embeds both payment and expense receipt photos while preserving their aspect ratios.

Both XLSX and PDF financial exports are always generated in Czech, including section names, column headings, fallback text, and PDF number formatting. This is independent of whether the application interface is currently set to Czech or English.

## Project documentation

- `IMPLEMENTATION_PLAN.md`: architecture and roadmap.
- `PROGRESS_LOG.md`: chronological implementation log and remaining work.
- `SESSION_SUMMARY.md`: original first-session summary; the progress log is the current source of truth.

## Documentation maintenance policy

Every project change must include corresponding Markdown documentation updates in the same task. At minimum, append the implementation and verification outcome to `PROGRESS_LOG.md`. Update `README.md` whenever setup, build, usage, capabilities, limitations, or operator instructions change. Update `IMPLEMENTATION_PLAN.md` when architecture, scope, priorities, or planned work changes. Keep `SESSION_SUMMARY.md` as a historical first-session record unless explicitly revising historical documentation.
