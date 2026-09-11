# Kindergarten Expense Tracker - Development Progress Log

## Session 1 - 2026-09-09 18:45-18:51 UTC

### Completed Tasks

#### 1. Planning & Architecture (100%)
- [x] Created comprehensive implementation plan (`IMPLEMENTATION_PLAN.md`)
- [x] Defined Android app architecture with Kotlin
- [x] Planned technology stack (Room, ML Kit, Google Drive API, WorkManager)
- [x] Designed 5-tab navigation UI structure
- [x] Planned OCR integration strategy
- [x] Planned cloud backup and email export features

#### 2. Project Setup (100%)
- [x] Created root `build.gradle` with plugin versions
- [x] Created app-level `build.gradle` with all dependencies
- [x] Created `AndroidManifest.xml` with required permissions and services

#### 3. Data Models (100%)
- [x] Created `Child.kt` - Child entity with enrollment tracking
- [x] Created `FeeConfiguration.kt` - Fee setup with split options
- [x] Created `Payment.kt` - Payment tracking with OCR fields
- [x] Created `Expense.kt` - Expense tracking with categorization
- [x] Created `SyncMetadata.kt` - Cloud sync metadata tracking

#### 4. Database Access Objects (DAOs) (100%)
- [x] Created `ChildDao.kt` - CRUD operations for children
- [x] Created `PaymentDao.kt` - Payment queries and aggregations
- [x] Created `ExpenseDao.kt` - Expense queries by category/date
- [x] Created `FeeConfigurationDao.kt` - Fee configuration management
- [x] Created `SyncMetadataDao.kt` - Sync status tracking

#### 5. Room Database (100%)
- [x] Created `AppDatabase.kt` - Room database singleton with all DAOs

#### 6. Repositories (100%)
- [x] Created `ChildRepository.kt` - Child data access layer
- [x] Created `PaymentRepository.kt` - Payment data access layer
- [x] Created `ExpenseRepository.kt` - Expense data access layer
- [x] Created `FeeConfigurationRepository.kt` - Fee configuration access layer
- [x] Created `SyncMetadataRepository.kt` - Sync metadata access layer

### Files Created
```
d:/_actual/099/skolka/
├── IMPLEMENTATION_PLAN.md
├── build.gradle
├── app/
│   ├── build.gradle
│   └── src/main/
│       ├── AndroidManifest.xml
│       └── java/com/skolka/expensetracker/
│           ├── data/
│           │   ├── models/
│           │   │   ├── Child.kt
│           │   │   ├── FeeConfiguration.kt
│           │   │   ├── Payment.kt
│           │   │   ├── Expense.kt
│           │   │   └── SyncMetadata.kt
│           │   ├── dao/
│           │   │   ├── ChildDao.kt
│           │   │   ├── PaymentDao.kt
│           │   │   ├── ExpenseDao.kt
│           │   │   ├── FeeConfigurationDao.kt
│           │   │   └── SyncMetadataDao.kt
│           │   ├── database/
│           │   │   └── AppDatabase.kt
│           │   └── repository/
│           │       ├── ChildRepository.kt
│           │       ├── PaymentRepository.kt
│           │       ├── ExpenseRepository.kt
│           │       ├── FeeConfigurationRepository.kt
│           │       └── SyncMetadataRepository.kt
```

#### 7. ViewModels (100%)
- [x] Created `DashboardViewModel.kt` - Dashboard state and payment status logic
- [x] Created `PaymentViewModel.kt` - Payment CRUD and filtering
- [x] Created `ExpenseViewModel.kt` - Expense CRUD and category filtering
- [x] Created `ReportViewModel.kt` - Report data aggregation and summaries
- [x] Created `SettingsViewModel.kt` - Settings, fee config, and backup management

### Total Files Created: 26

---

## Next Steps (TODO)

### Phase 1: Core UI & ViewModels (Priority: HIGH) ✅ COMPLETED
- [x] Create `DashboardViewModel.kt` - Dashboard data and logic
- [x] Create `PaymentViewModel.kt` - Payment management logic
- [x] Create `ExpenseViewModel.kt` - Expense management logic
- [x] Create `SettingsViewModel.kt` - Settings and configuration
- [x] Create `ReportViewModel.kt` - Report generation logic

### Phase 2: UI Layouts (Priority: HIGH)
- [ ] Create `activity_main.xml` - Main activity with bottom navigation
- [ ] Create `fragment_dashboard.xml` - Dashboard screen layout
- [ ] Create `fragment_payments.xml` - Payments list layout
- [ ] Create `fragment_expenses.xml` - Expenses list layout
- [ ] Create `fragment_reports.xml` - Reports view layout
- [ ] Create `fragment_settings.xml` - Settings layout
- [ ] Create dialog layouts for add/edit operations

