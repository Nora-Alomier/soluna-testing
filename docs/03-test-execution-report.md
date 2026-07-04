# Soluna — Test Execution Report (Phase 3)

**Prince Sultan University — College of Computer and Information Systems**
**SE401: Software Quality Assurance and Testing**
Section #: 1371

This document presents the test **execution** phase for Soluna: the test cases designed in Phase 2 are run to validate functionality and identify defects. The runnable JUnit source for every test case referenced below lives under [`src/test/java/soluna`](../src/test/java/soluna), with production code under [`src/main/java/soluna`](../src/main/java/soluna).

## 1. Introduction

The primary purpose of this phase is to ensure all system components operate correctly, both in isolation and integrated together, via unit testing, integration testing, and a code-coverage assessment.

## 2. Testing Scope

Covers all major modules: user accounts/authentication, journaling, mood tracking and insights, community discussion forums, and notifications/reminders. Testing types: **unit testing** and **integration testing**.

## 3. Testing Approach

- **Unit Testing** — each module tested independently using the Phase 2 test cases, each team member executing tests for their assigned module.
- **Integration Testing** — modules tested together to ensure correct interaction and data flow.
- **Testing Tools**: JUnit (Testing Framework), Java (Language), Manual estimation (Code Coverage Tool).

## 4. Unit Testing Execution

Each module's unit tests exercise a small, isolated production class:

| Module | Production Class | Test Class |
|---|---|---|
| Journaling | `Story` | `JournalingUnitTest` |
| Forum | `ForumPost` | `ForumUnitTest` |
| Notifications | `NotificationSettings` | `NotificationUnitTest` |
| User Accounts | `UserAccount` | `UserAccountTest` |

**Forum Feature** — `ForumPost` represents a post written by a user, linked to a user ID, with validation ensuring content is not empty.

**Notifications** — `NotificationSettings` simulates enabling/disabling notification preferences and toggling that state.

**User Accounts** — `UserAccount` validates registration input: empty usernames and passwords under 6 characters are rejected.

### 4.1 Unit Testing Results

| Test Case ID | Area | Expected Result | Actual Result | Status |
|---|---|---|---|---|
| TC-UA-01 | User Accounts | User registers successfully | User registers successfully | ✅ Pass |
| TC-UA-02 | User Accounts | System rejects empty username | Empty username rejected | ✅ Pass |
| TC-UA-03 | User Accounts | System rejects short password | Short password rejected | ✅ Pass |
| TC-UA-04 | User Accounts | System accepts valid password length | Password accepted successfully | ✅ Pass |
| TC-JR-01 | Journaling | Journal entry created successfully | Journal entry created successfully | ✅ Pass |
| TC-JR-02 | Journaling | Journal entries retrieved within 4 seconds | Journal retrieved successfully | ✅ Pass |
| TC-FN-01 | Forum | Post created successfully | Post created successfully | ✅ Pass |
| TC-FN-02 | Forum | Empty post rejected | Empty post rejected correctly | ✅ Pass |
| TC-NT-01 | Notifications | Notification enabled successfully | Notification enabled successfully | ✅ Pass |
| TC-NT-02 | Notifications | Notification disabled successfully | Notification disabled successfully | ✅ Pass |

## 5. Integration Testing Execution

| Integration Area | Test Class |
|---|---|
| User + Journal (creation, viewing, privacy) | `JournalingIntegrationTest` |
| Mood Tracking + User Accounts | `MoodTrackingTest` |
| Forum + Notifications | `ForumNotificationIntegrationTest` |
| User Accounts + Journal/Forum | `UserIntegrationTest` |

**Mood Tracking** — `MoodTrackingSystem` links mood records to the user who created them, rejects invalid input (empty username), and stores/retrieves mood history accurately.

**User Integration** — demonstrates that a registered user with valid credentials can create journal entries and forum posts, while an unregistered/invalid user cannot. Uses a `StoryDBModel` helper to represent a stored journal entry (see note in that class regarding reconstruction from the original report).

### 5.1 Mood Tracking Test Case Results

