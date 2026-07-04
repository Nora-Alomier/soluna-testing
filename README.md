# Soluna — Software Quality Assurance & Testing Project

**SE401: Software Quality Assurance and Testing**
Prince Sultan University — College of Computer and Information Systems
Section #: 1371
Instructor: Dr. Reem Alsuhaibani

Soluna is a digital mental wellness application (journaling, mood tracking, community forums, and AI-driven insights). This repository contains the **testing artifacts** produced across three project phases: test planning, test case design, and test execution — plus the runnable JUnit test suite itself.

> This is a testing/QA deliverable, not the Soluna application. It documents *how* Soluna was tested and provides an executable test suite over minimal stand-in implementations of the modules under test.

## Repository Structure

```
soluna-testing/
├── docs/
│   ├── 01-test-plan.md              # Phase 1 — scope, requirements, risks, resources, schedule
│   ├── 02-test-case-design.md       # Phase 2 — unit/integration/system test case specifications
│   └── 03-test-execution-report.md  # Phase 3 — execution results, pass/fail summary, coverage
├── src/
│   ├── main/java/soluna/            # Minimal production classes exercised by the tests
│   │   ├── Story.java
│   │   ├── ForumPost.java
│   │   ├── NotificationSettings.java
│   │   ├── UserAccount.java
│   │   ├── JournalService.java
│   │   ├── StoryDBModel.java
│   │   └── mood/
│   │       ├── User.java
│   │       ├── MoodRecord.java
│   │       └── MoodTrackingSystem.java
│   └── test/java/soluna/
│       ├── unit/                    # One test class per module
│       │   ├── UserAccountTest.java
│       │   ├── JournalingUnitTest.java
│       │   ├── ForumUnitTest.java
│       │   └── NotificationUnitTest.java
│       └── integration/             # Cross-module interaction tests
│           ├── JournalingIntegrationTest.java
│           ├── MoodTrackingTest.java
│           ├── ForumNotificationIntegrationTest.java
│           └── UserIntegrationTest.java
├── pom.xml
└── .gitignore
```

### Why this layout

- **`docs/` is separated by phase, not merged into one file.** Each phase (plan → test case design → execution report) is a distinct deliverable with its own audience and purpose; keeping them as separate, cross-linked Markdown files makes each easy to review and cite on its own, while still reading as one coherent project.
- **Test code is separated from documentation.** The Phase 3 report originally embedded all JUnit source inline; here it's extracted into a real, compilable `src/main` + `src/test` Maven layout, mirroring how a testing project is actually organized and version-controlled on GitHub.
- **`unit/` vs `integration/`** mirrors the Phase 2/3 documents' own test-level breakdown (unit → integration → system), so a reader can trace any test case ID (e.g. `TC-INT-UJ-01`) straight to its markdown spec, its execution result, and its Java implementation.

## Test Levels Covered

| Level | Description | Where |
|---|---|---|
| Unit | Each module (`Story`, `ForumPost`, `NotificationSettings`, `UserAccount`) tested in isolation | `src/test/java/soluna/unit` |
| Integration | Cross-module interactions (User↔Journal, User↔Forum, Mood↔User, Forum↔Notifications) | `src/test/java/soluna/integration` |
| System | End-to-end functional scenarios (registration, OTP login, journal lock/unlock, forum reply) | Specified in `docs/02-test-case-design.md` (Section 3) |

## Requirements Traceability

Every test case traces back to a functional (`FR#.#.#`) or nonfunctional (`NFR#`) requirement defined in `docs/01-test-plan.md`. Test case IDs are consistent across all three documents and the code, e.g.:

- `TC-UA-01` → user registration → `UserAccountTest.TC_UA_01_CreateValidUserAccount`
- `TC-INT-UJ-02` → unauthorized journal creation blocked → `JournalingIntegrationTest.TC_INT_UJ_02_UnauthorizedUserCannotCreateJournal`

## Running the Tests

Requires **Java 17+** and **Maven**.

```bash
mvn test
```

This runs both the JUnit 5 (Jupiter) test classes and the one JUnit 4 (`MoodTrackingTest`) test class via the Vintage engine declared in `pom.xml`.

## Results Summary (Phase 3)

- **24 total test cases executed** (10 unit + 14 integration)
- **24 passed / 0 failed**
- **Estimated coverage:** User Accounts 88%, Journaling 92%, Mood Tracking 91%, Community Forum 87%

Full results, observations, and coverage analysis: [`docs/03-test-execution-report.md`](docs/03-test-execution-report.md)

## Notes on Faithfulness to the Original Report

- The production classes (`Story`, `ForumPost`, etc.) are the same minimal implementations described in the Phase 3 report — they exist solely to make the test cases executable, not as a full Soluna implementation.
- `StoryDBModel`, used by `UserIntegrationTest`, was referenced in the original report's test code but not listed as a standalone class. It has been reconstructed with the minimal API the test requires (`fromDate(LocalDate)`, `getLatestContent()`) — see the note in `StoryDBModel.java`.
- `MoodTrackingTest` uses JUnit 4 (`org.junit`) in the original report, while every other test class uses JUnit 5 (`org.junit.jupiter`). Rather than "fixing" this inconsistency, it's preserved as-is and made runnable via the JUnit Vintage engine, since it reflects how the team actually wrote the code.

## Contributors

| Members
| Zaina Alasaad  
| Layan Algublan 
| Deem Alhaqbani 
| Nora Alomier 

Per-phase contribution breakdowns are listed at the end of each document in `docs/`.