### Phase 3: Fragment Implementation (Priority: HIGH)
- [ ] Create `MainActivity.kt` - Main activity with navigation
- [ ] Create `DashboardFragment.kt` - Dashboard implementation
- [ ] Create `PaymentsFragment.kt` - Payments list implementation
- [ ] Create `ExpensesFragment.kt` - Expenses list implementation
- [ ] Create `ReportsFragment.kt` - Reports implementation
- [ ] Create `SettingsFragment.kt` - Settings implementation

### Phase 4: Services & Utilities (Priority: MEDIUM)
- [ ] Create `OCRService.kt` - ML Kit OCR integration
- [ ] Create `BackupService.kt` - Google Drive/Dropbox backup
- [ ] Create `EmailService.kt` - Email report sending
- [ ] Create `ReportGenerator.kt` - Excel/PDF generation
- [ ] Create `DateUtils.kt` - Date formatting utilities
- [ ] Create `CurrencyUtils.kt` - Currency formatting

### Phase 5: Workers & Scheduling (Priority: MEDIUM)
- [ ] Create `BackupWorker.kt` - Daily backup task
- [ ] Create `EmailWorker.kt` - Scheduled email reports
- [ ] Create `SyncWorker.kt` - Cloud sync worker

### Phase 6: Resources (Priority: MEDIUM)
- [ ] Create `strings.xml` - String resources
- [ ] Create `colors.xml` - Color palette
- [ ] Create `dimens.xml` - Dimension resources
- [ ] Create `styles.xml` - App themes and styles
- [ ] Create app icons and launcher icons

### Phase 7: Testing & Polish (Priority: LOW)
- [ ] Create unit tests for repositories
- [ ] Create UI tests for fragments
- [ ] Performance optimization
- [ ] Error handling and validation
- [ ] User feedback (toasts, snackbars)

---

## Architecture Summary

**Current Status**: Data layer complete (Models, DAOs, Database, Repositories)

**Next Focus**: UI layer (ViewModels, Fragments, Layouts)

**Technology Stack**:
- Language: Kotlin
- Database: Room (SQLite)
- UI: Android Jetpack (Fragments, Navigation)
- Async: Coroutines
- OCR: ML Kit Text Recognition
- Cloud: Google Drive API / Dropbox SDK
- Reports: Apache POI (Excel), iText (PDF)
- Scheduling: WorkManager

---

## Notes
- All data models use UUID for primary keys
- Repositories follow single responsibility principle
- DAOs use Flow for reactive data updates
- Database uses fallbackToDestructiveMigration for development
- All timestamps stored as String (ISO 8601 format)

---

## Session 2 - 2026-09-09 18:54 UTC

### Completed in this prompt
- [x] Added Gradle project settings and AndroidX properties.
- [x] Added initial Material 3 strings, colors, dimensions, and application theme.
- [x] Added Android backup/data-transfer XML rules.
- [x] Added a vector application icon and connected it in the manifest.

### Next
- [x] Create main navigation resources and screen layouts.
- [ ] Implement MainActivity and the five primary fragments.
- [ ] Add ViewModel factories/dependency wiring and verify the first build.

### Completed in this prompt (continued)
- [x] Added bottom navigation menu and Navigation Component graph.
- [x] Added layouts for MainActivity, dashboard, payments, expenses, reports, and settings.
- [x] Added vector icons for navigation and add actions.

### Immediate next step
- [x] Implement initial activities/fragments and dependency wiring.
- [ ] Implement CRUD dialogs and list adapters.

### Completed in this prompt (application shell)
- [x] Added application-level repository container.
- [x] Added MainActivity and wired bottom navigation to the navigation graph.
- [x] Added all five fragment classes and a reactive dashboard implementation.
- [x] Removed manifest references to services/receiver that do not exist yet, preventing class-resolution failures.

### Next
- [ ] Add child, payment, and expense entry dialogs plus RecyclerView lists.
- [x] Added manual child, payment, and expense dialogs and reactive scrolling lists (simple LinearLayout implementation).
- [ ] Add edit/delete actions, validation, and receipt capture buttons.
- [ ] Correct remaining build/dependency issues and run a Gradle build.
- [x] Added local CSV and PDF balance-sheet generation without external report libraries.
- [x] Added secure FileProvider sharing and manual email/share actions.
- [ ] Validate email attachment behavior on a physical Android device.
- [ ] Scheduled unattended email remains pending; it requires Gmail OAuth/API or a secure backend and cannot safely use a stored SMTP password.

### Completed in this prompt (OCR core)
- [x] Added an on-device ML Kit OCR service.
- [x] Added locale-tolerant receipt amount parsing and common European/ISO date parsing.
- [x] Added parser unit tests for European decimal amounts and total selection.

### Next
- [ ] Connect Camera/FileProvider capture to payment and expense dialogs.
- [ ] Populate form fields from OCR and require user confirmation before saving.
- [ ] Run unit tests once Java and a Gradle wrapper are available.