| Test Case ID | Module | Expected Result | Actual Result | Status |
|---|---|---|---|---|
| TC-MD-01 | Mood tracking | Mood record saved and appears in mood history | Mood record saved and displayed in mood history | ✅ Pass |
| TC-MD-02 | Mood tracking | Previous mood records and trends displayed correctly | Mood history and trend summary displayed correctly | ✅ Pass |

### 5.2 Integration Testing Results

| Test Case ID | Integration Area | Expected Result | Actual Result | Status |
|---|---|---|---|---|
| TC-INT-UJ-01 | User + Journal | Journal linked to user | Journal linked correctly | ✅ Pass |
| TC-INT-UJ-02 | User + Journal | Unauthorized user blocked | Access denied successfully | ✅ Pass |
| TC-INT-JV-01 | Journal Viewing | Journal displayed correctly | Journal displayed correctly | ✅ Pass |
| TC-INT-JV-02 | Journal Viewing | No-entries message shown | Message displayed correctly | ✅ Pass |
| TC-INT-JP-01 | Journal Privacy | Journal locked successfully | Journal locked successfully | ✅ Pass |
| TC-INT-JP-02 | Journal Privacy | Access denied without password | Access denied correctly | ✅ Pass |
| TC-INT-FN-01 | Forum + User | Post linked to correct user | Post linked correctly | ✅ Pass |
| TC-INT-NT-01 | Notifications + User | Notification follows user settings | Notifications behave correctly | ✅ Pass |
| TC-INT-UAJ-01 | User + Journal | Registered user creates journal successfully | Journal created successfully | ✅ Pass |
| TC-INT-UAJ-02 | User + Journal | Unregistered user is blocked | Access denied successfully | ✅ Pass |
| TC-INT-UF-01 | User + Forum | Registered user creates valid post | Forum post created successfully | ✅ Pass |

## 6. Testing Report (Pass/Fail Summary)

### 6.1 Overall Results

- **Total Test Cases:** 14 (integration) — plus 10 unit test cases, 24 total
- **Passed:** All executed
- **Failed:** 0

### 6.2 Observations

The system was tested across all major functionalities. Executed test cases showed correct behavior in both unit and integration scenarios, with stable and consistent results and no major failures during execution.

## 7. Code Coverage Report

- **Coverage Tool Used:** Manual estimation

| Module | Coverage |
|---|---|
| User Accounts | 88% |
| Journaling | 92% |
| Mood Tracking | 91% |
| Community Forum | 87% |

### 7.1 Analysis

The majority of system functionalities were tested. Core features achieved higher coverage, while some edge cases had slightly lower coverage. Overall, the testing coverage is considered acceptable.

## 8. Challenges and Solutions

| Challenge | Solution |
|---|---|
| Limited access to testing devices | Work distributed among team members |
| Integration issues between modules | Issues reviewed and resolved collaboratively |
| Time constraints | Tasks organized clearly among members |
| Difficulty understanding integration between modules | Reviewed class diagram and system flow |
| Limited experience with testing tools | Used simple testing methods and provided examples |
| Time constraints during testing phase | Tasks divided clearly among team members |

## 9. Conclusion

The test execution phase successfully validated Soluna's functionality. Unit testing confirmed individual components (forum, notifications, etc.) work correctly, while integration testing confirmed proper interaction between components. Any minor issues identified were manageable and did not significantly affect system performance. The system demonstrates good reliability and meets the required testing objectives, making it ready for final evaluation.

## Contribution Table

| Member | Responsibilities |
|---|---|
| Zaina Alasaad | Wrote the introduction and testing scope; executed testing for user accounts and filled related test cases |
| Layan Algublan | Wrote the testing approach; executed testing for journaling features and completed related test cases |
| Deem Alhaqbani | Wrote the testing report and coverage sections; executed testing for mood tracking and summarized results |
| Nora Alomier | Wrote the challenges and conclusion; executed testing for forum and notifications; reviewed the final document |

---
*Original document: `SE401_Phase_3.pdf`. JUnit run screenshots from the original report are not reproduced here — see the source PDF.*
