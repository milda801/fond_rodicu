# Kindergarten Expense Tracker

Offline-first Android application for tracking kindergarten fees, installments, receipts, expenses, and account balance.

## Implemented

- Children: add, rename, and safely deactivate while preserving payment history.
- Fees: yearly amount, full-year or two-installment mode, and due dates.
- Payments: manual entry, receipt photo/gallery selection, on-device OCR, status and remaining balance.
- Expenses: manual entry, categories, receipt OCR, list, and deletion.
- Reports: payment status, expense totals, balance, CSV export, PDF export, and Android email/share sheet.
- Backup: JSON export/import through Android's document picker and daily automatic refresh of a selected Google Drive, Dropbox, or local document.
- Accessibility: high-contrast light color palette, dark readable body text, larger typography, bold section headings, and clearly differentiated navigation states.
- Languages: Czech is the initial app language, with an English/Czech selector in Settings and persisted per-app language choice.

## Editing translations

The canonical English text is stored in `app/src/main/res/values/strings.xml`. The editable Czech draft is stored in `app/src/main/res/values-cs/strings.xml`. To improve Czech wording, edit only the text between the tags in the Czech file and keep every `name` attribute unchanged. Positional placeholders such as `%1$s` must also be retained because the app replaces them with runtime values.

When a new English string is added, add a matching entry with the same `name` to the Czech file. The two language files currently contain matching resource keys. Users can change the language under Settings → Language; Android persists the selection and recreates the UI immediately.

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

## Project documentation

- `IMPLEMENTATION_PLAN.md`: architecture and roadmap.
- `PROGRESS_LOG.md`: chronological implementation log and remaining work.
- `SESSION_SUMMARY.md`: original first-session summary; the progress log is the current source of truth.

## Documentation maintenance policy

Every project change must include corresponding Markdown documentation updates in the same task. At minimum, append the implementation and verification outcome to `PROGRESS_LOG.md`. Update `README.md` whenever setup, build, usage, capabilities, limitations, or operator instructions change. Update `IMPLEMENTATION_PLAN.md` when architecture, scope, priorities, or planned work changes. Keep `SESSION_SUMMARY.md` as a historical first-session record unless explicitly revising historical documentation.