### Completed in this prompt (receipt workflow)
- [x] Added receipt-image selection to payment and expense forms.
- [x] Connected selected images to on-device OCR.
- [x] Auto-populated extracted amount/date and probable expense vendor for user review.

### Next
- [ ] Add direct in-app camera capture in addition to gallery/image selection.
- [ ] Persist receipt image URI/path with each payment or expense.
- [ ] Add visible OCR progress and validation messages.

### Completed in this prompt (portable cloud backup)
- [x] Added complete JSON backup generation for children, fee configurations, payments, and expenses.
- [x] Connected Settings to Android's Storage Access Framework so backups can be saved directly to Google Drive, Dropbox, or local storage.
- [x] Made fee configuration saving functional.
- [x] Removed unused Google API, Dropbox, Retrofit, Glide, POI, iText, mail, and logging dependencies to reduce build size and compatibility risk.

### Next
- [ ] Add backup restore/import with validation and conflict handling.
- [ ] Add scheduled reminders/backups after a persistent cloud destination is configured.

### Completed in this prompt (static integration review)
- [x] Replaced nested infinite Flow collection in ReportViewModel with a single combine pipeline.
- [x] Changed report email sharing to ACTION_SEND so PDF attachments are retained by compatible email/share apps.
- [x] Made the OCR coroutine continuation type explicit to avoid Kotlin inference ambiguity.

### Next
- [ ] Perform a full compile/resource check when Android Studio or Java/Gradle becomes available.
- [ ] Implement validated backup restore and improve form validation.

### Completed in this prompt (backup restore)
- [x] Added validated JSON backup import through Android's document picker.
- [x] Restore merges records by stable UUID and inserts parents before foreign-key-dependent payments.
- [x] Enabled Room REPLACE conflict behavior for imported core entities.

### Next
- [ ] Add a pre-restore confirmation explaining merge behavior.
- [ ] Add a replace-all restore option and transactional database import.
- [ ] Improve entry validation and edit/delete interactions.

### Completed in this prompt (camera and receipt persistence)
- [x] Added direct camera capture and existing-image selection for both payment and expense receipts.
- [x] Added app-private permanent receipt storage and FileProvider camera URIs.
- [x] Persisted receipt file paths with payment/expense records and distinguished scanned versus manual records.

### Next
- [ ] Show OCR progress and receipt preview.
- [ ] Delete orphaned receipt files when an entry is cancelled or deleted.
- [ ] Add edit/delete interactions and stronger form validation.

### Completed in this prompt (receipt state correction)
- [x] Fixed stale camera state overwriting a subsequently selected gallery receipt.
- [x] Delete temporary camera files when capture is cancelled.
- [x] Removed unnecessary direct CAMERA permission because capture is delegated to the system camera app via ActivityResultContracts.TakePicture.

### Next
- [ ] Delete stored receipt copies when the enclosing add dialog is cancelled.
- [ ] Add edit/delete actions and validate positive amounts, dates, categories, and descriptions.

### Completed in this prompt (resource and cleanup review)
- [x] Corrected the Navigation Component graph to use app:startDestination.
- [x] Added receipt-file cleanup when payment or expense entry is cancelled or dismissed.
- [x] Transfer receipt ownership to the saved record only after a successful save action.

### Next
- [ ] Prevent dialog dismissal when validation fails by overriding positive-button behavior after show().
- [ ] Add long-press edit/delete actions and remove receipt files when records are deleted.

### Completed in this prompt (validation and deletion)
- [x] Added non-dismissive validation for positive payment/expense amounts and ISO dates.
- [x] Require expense category and description.
- [x] Added child names to payment rows.
- [x] Added long-press payment/expense deletion with confirmation and receipt-file cleanup.

### Next
- [ ] Add edit interactions and child deactivation/deletion controls.
- [ ] Add visible helper text explaining long-press deletion.
- [ ] Improve payment installment classification across multiple payments.

### Completed in this prompt (installment status)
- [x] Added exact paid and remaining amounts per child to the dashboard.
- [x] Added status colors for paid, partial, and unpaid children.
- [x] Added second-half overdue detection when a due date is configured.
- [x] Classified subsequent partial payments as second-half payments instead of repeatedly marking them first-half.

### Next
- [ ] Expose first- and second-half due dates in Settings.
- [ ] Add payment overage handling and configurable currency/locale.
- [ ] Add child edit/deactivation and payment/expense edit interactions.

### Completed in this prompt (fee schedule settings)
- [x] Added first- and second-half due-date fields to Settings.
- [x] Validate ISO dates and require the second due date to be on or after the first.
- [x] Load the latest fee configuration back into the Settings form.
- [x] Persist due dates so dashboard overdue indicators work end to end.

