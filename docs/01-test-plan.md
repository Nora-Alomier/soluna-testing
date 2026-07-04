# Soluna — Test Plan (Phase 1)

**Prince Sultan University — College of Computer and Information Systems**
**SE401: Software Quality Assurance and Testing**
Section #: 1371

## 1. Introduction

This document presents the test plan for Soluna, a digital mental wellness application designed to support users through journaling, mood tracking, community discussion, and AI-driven insights while maintaining a strong focus on privacy and security. Its goal is to outline the testing approach, scope, goals, and deliverables needed to ensure the system satisfies the functional and non-functional requirements.

It lists the features that will be tested, identifies features excluded from testing, and specifies the test objectives and expected deliverables. Prior to deployment, the testing process aims to verify compliance with requirements, evaluate system behavior, and ensure that Soluna provides a reliable, secure, and user-friendly experience.

## 2. Test Objectives

The primary objective is to verify and validate that Soluna functions correctly, securely, and efficiently according to its requirements. Specific objectives include:

- Ensuring all functional features perform as expected under normal and invalid conditions.
- Verifying that sensitive user information is protected through proper authentication and privacy mechanisms.
- Evaluating system usability to confirm ease of use.
- Confirming system reliability and stability during regular usage.
- Identifying and documenting defects prior to deployment.

## 3. Features

### 3.1 In Scope

- **User registration and login** — registration, login, logout, password validation, two-factor authentication
- **Journal management** — creating, deleting, editing, and viewing journal entries; changing journal content to private or public
- **Mood tracking** — recording daily moods, viewing mood history and trends
- **Community forum** — creating posts and comments, anonymous posting, reporting inappropriate content
- **Notifications and reminders** — scheduling journaling reminders, disabling and enabling notifications
- **Privacy and security features** — anonymous profiles, data access control, protection of sensitive user information

### 3.2 Out of Scope

- **Third-party services** — availability of external AI models; email/SMS delivery services used for notifications
- **Hardware-level testing** — device hardware failures, battery consumption
- **Scalability and load constraints** — server-side scalability under extreme traffic
- **Future enhancements** — features planned for later releases

## 4. Functional Requirements

**FR4.1 — User Accounts and Profiles**
- 4.1.1 Users shall be able to register a new account or log in with an existing account.
- 4.1.2 Users shall be able to enable two-step authentication for security.
- 4.1.3 Users shall be able to enable and disable notifications.

**FR4.2 — Journaling Features**
- 4.2.1 Users shall be able to create new journal entries.
- 4.2.2 Users shall be able to view previous journal entries.
- 4.2.3 Users shall be able to lock their journals for privacy.
- 4.2.4 Users shall be able to set a password for locked journals and use it to gain access.

**FR4.3 — Mood Tracking and Insights**
- 4.3.1 Users shall be able to record their daily moods.
- 4.3.2 Users shall be able to view their mood tracking history and trends.

**FR4.4 — Forums and Community**
- 4.4.1 Users shall be able to participate in online discussion posts.
- 4.4.2 Users shall be able to post either anonymously or with their profile identity.
- 4.4.3 Users shall be able to create and reply to discussion posts.

**FR4.5 — Administration**
- 4.5.1 Administrators shall be able to manage discussion content.
- 4.5.2 Administrators shall guarantee compliance with security, privacy, and content guidelines.
- 4.5.3 Administrators shall administer system backups, updates, and recovery operations.

## 5. Nonfunctional Requirements

1. The system shall enforce strong passwords requiring a mix of uppercase and lowercase letters, numbers, and at least one special symbol.
2. The system shall ensure data security using two-factor authentication mechanisms.
3. Users shall be able to save their journals once they're done writing within 15 seconds.
4. End-to-end encryption shall be implemented to protect user data and journal entries.
5. The system shall ensure privacy by enabling anonymous posting.
6. The system shall retrieve previously saved journal entries with a response time of 4 seconds.
7. The system shall provide users with filters to hide or block unwanted content.
8. The system shall allow users to access, create, edit, and store journal entries offline.
9. The system shall be usable and easy to navigate for first-time users.
10. The system shall be compatible with supported mobile platforms and devices.

## 6. Test Types

1. **Functional Testing** — verifies all Soluna features behave according to the specified functional requirements (registration, journal creation, privacy customization, mood logging, discussion participation, notification settings).
2. **Usability Testing** — confirms the system is intuitive, easy to use, and user-friendly for different users.
3. **Performance Testing** — evaluates efficiency and responsiveness, primarily response time for essential tasks.
4. **Security Testing** — verifies mechanisms such as two-factor authentication, access controls, and end-to-end encryption, ensuring unauthorized users cannot obtain sensitive information.
5. **Compatibility Testing** — ensures consistent behavior across supported devices, platforms, and configurations.

## 7. Risks and Mitigation Strategies

