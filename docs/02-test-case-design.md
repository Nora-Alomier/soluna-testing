# Soluna — Test Case Design (Phase 2)

**Prince Sultan University — College of Computer and Information Systems**
**SE401: Software Quality Assurance and Testing**
Section #: 1371

This document defines the unit, integration, and system-level test cases designed for the Soluna application, along with the SRS partitioning approach and test-design techniques used. The code implementations of the test cases described here live in [`src/test/java/soluna`](../src/test/java/soluna); execution results are in [`03-test-execution-report.md`](./03-test-execution-report.md).

## 1. Unit Testing

### 1.1 User Accounts

**TC-UA-01 — Register User with Valid Credentials**
- Requirement: FR4.1.1
- Preconditions: User has not registered yet
- Steps: Access registration page → select sign in/sign up → enter valid credentials → click register
- Expected: Account successfully created; user directed to main dashboard
- Type: Functional, normal conditions

**TC-UA-02 — Register User with Weak Password**
- Requirement: NF1 (strong password enforcement)
- Preconditions: User has not registered yet
- Steps: Enter valid username/email → enter weak password → click register
- Expected: Password validation error displayed; account not created
- Type: Negative test

**TC-UA-03 — Login with Valid OTP**
- Requirement: FR4.1.2 (two-step authentication)
- Preconditions: Account exists, 2FA enabled
- Steps: Login with valid credentials → enter valid OTP → click verify
- Expected: User successfully logs in
- Type: Functional

### 1.2 Journaling

**TC-JR-01 — Create Journal Entry**
- Requirement: FR4.2.1
- Preconditions: User logged in
- Steps: Click "New Journal" → enter content → click save
- Expected: Confirmation message displayed; journal saved successfully
- Type: Functional

**TC-JR-02 — Retrieve Journal**
- Requirement: NF6 (4-second retrieval)
- Preconditions: User has previously saved journal entries
- Steps: Open journal page → click a saved journal
- Expected: Journal entries displayed within 4 seconds
- Type: Performance test

### 1.3 Mood Tracking

**TC-MD-01 — Record Daily Mood, Valid Input**
- Requirement: FR4.3.1
- Preconditions: User logged in
- Steps: Navigate to mood tracking page → select a mood value → click save
- Expected: Mood record saved successfully and appears in mood history
- Type: Functional, normal conditions

**TC-MD-02 — View Mood History and Trends**
- Requirement: FR4.3.2
- Preconditions: User logged in, mood records exist
- Steps: Navigate to mood tracking history page → view records and trend summary
- Expected: Previous mood records and trends displayed correctly
- Type: Functional, normal conditions

### 1.4 Notifications and Reminders

**TC-NR-01 — Disable Notifications**
- Requirement: FR4.4.1
- Preconditions: User logged in, notifications currently enabled
- Steps: Open settings → turn off notifications → save changes
- Expected: Notifications disabled; setting remains off after reopening
- Type: Functional, normal conditions

### 1.5 Preferences and Privacy

**TC-PR-01 — Update Privacy Setting Successfully**
- Requirement: FR4.5.1
- Preconditions: User logged in, preferences page accessible
- Steps: Navigate to preferences → change journal privacy from public to private → click save
- Expected: Updated setting saved successfully and persists on reopen
- Type: Functional, normal conditions

## 2. Integration Testing

### 2.1 User and Journal Integration

**TC-INT-UJ-01 — Logged-in User Creates Journal Entry**
- Requirements: FR4.1.1, FR4.2.1
- Steps: Login → navigate to Journal page → enter title/content → click save
- Expected: Journal entry saved and linked to logged-in user ID
- Type: Positive test

**TC-INT-UJ-02 — Unauthorized User Cannot Create Journal Entry**
- Requirements: FR4.1.1, NFR5 (access control)
- Preconditions: User not logged in
- Steps: Navigate to journal page → attempt to create entry → click save
- Expected: Access denied; redirected to login page
- Type: Negative test

### 2.2 Journal Viewing Integration

**TC-INT-JV-01 — User Views Previous Journal Entries**
- Requirement: FR4.2.2
- Steps: Login → navigate to journal history → select an entry
- Expected: Selected journal entry retrieved and displayed correctly
- Type: Positive test

**TC-INT-JV-02 — Journal Retrieval Without Saved Entries**
- Requirement: FR4.2.2
- Preconditions: User logged in, no journal entries exist
- Steps: Navigate to journal history
- Expected: "No entries available" message displayed
- Type: Negative test

### 2.3 Journal Privacy Integration

**TC-INT-JP-01 — User Locks Journal for Privacy**
- Requirement: FR4.2.3
- Steps: Open journal entry → select lock option → confirm lock
- Expected: Entry becomes inaccessible without authentication
- Type: Positive test

**TC-INT-JP-02 — Access Locked Journal Without Password**
- Requirement: FR4.2.4
- Preconditions: Journal is locked
- Steps: Attempt to open locked journal without a password
- Expected: Access denied; password requested
- Type: Negative test