### Next
- [ ] Add explicit full-year versus split-payment configuration.
- [ ] Add child lifecycle management and edit interactions.
- [ ] Add configurable currency and academic-year validation.

### Static validation - 2026-09-09 19:21 UTC
- [x] Parsed all Android XML resources successfully.
- [x] Checked Kotlin source delimiter balance with no warnings.
- [ ] Full Android compilation remains blocked because Java and Gradle are unavailable in the current environment.

### Completed in this prompt (fee split option)
- [x] Added an explicit switch for full-year versus two-installment fees.
- [x] Due dates are enabled and required only for split fees.
- [x] Overdue calculation now applies only to split-fee configurations.

### Next
- [ ] Add child edit/deactivation controls.
- [ ] Add configurable currency and stronger academic-year validation.
- [ ] Compile and test in Android Studio when the toolchain is available.

### Completed in this prompt (child lifecycle)
- [x] Added tap-to-rename for active children.
- [x] Added long-press deactivation while preserving all historical payments.
- [x] Avoided destructive child deletion and its cascading financial-data loss.
- [x] Validate academic years as consecutive YYYY-YYYY values.

### Next
- [ ] Add a view for inactive children and reactivation.
- [ ] Add payment and expense editing.
- [ ] Configure currency independently of the device locale.
 
### Build environment verification - 2026-09-09 19:02 UTC 
- Java available: false
- System Gradle available: false 
- Build blocked: Gradle wrapper must be added before compilation. 
- Next: add a Gradle wrapper or open the project in Android Studio to generate it.

### Android toolchain discovery - 2026-09-09 19:24 UTC
- No Android Studio JBR or default Android SDK path was found.
- Next: use any discovered JBR/SDK for compilation, otherwise install Android Studio.

### Completed in this prompt (automatic cloud backup)
- [x] Persist the user-selected Storage Access Framework backup URI.
- [x] Added a CoroutineWorker that regenerates and overwrites the complete JSON backup.
- [x] Added unique daily WorkManager scheduling with network connectivity constraints.
- [x] Selecting a backup destination now enables ongoing automatic backup to Google Drive, Dropbox, or local document providers.

### Next
- [ ] Show automatic-backup destination/status and last successful time in Settings.
- [ ] Add WorkManager tests once the Android toolchain is installed.
- [ ] Decide on secure Gmail OAuth or backend delivery for unattended scheduled email.

### Completed in this prompt (backup status and privacy)
- [x] Added visible automatic-backup destination, last-success time, and last-error details in Settings.
- [x] BackupWorker now persists success/error outcomes after each run.
- [x] Removed obsolete external-storage and account permissions; document-provider access requires no broad storage permission.

### Next
- [ ] Add an explicit disable/change automatic-backup action.
- [ ] Improve user-facing timestamp and destination formatting.
- [ ] Add WorkManager tests after installing the Android toolchain.

### Completed in this prompt (backup lifecycle)
- [x] Added a confirmed action to disable daily automatic backup.
- [x] Cancel the unique WorkManager job and clear stored backup status when disabled.
- [x] Release persisted document access where the provider supports it.
- [x] Keep existing backup files intact so disabling cannot destroy teacher data.

### Next
- [ ] Improve timestamp/destination labels for non-technical users.
- [ ] Add background-backup notifications for repeated failures.
- [ ] Compile and run WorkManager tests after Android Studio installation.

### Resource-reference audit - 2026-09-09 19:28 UTC
- [x] Reviewed Kotlin references to layouts, IDs, strings, colors, drawables, menus, and navigation resources.
- [x] No missing application resource references were found.
- [ ] Android resource linking still needs confirmation with the Android SDK.

### Completed in this prompt (developer handoff)
- [x] Added README with implemented features, Android Studio build steps, privacy behavior, and known toolchain limitation.
- [x] Documented secure manual email sharing and why unattended SMTP password storage is excluded.
- [x] Identified PROGRESS_LOG.md as the authoritative continuation record.

### Next
- [ ] Install/open with Android Studio, synchronize Gradle, and compile the debug APK.
- [ ] Resolve compiler/resource findings from the first real build.
- [ ] Add scheduled email via Gmail OAuth or an authenticated backend after deployment credentials are chosen.

### Completed in this prompt (final targeted source review)
- [x] Added the missing MaterialAlertDialogBuilder import in SettingsFragment.
- [x] Normalized Kotlin Android and KAPT plugins to their fully qualified supported IDs.
- [x] Confirmed Settings fee, backup export/import, automatic scheduling, status, and disable flows are structurally complete.

### Remaining release blockers
- [ ] Install Android Studio/JDK/SDK and perform the first actual Gradle compile.
- [ ] Test camera, OCR, document providers, PDF/CSV sharing, and WorkManager on a physical Android device.
- [ ] Choose Gmail OAuth or an authenticated backend if unattended scheduled email is mandatory.

## Current milestone snapshot - 2026-09-09 19:31 UTC