| Risk | Description | Impact | Mitigation Strategy |
|---|---|---|---|
| Weak requirements | Some requirements may be incomplete, ambiguous, or unrealistic | Medium | Requirements reviewed before testing begins |
| Privacy breach | Private data must be properly protected; a breach could cause loss of trust and unauthorized access | High | Conduct security testing to validate mechanisms; simulate attacks to ensure data protection |
| Poor usability | Unclear interfaces may reduce user engagement | Medium | Conduct usability testing with realistic scenarios to improve problematic workflows |
| Platform compatibility issues | Inconsistent behavior across devices/platforms reduces reliability | Medium | Perform compatibility testing across all supported devices and platforms |
| Testing schedule delays | Environmental failures or human error may delay the schedule | Medium | Adopt a realistic schedule with buffer time for unexpected delays |

## 8. Class Diagram

### 8.1 Scope of the Class Diagram

The class diagram focuses on the main components of the journaling system relevant to test-case preparation. It includes:

- **Core roles**: `User`, `Admin`
- **Journal-related classes**: `Story`, `StoryContent`, `StoryPage`
- **Supporting features**: `MoodLog`, `AIInsight`, `WeeklyReport`, `Backup`, `Export`, `Import`
- **Community interaction**: `CommunityPost`, `Comment`
- **Configuration/personalization**: `Preference`, `Notification`, `Reminder`, `Theme`

The diagram clarifies how data moves through the system — from users, to journal entries, to mood tracking, to reports, and supporting features — supporting both test planning and later testing activities. (See the original Phase 1 PDF for the full diagram image.)

## 9. Test Environment Description

Testing was carried out on the existing journaling system (GitHub repository), built with **Flutter/Dart**, on a personal computer running Windows or macOS, using local data storage. Testers interact with the system by creating journal entries, adding content, tracking moods, and generating reports to simulate realistic end-user behavior.

## 10. Resources

### 10.1 Human Resources Required

- **Tester** — executes test cases and verifies functionality (journal entries, moods, reports).
- **Test designer** — designs and organizes test cases based on requirements and the class diagram.
- **Reviewer** — checks test cases and results for correctness and consistency.

All members require a basic understanding of software testing concepts, GitHub, and system structure, plus good communication and collaboration skills.

### 10.2 System Resources Required

A personal computer/laptop with sufficient memory and processing power, adequate storage for test data (journals, mood logs, reports, backups), a stable OS (Windows/macOS), an internet connection (for the GitHub repository and documentation), the Flutter development environment and dependencies, and a code editor.

## 11. Test Logistics

| Aspect | Description |
|---|---|
| Testing Responsibility | Carried out by team members per assigned roles (accounts, journaling, mood tracking, community) |
| Test Execution | Structured and organized to ensure clarity, consistency, and coverage |
| Documentation | Test cases and results documented via shared tools for traceability |
| Defect Reporting | Issues recorded with description, reproduction steps, and expected vs. actual results |
| Defect Review | Reviewed by the team to determine severity and priority |
| Communication | Regular check-ins to track progress and resolve issues |

## 12. Test Schedule and Timeline

| Time Period | Planned Activities |
|---|---|
| Week 1 | Review source code and documentation; identify key requirements; prepare initial test plan outline |
| Week 2 | Develop detailed test plan sections (objectives, scope, test types, risk analysis); create/refine the UML class diagram |
| Week 3 | Review and finalize the test plan; verify consistency; final proofreading and formatting |

## 13. Suspension Criteria

Testing may be suspended if:
- Critical system failures prevent the application from running or being accessed.
- Major defects block multiple test cases and require code fixes first.
- Required testing resources (dev environment, project files) are unavailable.
- Requirements are incomplete or unclear, making expected behavior hard to validate.

Testing resumes once the issues are resolved and the system is stable.

## 14. Exit Criteria

Testing is considered complete when:
- All planned test cases have been executed.
- All critical/high-severity defects have been identified, documented, and reviewed.
- Test objectives have been satisfied and system behavior aligns with requirements.
- The test plan, class diagram, requirements list, and risk assessment are finalized and reviewed.
- No unresolved issues remain that would block continued testing.

## 15. Test Deliverables

| Deliverable | Description |
|---|---|
| Test Plan | Testing approach, scope, objectives, constraints |
| Requirements List | Functional and nonfunctional requirements used as the testing basis |
| UML Class Diagram | System structure supporting test-component identification |
| Risk Analysis | Testing risks and mitigation strategies |
| Test Logistics | Roles, responsibilities, and result-tracking procedures |
| Test Schedule | Estimated timing for planned activities |
| Suspension & Exit Criteria | Conditions for pausing/completing testing |

## 16. Conclusion

This test plan defined the scope, objectives, requirements, and testing approach needed to evaluate Soluna's functionality, usability, performance, and security. By identifying testable features, potential risks, and required resources, it provides a clear, organized foundation for systematic testing that helps ensure Soluna delivers a reliable, secure, and user-friendly experience.

## Contribution Table

| Zaina Alasaad | Layan Algublan | Deem Alhaqbani | Nora Alomier |
|---|---|---|---|
| Functional requirements, Nonfunctional requirements, Test types, Risks and mitigation, Test logistics, Suspension criteria, Exit criteria | Test schedule and timeline | Introduction, Test objectives, Features in/out of scope, Deliverables list | Class diagram, Test environment, System resources, Human resources |

---
*Original document: `SE401_Phase_1.pdf`*
