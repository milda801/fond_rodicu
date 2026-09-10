# Kindergarten Expense Tracker - Android App Implementation Plan

## Project Overview
Android mobile application for kindergarten expense tracking with cloud backup and automated email reporting.

**Target User**: Non-technical kindergarten teacher
**Platform**: Android (Kotlin/Java)
**Database**: Local SQLite + Cloud Backup (Google Drive/Dropbox)
**Key Features**: Receipt scanning with OCR, automatic email reports, payment status tracking

---

## 1. Technology Stack

### Frontend
- **Language**: Kotlin (modern Android development)
- **Framework**: Android Jetpack (Compose or XML layouts)
- **UI Components**: Material Design 3
- **Camera**: Android Camera2 API for receipt scanning

### Backend/Services
- **Local Database**: SQLite (Room ORM)
- **Cloud Backup**: Google Drive API or Dropbox API
- **OCR**: ML Kit Text Recognition (Google's on-device OCR)
- **Email**: Firebase Cloud Messaging or direct SMTP
- **Scheduling**: WorkManager for scheduled tasks

### Libraries
- Retrofit (API calls)
- Glide (image loading)
- Apache POI or OpenCSV (Excel/CSV generation)
- iText or PdfBox (PDF generation)
- Google ML Kit (OCR)

---

## 2. Core Features

### 2.1 Data Input
- **Child Management**: Add/edit/remove children with simple form
- **Fee Configuration**: Set yearly fee, split option (full/half-year)
- **Payment Recording**:
  - Camera capture of payment receipt
  - OCR extraction (name, amount, date)
  - Manual entry fallback
  - Confirmation before saving
- **Expense Recording**:
  - Camera capture of expense receipt
  - OCR extraction (vendor, amount, date)
  - Category selection (dropdown)
  - Manual entry fallback

### 2.2 Data Output
- **Dashboard Screen**:
  - Payment status grid (child name, paid amount, status indicator)
  - Quick stats (total collected, total expenses, balance)
  - Recent activity feed
- **Reports**:
  - Payment status report (Excel/PDF)
  - Expense breakdown report (Excel/PDF)
  - Balance sheet report (Excel/PDF)
- **Email Export**:
  - Manual export button (send now)
  - Scheduled automatic export (weekly/monthly)
  - Configurable recipient email addresses

### 2.3 Cloud Features
- **Automatic Backup**: Daily sync to Google Drive/Dropbox
- **Data Recovery**: Restore from cloud backup
- **Multi-device Sync**: Access data from multiple devices (optional)

---

## 3. Database Schema (SQLite)

```sql
-- Children table
CREATE TABLE children (
  id TEXT PRIMARY KEY,
  name TEXT NOT NULL,
  enrollment_date TEXT NOT NULL,
  status TEXT DEFAULT 'active',
  notes TEXT,
  created_at TEXT DEFAULT CURRENT_TIMESTAMP,
  updated_at TEXT DEFAULT CURRENT_TIMESTAMP
);

-- Fee configurations
CREATE TABLE fee_configurations (
  id TEXT PRIMARY KEY,
  academic_year TEXT NOT NULL,
  yearly_fee_amount REAL NOT NULL,
  split_option TEXT DEFAULT 'full_year',
  first_half_due_date TEXT,
  second_half_due_date TEXT,
  created_at TEXT DEFAULT CURRENT_TIMESTAMP
);

-- Payments
CREATE TABLE payments (
  id TEXT PRIMARY KEY,
  child_id TEXT NOT NULL,
  fee_config_id TEXT NOT NULL,
  amount REAL NOT NULL,
  payment_date TEXT NOT NULL,
  payment_type TEXT NOT NULL,
  receipt_path TEXT,
  ocr_name TEXT,
  ocr_amount REAL,
  manual_entry INTEGER DEFAULT 0,
  notes TEXT,
  created_at TEXT DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY(child_id) REFERENCES children(id),
  FOREIGN KEY(fee_config_id) REFERENCES fee_configurations(id)
);

-- Expenses
CREATE TABLE expenses (
  id TEXT PRIMARY KEY,
  expense_date TEXT NOT NULL,
  category TEXT NOT NULL,
  description TEXT NOT NULL,
  amount REAL NOT NULL,
  receipt_path TEXT,
  ocr_vendor TEXT,
  ocr_amount REAL,
  ocr_date TEXT,
  manual_entry INTEGER DEFAULT 0,
  notes TEXT,
  created_at TEXT DEFAULT CURRENT_TIMESTAMP
);

-- Sync metadata
CREATE TABLE sync_metadata (
  id TEXT PRIMARY KEY,
  last_sync_time TEXT,
  last_backup_time TEXT,
  cloud_provider TEXT,
  sync_status TEXT
);
```

---

## 4. UI/UX Screens

### 4.1 Main Navigation (Bottom Tab Bar)
1. **Dashboard** - Home screen with payment status and quick stats
2. **Payments** - Add/view payments
3. **Expenses** - Add/view expenses
4. **Reports** - View and export reports
5. **Settings** - Configuration and cloud backup

### 4.2 Screen Details

**Dashboard Screen**
- Header: Current academic year, total stats
- Payment Status Grid: Child name, paid amount, status (✓/⚠/✗)
- Recent Activity: Latest 5 transactions
- Action Buttons: Add Payment, Add Expense

**Payment Screen**
- List of all payments (sorted by date)
- "Add Payment" button
- Payment entry form:
  - Child selector (dropdown)
  - Amount input
  - Payment type (full/half)
  - Receipt upload (camera/gallery)
  - OCR preview (if receipt uploaded)
  - Manual entry option
  - Save button

**Expense Screen**
- List of all expenses (sorted by date)
- "Add Expense" button
- Expense entry form:
  - Date picker
  - Category selector (dropdown)
  - Description input
  - Amount input
  - Receipt upload (camera/gallery)
  - OCR preview (if receipt uploaded)
  - Manual entry option
  - Save button

**Reports Screen**
- Report type selector (Payment Status / Expenses / Balance Sheet)
- Preview of selected report
- Export buttons:
  - Export to Excel
  - Export to PDF
  - Send via Email
- Scheduled export settings

**Settings Screen**
- Cloud backup configuration
  - Provider selection (Google Drive / Dropbox)
  - Login/logout
  - Last backup time
  - Manual backup button
- Email configuration
  - Recipient email addresses
  - Scheduled export frequency (weekly/monthly)
  - Enable/disable automatic emails
- Data management
  - Import/export database
  - Clear all data (with confirmation)

---

## 5. OCR Integration

### 5.1 Implementation
- **Library**: Google ML Kit Text Recognition (on-device, no internet required)
- **Process**:
  1. User captures receipt photo
  2. ML Kit extracts text from image
  3. Parse extracted text for:
     - Payment receipts: name, amount, date
     - Expense receipts: vendor, amount, date
  4. Display extracted data for user confirmation
  5. Allow manual correction before saving

### 5.2 Accuracy Handling
- Show confidence score for extracted data
- Highlight uncertain fields for manual review
- Always allow manual override

---

## 6. Cloud Backup & Sync

### 6.1 Google Drive Integration
- Backup entire SQLite database daily
- Store as encrypted JSON backup file
- Restore from backup on app reinstall
- Manual backup/restore buttons

### 6.2 Dropbox Integration (Alternative)
- Similar to Google Drive
- Automatic sync option
- Version history for recovery

### 6.3 Sync Strategy
- Daily automatic backup at 2 AM
- Manual backup button in settings
- Restore option with date selection
- Conflict resolution (keep local/cloud version)

---

## 7. Email Export & Scheduling

### 7.1 Report Generation
- Generate Excel files with:
  - Payment status table
  - Expense breakdown
  - Balance sheet
  - Charts/visualizations
- Generate PDF reports with formatted layout

### 7.2 Email Delivery
- **Manual Export**: User clicks "Send Report" button
- **Scheduled Export**: 
  - Weekly (every Monday at 9 AM)
  - Monthly (first day of month at 9 AM)
  - Configurable in settings
- **Recipients**: Multiple email addresses (comma-separated)
- **Email Content**:
  - Summary statistics
  - Attached Excel/PDF files
  - Professional template

### 7.3 Implementation
- Use Firebase Cloud Messaging or direct SMTP
- WorkManager for scheduled tasks
- Notification when email sent successfully

---

## 8. Implementation Phases

### Phase 1: MVP (Core Functionality)
- [x] Project setup and dependencies
- [ ] Database schema and Room ORM
- [ ] Child management (CRUD)
- [ ] Manual payment entry
- [ ] Manual expense entry
- [ ] Basic dashboard
- [ ] Simple balance sheet

### Phase 2: Camera & OCR
- [ ] Camera integration
- [ ] Receipt capture
- [ ] ML Kit OCR integration
- [ ] OCR data extraction and preview
- [ ] Manual correction UI

### Phase 3: Cloud & Export
- [ ] Google Drive integration
- [ ] Automatic daily backup
- [ ] Excel/PDF report generation
- [ ] Email integration
- [ ] Scheduled email reports

### Phase 4: Polish & Release
- [ ] UI/UX refinements
- [ ] Error handling and validation
- [ ] Performance optimization
- [ ] Testing and bug fixes
- [ ] Release build and signing

### Development Environment
- [x] Add a VS Code Dev Container based on Ubuntu 22.04.
- [x] Provision JDK 17, Gradle 8.0.2, Android SDK Platform 34, Build Tools 34.0.0, and platform tools.
- [x] Add and retain the Gradle wrapper for reproducible builds.
- [x] Persist the Gradle dependency cache in a Docker volume.
- [x] Run the complete unit-test and debug-APK build inside the Dev Container.
- [x] Upgrade to Android Gradle Plugin 8.1.4 for supported compileSdk 34 builds.
- [x] Add Room indexes for payment foreign keys and clear the remaining Kotlin compiler warnings.

---

## 9. Project Structure

```
kindergarten-expense-tracker/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/skolka/expensetracker/
│   │   │   │   ├── ui/
│   │   │   │   │   ├── dashboard/
│   │   │   │   │   ├── payments/
│   │   │   │   │   ├── expenses/
│   │   │   │   │   ├── reports/
│   │   │   │   │   └── settings/
│   │   │   │   ├── data/
│   │   │   │   │   ├── database/
│   │   │   │   │   ├── repository/
│   │   │   │   │   └── models/
│   │   │   │   ├── services/
│   │   │   │   │   ├── ocr/
│   │   │   │   │   ├── backup/
│   │   │   │   │   ├── email/
│   │   │   │   │   └── export/
│   │   │   │   ├── utils/
│   │   │   │   └── MainActivity.kt
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       ├── drawable/
│   │   │       ├── values/
│   │   │       └── menu/
│   │   └── test/
│   └── build.gradle
├── build.gradle
└── README.md
```

---

## 10. Dependencies (build.gradle)

```gradle
dependencies {
    // Android Jetpack
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'com.google.android.material:material:1.9.0'
    
    // Room Database
    implementation 'androidx.room:room-runtime:2.6.1'
    kapt 'androidx.room:room-compiler:2.6.1'
    
    // Lifecycle
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.6.1'
    
    // ML Kit OCR
    implementation 'com.google.mlkit:text-recognition:16.0.0'
    
    // Google Drive API
    implementation 'com.google.api-client:google-api-client-android:1.35.2'
    implementation 'com.google.apis:google-api-services-drive:v3-rev20230815-2.0.0'
    
    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    
    // Glide
    implementation 'com.github.bumptech.glide:glide:4.15.1'
    kapt 'com.github.bumptech.glide:compiler:4.15.1'
    
    // Excel/CSV
    implementation 'org.apache.poi:poi:5.2.3'
    implementation 'org.apache.poi:poi-ooxml:5.2.3'
    
    // PDF
    implementation 'com.itextpdf:itext7-core:7.2.5'
    
    // WorkManager
    implementation 'androidx.work:work-runtime-ktx:2.8.1'
    
    // Testing
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}
```

---

## 11. Key Considerations

### Security
- Encrypt sensitive data (payment amounts, child names)
- Secure cloud backup with authentication
- HTTPS for all API calls
- No hardcoded credentials

### Performance
- Lazy load images
- Optimize database queries
- Cache frequently accessed data
- Compress backup files

### User Experience
- Intuitive navigation
- Clear error messages
- Confirmation dialogs for destructive actions
- Offline-first approach (works without internet)
- Automatic sync when online

### Accessibility
- [x] Large touch targets
- [x] High-contrast light palette with explicit foreground colors
- [x] Readable 16-18sp body text and bold 24-26sp headings
- [x] Support for system text size settings through scalable `sp` typography
- [ ] Complete text descriptions for all meaningful images and controls

---

## 12. Next Steps

1. Test camera, OCR, backup providers, report sharing, and WorkManager on a physical Android device.
2. Complete the remaining usability enhancements listed in `PROGRESS_LOG.md`.
3. Choose Gmail OAuth or an authenticated backend only if unattended scheduled email is required.
4. Prepare, sign, and test the release build.