### Core application workflows complete
- [x] Child add/rename/deactivate.
- [x] Full-year or two-installment fee configuration with due dates.
- [x] Payment and expense manual entry, reactive lists, validation, and deletion.
- [x] Camera/gallery receipt capture, app-private storage, OCR parsing, and form population.
- [x] Paid/partial/unpaid status, remaining amounts, overdue warning, expense totals, and balance.
- [x] PDF/CSV generation and manual Android email/share workflow.
- [x] Portable JSON backup/restore and daily automatic document-provider backup.
- [x] Backup status and disable controls.

### Enhancements still pending
- [ ] Payment and expense editing (delete/re-enter currently supported).
- [ ] Inactive-child list and reactivation.
- [ ] Configurable currency instead of device locale.
- [ ] OCR progress/receipt preview polish.
- [ ] Fully unattended scheduled email through OAuth/backend.

### Verification status
- [x] XML parse, delimiter, source, and resource-reference static reviews completed.
- [x] A containerized JDK, Gradle, and Android SDK toolchain is now available.
- [ ] Actual Android compilation and physical-device tests remain pending.

## Development environment update - 2026-09-10

### Completed
- [x] Added `.devcontainer/Dockerfile` using the Ubuntu 22.04 Dev Container base.
- [x] Installed JDK 17, Gradle 8.0.2, Android SDK Platform 34, Build Tools 34.0.0, and platform tools.
- [x] Added `.devcontainer/devcontainer.json` with Android/Kotlin/Java/Gradle VS Code extensions and a persistent Gradle cache.
- [x] Configured container creation to generate the Gradle wrapper when missing and verify the Gradle installation.
- [x] Added `.dockerignore` to exclude local caches, build outputs, IDE metadata, and local SDK configuration from the Docker build context.
- [x] Generated the Gradle wrapper files for reproducible command-line and CI builds.
- [x] Successfully built the Docker image and verified Java 17, Gradle 8.0.2, Android Platform 34, Build Tools 34.0.0, and platform tools inside it.

### Documentation policy
- [x] Every future project change must update the relevant Markdown documentation in the same task.
- [x] `PROGRESS_LOG.md` must record every implementation and verification outcome.
- [x] `README.md` must be updated for changes affecting setup, build, usage, features, limitations, or operator instructions.
- [x] `IMPLEMENTATION_PLAN.md` must be updated when architecture, scope, priorities, or planned work changes.
- [x] `SESSION_SUMMARY.md` remains a historical first-session record unless a historical correction is explicitly requested.

### Next
- [ ] Reopen the repository in the Dev Container and run `./gradlew test assembleDebug`.
- [ ] Resolve findings from the first complete Android build.
- [ ] Perform the physical-device tests listed under the remaining release blockers.

## Gradle import JVM correction - 2026-09-10

### Completed
- [x] Diagnosed `Unsupported class file major version 65` as Gradle 8.0.2 being launched by the Java extension's bundled JRE 21 instead of the project's JDK 17 toolchain.
- [x] Configured `java.import.gradle.java.home` to run Gradle project import with `/usr/lib/jvm/java-17-openjdk-amd64`.
- [x] Applied the same Gradle import JVM setting to the generated VS Code workspace file so its empty workspace-level settings cannot mask the Dev Container customization.
- [x] Removed the obsolete attempt to launch the current Java language server itself on JDK 17; it may continue using its required bundled JRE 21 independently.
- [x] Documented the VS Code reload and stale Gradle script-cache recovery procedure.

### Verification pending
- [ ] Reload VS Code in the Dev Container and confirm that the Gradle extension reports JDK 17 and discovers project tasks.
- [x] Run `./gradlew test assembleDebug` and record the complete build outcome.

### Command-line verification findings
- [x] Confirmed Gradle 8.0.2 starts successfully under the container's JDK 17; the class-file-major-version failure is resolved on the command line.
- [x] Identified the next build failure: Android Gradle Plugin 8.1.0 implicitly requested Build Tools 33.0.1, but the immutable container SDK contains Build Tools 34.0.0.
- [x] Pinned `buildToolsVersion` to the provisioned 34.0.0 toolchain so Gradle does not attempt an unsupported runtime SDK installation.
- [x] Re-ran the complete build and confirmed Android resource processing now advances through Kotlin annotation processing.
- [x] Identified Room 2.5.2 annotation-processor incompatibility with the project's Kotlin 1.9 suspend DAO metadata: generated continuations were incorrectly treated as DAO parameters and return types collapsed to `Object`.
- [x] Upgraded Room runtime, KTX, and compiler together to 2.6.1 for Kotlin 1.9-compatible processing.
- [x] Ran `./gradlew clean test assembleDebug` successfully under JDK 17; all 78 tasks completed and the debug APK was generated.
- [x] Unit tests passed for both debug and release variants.
- [x] Followed up on all actionable warnings: added Room foreign-key indexes to Payment, made the expense save-listener label unambiguous, removed the unused payment-status parameter, and upgraded Android Gradle Plugin to 8.1.4 for compileSdk 34 support.