### 2.4 Forum and User Integration

**TC-INT-FU-01 — User Creates Forum Post**
- Requirements: FR4.4.1, FR4.4.3
- Steps: Login → navigate to forum → enter post content → click post
- Expected: Post published and linked to user profile
- Type: Positive test

**TC-INT-FU-02 — Comment Linked to Correct Forum Post**
- Requirement: FR4.4.3
- Preconditions: User logged in, forum post exists
- Steps: Open forum post → enter comment → click submit
- Expected: Comment stored and linked to the correct post and user
- Type: Positive test

### 2.5 Mood and Weekly Report Integration

**TC-INT-MR-01 — Weekly Mood Report Generated from Mood Records**
- Requirements: FR4.3.1, FR4.3.2
- Preconditions: Mood records exist for multiple days
- Steps: Record moods for several days → open weekly report/insights section → generate/view report
- Expected: Weekly report generated with correct mood history/trend summary
- Type: Positive test

### Integration Testing Strategy

1. **Top-Down Testing** — test high-level modules first.
2. **Bottom-Up Testing** — test lower-level services first.

Since Soluna has multiple connected modules (AI, forum, journaling, mood tracking), combining top-down and bottom-up testing ensures full coverage.

3. **Interface Testing** — verifies communication between modules (API calls, service interactions, data exchange).
4. **Data Flow Testing** — ensures data moves correctly: User → Journal → AI Insight; Mood → AI Insight; User → Forum → Database.

## 3. System Functional Test Cases

| ID | Name | Requirement | Input | Expected Output |
|---|---|---|---|---|
| TC-SF-01 | End-to-End User Registration and Login | FR4.1.1 | Valid username, email, strong password | Account created; user reaches dashboard |
| TC-SF-02 | Register with Weak Password (Validation) | NFR1 | Valid username/email + weak password | Validation error shown; account not created |
| TC-SF-03 | Login Using Two-Step Authentication (OTP) | FR4.1.2, NFR2 | Valid credentials + valid OTP | Login succeeds only after OTP verification |
| TC-SF-04 | Create Journal and Verify in History | FR4.2.1, FR4.2.2 | Valid, non-empty journal text | Journal saved, visible in list, opens correctly |
| TC-SF-05 | Save Journal Within 15 Seconds | NFR3 | Valid journal text + click Save | Journal saved within 15 seconds |
| TC-SF-06 | Lock Journal and Deny Access Without Password | FR4.2.3, FR4.2.4 | Lock enabled; open without password | Access denied; password prompt shown |
| TC-SF-07 | Unlock Locked Journal Using Correct Password | FR4.2.4 | Correct lock password | Locked journal opens successfully |
| TC-SF-08 | Retrieve Journal Within 4 Seconds | NFR6 | Select an existing journal entry | Journal displayed within 4 seconds |
| TC-SF-09 | Record Mood and View Updated History/Trends | FR4.3.1, FR4.3.2 | Select valid mood value and save | Mood saved, appears in history, trends update |
| TC-SF-10 | Create Forum Post and Reply | FR4.4.1, FR4.4.3 | Valid post content + valid reply content | Post published; reply linked under correct post |

*(Each entry above also specifies Test Items, External/Environmental Conditions, and Special Requirements — see the original Phase 2 PDF for the full field-by-field specification tables.)*

## 4. Dividing and Partitioning the SRS for Testing

The SRS was divided into clear functional sections based on Soluna's main features: user accounts and authentication, journal management, mood tracking, community interaction, notifications, privacy and security, and administration. This partitioning organizes the testing work so each system function is tested separately and clearly.

Each requirement group was connected to related components in the class diagram — e.g., journal requirements link to `Story`, `StoryContent`, `StoryPage`; mood tracking relates to `MoodLog` and `AIInsight`; community interaction relates to `CommunityPost` and `Comment`. This traceability ensures every requirement is verified through at least one test case.

### Techniques Used to Design the Test Cases

- **Equivalence Partitioning** — divides input data into valid/invalid groups to reduce redundant cases while maintaining coverage.
- **Boundary Value Analysis** — tests values at the edges of allowed input ranges (before, at, and after the boundary), since errors commonly appear there.
- **Decision Table Testing** — used for features depending on multiple conditions (privacy settings, authentication rules, notification behavior).
- **State Transition Testing** — verifies how the system moves between states (login/logout, locked/unlocked journals, enabled/disabled notifications).

Using these techniques together improves test accuracy, increases coverage, and supports reliable verification of system behavior prior to deployment.

## Contribution Table

| Zaina Alasaad | Layan Algublan | Deem Alhaqbani | Nora Alomier |
|---|---|---|---|
| Functional testing | System functional testing | Integration Testing | Dividing and Partitioning the SRS for Testing |

---
*Original document: `SE401-Phase_2.pdf`*
