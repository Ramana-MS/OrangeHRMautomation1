# OrangeHRM Automation Project

This project automates the login and employee management functionality of the OrangeHRM demo application using **Selenium WebDriver**, **Java**, **TestNG**, and the **Page Object Model (POM)** design pattern.

## 🔗 Live Website (under test)
[https://opensource-demo.orangehrmlive.com](https://opensource-demo.orangehrmlive.com)

---

## 📁 Project Structure

OrangeHRMautomation1/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ └── pages/
│ │ ├── DashboardPage.java
│ │ ├── LoginPage.java
│ │ ├── PIMPage.java
│ │ └── VerifyEmployeeNames.java
│ │
│ ├── test/
│ └── java/
│ └── tests/
│ └── HRM_Test.java
│
├── test-output/
├── pom.xml
└── README.md


---

## 🔧 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git & GitHub

---

## 🧪 Test Cases Covered

- Login with valid credentials
- Login with invalid username/password
- Empty username/password fields
- Logout from the dashboard
- Navigate to PIM page
- Add new employee
- Verify employee in employee list
- Scroll and search through multiple employee pages

> 📄 Full manual test cases documented in: `LoginTestCases.xlsx` (included in repo)

---

## 🐛 Bugs or Issues Found

1. Missing error messages for blank inputs
2. No field validation for password length
3. No account lockout for repeated login failures

---
📝 How to Run the Automation Test

1. **Clone the repository**

```bash
git clone https://github.com/Ramana-MS/OrangeHRMautomation1.git