## Build-warning cleanup - 2026-09-10

### Completed
- [x] Added indexes for `Payment.childId` and `Payment.feeConfigId`, eliminating Room's parent-modification full-scan warnings.
- [x] Scoped dashboard payment-status calculations to the active fee configuration while removing the unused `feeConfigId` parameter.
- [x] Replaced the ambiguous expense-dialog listener return label with an explicit `saveExpense` label.
- [x] Upgraded Android Gradle Plugin from 8.1.0 to 8.1.4, which supports compileSdk 34.

### Verification
- [x] Ran `./gradlew clean test assembleDebug --warning-mode all` successfully.
- [x] All 78 Gradle tasks completed; debug and release unit-test variants passed and the debug APK was generated.
- [x] No Kotlin compiler, Room schema, or unsupported compileSdk warnings remain.
- [x] The only informational packaging message is that ML Kit's `libmlkit_google_ocr_pipeline.so` cannot be stripped and is packaged unchanged.

### Remaining priorities
- [ ] Test camera, OCR, document providers, PDF/CSV sharing, and WorkManager on a physical Android device.
- [ ] Add payment and expense editing, inactive-child reactivation, configurable currency, and OCR progress/preview polish.
- [ ] Choose Gmail OAuth or an authenticated backend if unattended scheduled email is required.

## Readability and color refresh - 2026-09-10

### Completed
- [x] Replaced the muted palette with an explicit high-contrast teal light theme and defined foreground colors for primary, secondary, surface, outline, and error roles.
- [x] Made the app use a consistent light theme so text does not lose contrast when the phone is in dark mode.
- [x] Added scalable 16sp body, 18sp prominent body, 24sp title, and 26sp heading styles using Android's system sans-serif font.
- [x] Applied larger typography and improved line spacing to dashboard totals, transaction rows, report summaries, settings status, empty states, and section headings.
- [x] Added explicit toolbar title contrast and checked/unchecked bottom-navigation colors.
- [x] Darkened paid, partial, and unpaid status colors for improved readability on the light surface.

### Verification
- [x] Ran `./gradlew clean test assembleDebug --warning-mode all` successfully after the resource and Kotlin updates.
- [x] All 78 Gradle tasks completed, both unit-test variants passed, and a refreshed debug APK was generated.
- [x] No Android resource-linking or Kotlin compiler warnings remain; ML Kit's native OCR library continues to be packaged unchanged because it cannot be stripped.

## English/Czech localization - 2026-09-10

### Completed
- [x] Kept the original English resource catalog in `app/src/main/res/values/strings.xml`.
- [x] Added a complete matching Czech draft catalog in `app/src/main/res/values-cs/strings.xml` for direct native-speaker editing.
- [x] Configured Czech and English as supported application locales and made Czech the initial language when no preference has been saved.
- [x] Added a Language section in Settings with English and Czech choices.
- [x] Used AndroidX per-app locales so the selection persists and updates the interface immediately.
- [x] Replaced user-visible hardcoded backup messages and report headings with localized resources.
- [x] Localized generated CSV headers and PDF labels according to the active app language.

### Translation maintenance
- [x] Verified that the English and Czech catalogs contain exactly the same 81 resource keys.
- [ ] Review and refine the Czech wording in `app/src/main/res/values-cs/strings.xml`; resource names and `%1$s` placeholders must remain unchanged.

### Verification
- [x] Ran `./gradlew test assembleDebug --warning-mode all` successfully after stopping stale Gradle daemons that temporarily held build-output files open.
- [x] All 76 executed Gradle tasks completed, both unit-test variants passed, and the localized debug APK was generated.

## Expanded expense records - 2026-09-10

### Completed
- [x] Added a required paper receipt count number to each new expense for matching app records to physical receipts.
- [x] Added a required supplier name and an optional note while retaining date, amount, and description.
- [x] Removed category from the expense-entry form; existing storage compatibility is retained internally with the neutral `other` value.
- [x] Updated receipt OCR so the probable merchant name fills the supplier field rather than the description.
- [x] Updated expense list rows to show count number, date, amount, supplier, description, and note.
- [x] Updated CSV and PDF exports with the expanded expense fields.
- [x] Added a Room 1→2 migration with non-destructive defaults, preserving existing installed-app data.
- [x] Kept JSON backup compatibility: older backups restore with blank values for fields they do not contain.
- [x] Added matching English and Czech resource strings; both catalogs still contain the same 81 keys.

### Verification
- [x] Ran `./gradlew clean test assembleDebug --warning-mode all` successfully after the schema and UI changes.
- [x] Re-ran `./gradlew test assembleDebug --warning-mode all` after eliminating the migration override warning.
- [x] Debug and release unit-test variants passed and the updated debug APK was generated without source or resource warnings.

## Mandatory receipt-first OCR workflow - 2026-09-10

### Completed
- [x] Changed both Add Payment and Add Expense to launch the system camera before opening any entry form.
- [x] Open the editable confirmation form only after the camera returns a non-empty receipt image.
- [x] Run on-device OCR automatically, show recognition progress/result, and ask the user to review or correct extracted values.
- [x] Added an optional payment note so additional information can be entered after OCR review; expense notes remain supported.
- [x] Block saving while OCR is running or when the receipt image is missing/unreadable.
- [x] Mark newly saved payment and expense records as scanned rather than manual entries.
- [x] Allow the required image to be retaken from the confirmation form, deleting the superseded unsaved image.
- [x] Delete unsaved receipt images when the form is cancelled or its fragment is destroyed.
- [x] Added matching English and Czech text for the receipt requirement, OCR state, confirmation screens, and retake action.

### Receipt-inclusive backup
- [x] Upgraded JSON backups to format version 2 and embedded each payment/expense receipt as Base64 data.
- [x] Reject backup creation if any current record lacks a readable image, rather than producing an incomplete backup.
- [x] Restore embedded images into app-private storage and assign the new local paths to restored records.
- [x] Validate that every format-version-2 payment and expense has a corresponding embedded image.
- [x] Continue accepting legacy format-version-1 backups for backward compatibility.

### Tests and verification
- [x] Added `ReceiptBackupCodecTest` for byte-for-byte image encode/restore and empty-image rejection.
- [x] Verified that English and Czech localization catalogs contain the same 90 keys.
- [x] Ran `./gradlew clean test assembleDebug --warning-mode all` successfully; all 78 tasks completed, debug and release unit tests passed, and the debug APK was generated.

## Layout-aware Czech payment receipt OCR - 2026-09-10

### Completed
- [x] Specialized payment-receipt parsing around the standard Czech cash-receipt labels `Doklad číslo`, `Přijato od`, and `Celkem`.
- [x] Extract the handwritten receipt order number, payer name, whole-crown amounts such as `1800,-`, and dates with two-digit years or spaces around separators.
- [x] Match the OCR payer name against active children without case or Czech-diacritic sensitivity and automatically select the matching child.
- [x] Added an editable, required payment receipt-number field and persist it in Room, JSON backups, and payment list rows.
- [x] Added the non-destructive Room 2→3 migration for existing installations.
- [x] Added focused parser tests modeled on the supplied `PŘÍJMOVÝ POKLADNÍ DOKLAD` receipt and label/value OCR variations.

### Verification
- [x] Ran the focused debug `ReceiptParserTest` suite successfully; all five parser tests passed.
- [x] Stopped stale Gradle daemons and removed locked build output after the initial clean task could not delete `app/build`.
- [x] Ran `./gradlew test assembleDebug --no-daemon --warning-mode all` successfully; all 76 tasks executed, debug and release unit tests passed, and the updated debug APK was generated.
- [x] No source, Room, resource-linking, or compile-SDK warnings were reported; ML Kit's native OCR library was packaged unchanged because it cannot be stripped.

## Physical receipt OCR correction - 2026-09-10

### Device finding
- [x] Physical-device testing showed that full-page OCR read the preprinted serial `7430766` as the receipt number and missed the faint handwritten amount, while payer matching and date extraction succeeded.

### Completed
- [x] Replaced nearby text-order assumptions with ML Kit line bounding-box analysis for the fixed payment form.
- [x] Added targeted enlarged grayscale/high-contrast OCR passes for the handwritten receipt-number, payer-name, and total-amount regions.
- [x] Limited receipt order numbers to one through four digits so the large seven-digit preprinted form serial cannot be accepted.
- [x] Retained full-page and generic parser fallbacks for photos where one or more printed anchors are not detected.
- [x] Added regression coverage for spatial field extraction, the `7430766` serial conflict, and targeted-region OCR overrides.

### Verification pending
- [x] Ran the focused debug `ReceiptParserTest` suite successfully; all seven parser tests passed.
- [x] Ran `./gradlew test assembleDebug --no-daemon --warning-mode all` successfully; debug and release unit tests passed and the corrected debug APK was generated.

## Handwriting color separation and fee validation - 2026-09-10

### Device finding
- [x] A second physical-device run improved localization but read the handwritten receipt number `3` as `9` and merged the amount with nearby form content into the impossible value `141787`.

### Completed
- [x] Added a blue/purple-ink isolation OCR pass that turns colored handwriting black while removing gray and black printed form content.
- [x] Run ink-isolated OCR before three grayscale/contrast variants for each fixed payment field.
- [x] Validate amount candidates against the configured full-year and half-year fee values.
- [x] Leave an untrustworthy amount blank instead of prefilling an impossible payment amount.
- [x] Added parser regression tests for noisy amount selection and rejection.

### Verification pending
- [x] Ran the focused debug `ReceiptParserTest` suite successfully; all ten parser tests passed.
- [x] Ran `./gradlew test assembleDebug --no-daemon --warning-mode all` successfully; debug and release unit tests passed and the updated debug APK was generated.

## OCR priority decision - 2026-09-10

### Decision
- [x] Physical-device testing confirmed that handwritten values on the standard payment receipt remain unreliable despite spatial cropping, multiple preprocessing variants, ink isolation, and fee-aware validation.
- [x] Reclassified further handwritten payment-receipt OCR accuracy work as **low priority**.
- [x] OCR remains available as a best-effort convenience, but its output is not authoritative and every result must be reviewed and corrected in the confirmation form before saving.
- [x] Further OCR model/preprocessing experimentation is not a release blocker and should follow higher-priority physical-device workflow testing and usability work.

## Payment and expense editing - 2026-09-10

### Completed
- [x] Added tap-to-edit behavior for existing payment and expense list rows while retaining long-press deletion.
- [x] Payment editing supports receipt number, child, amount, date, note, and optional receipt retake.
- [x] Expense editing supports receipt count number, date, amount, supplier, description, note, and optional receipt retake.
- [x] Existing receipt images are preserved when editing values without retaking the photo.
- [x] A replacement receipt becomes owned by the record only after the database update succeeds; cancelling removes the replacement and preserves the original image.
- [x] Recalculate payment installment classification while excluding the edited payment from the child's previous total.
- [x] Added matching English and Czech edit labels, instructions, and list interaction help.

### Verification pending
- [x] Ran `./gradlew test assembleDebug --no-daemon --warning-mode all` successfully; all 76 tasks completed, debug and release unit tests passed, and the editable-record debug APK was generated.

## XLSX spreadsheet report - 2026-09-11

### Completed
- [x] Replaced the plain CSV export with a standards-based `.xlsx` workbook generated without a heavyweight spreadsheet dependency.
- [x] Added a payment table with receipt number, child name, separate first- and second-half amount columns, and receipt photographs embedded in the workbook.
- [x] Divide full-year payments evenly across both half-year columns while placing installment payments in their recorded half-year column.
- [x] Added an expense table with physical count number, supplier, amount, description, and note.
- [x] Added a summary with active-child count, expected amount, collected amount, and current account balance after expenses.
- [x] Include inactive children when resolving names for historical payment rows while counting only active children in the summary.
- [x] Added matching English and Czech spreadsheet labels and switched Android sharing to the XLSX MIME type.
- [x] Added unit coverage for half-year allocation, workbook sections, escaped text, numeric values, and embedded receipt media.
- [x] Moved the financial summary to the top of the worksheet for immediate visibility.
- [x] Added a receipt-photo column to the expense table and embed each available expense receipt in its row.
- [x] Extended workbook tests to verify both payment and expense image media and drawing-column anchors.
- [x] Treat payments equal to the configured yearly fee as full-year payments in the spreadsheet, dividing 1,800 into 900 for the first half and 900 for the second half even when a historical record is classified as a half-year installment.
- [x] Added regression coverage for yearly-fee-sized records stored as both first- and second-half payment types.

## Matching PDF financial report - 2026-09-11

### Completed
- [x] Replaced the former text-only PDF with a landscape, table-based report that follows the XLSX structure.
- [x] Put the summary first with active-child count, expected amount, collected amount, and balance.
- [x] Added payment rows with receipt number, child name, separate half-year amounts, and embedded receipt photographs.
- [x] Reused yearly-fee allocation rules so a payment of 1,800 is displayed as 900 in each half-year column.
- [x] Added expense rows with count number, supplier, amount, description, note, and embedded receipt photographs.
- [x] Preserve image aspect ratios, downsample large source photographs, and repeat the appropriate table heading on continuation pages.
- [x] Generate PDF files on an IO coroutine rather than blocking the main UI thread.

### Verification pending
- [x] Ran `./gradlew test assembleDebug --no-daemon --warning-mode all` successfully; all 76 tasks completed, debug and release unit tests passed, and the updated debug APK was generated.
- [ ] Review pagination and photograph readability using real data on a physical device.

### Verification
- [x] Ran `./gradlew test assembleDebug --no-daemon --warning-mode all` successfully; all 76 tasks completed, including debug and release unit tests, and the debug APK was generated.
- [x] Re-ran the same full verification after moving the summary and adding expense receipt photos; all 76 tasks completed successfully.
- [x] Re-ran the full verification after correcting yearly-fee allocation across both half-year columns; all 76 tasks completed successfully.
- [ ] Open the generated workbook in Microsoft Excel or LibreOffice and verify receipt-photo sizing on a physical device.
