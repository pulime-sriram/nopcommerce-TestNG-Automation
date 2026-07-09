# 🚀 NopCommerce TestNG Automation Framework

> End-to-End Automation Testing Framework developed using **Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM)** for automating major functionalities of the NopCommerce E-Commerce application.

---

# 📖 Project Overview

This automation framework validates critical business workflows of the NopCommerce application and ensures stable regression testing through reusable and maintainable automation scripts.

The framework covers:

✅ User Registration  
✅ User Login  
✅ Product Search  
✅ Product Details Verification  
✅ Shopping Cart Management  
✅ Wishlist Functionality  
✅ Contact Us Module  
✅ My Account Module  
✅ Change Password Functionality  
✅ Checkout Process

---

# 🛠 Technology Stack

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **Extent Reports**
- **Git**
- **GitHub**
- **Eclipse IDE**

---

# 🏗 Framework Architecture

The framework follows the **Page Object Model (POM)** design pattern.

### Key Advantages

✔ Better Maintainability

✔ Code Reusability

✔ Separation of Test Logic and Locators

✔ Easy Debugging

✔ Scalable Framework Structure

---

# 📂 Project Structure

```text
nopcommerce-TestNG-Automation
│
├── capstoneproject
│
├── src
│   └── test
│       └── java
│
│           ├── pages
│           │
│           ├── HomePage.java
│           ├── LoginPage.java
│           ├── RegisterPage.java
│           ├── ProductSearchPage.java
│           ├── ProductDetailsPage.java
│           ├── ShoppingCartPage.java
│           ├── WishlistPage.java
│           ├── ContactUsPage.java
│           ├── MyAccountPage.java
│           └── ChangePasswordPage.java
│
│           ├── tests
│           │
│           └── NopCommerceTest.java
│
│           └── utilities
│               └── ExtentListener.java
│
├── test-output
│
├── pom.xml
│
├── testng.xml
│
└── README.md
```

---

# ✅ Test Scenarios Covered

## 👤 Registration Module

- New User Registration
- Registration Field Validation

## 🔐 Login Module

- Valid Login
- Invalid Login
- Login Validation

## 🔎 Product Search Module

- Product Search
- Search Result Verification

## 📦 Product Details Module

- Product Navigation
- Product Information Verification

## 🛒 Shopping Cart Module

- Add Product to Cart
- Remove Product from Cart
- Update Quantity
- Cart Validation

## ❤️ Wishlist Module

- Add to Wishlist
- Remove from Wishlist

## 📩 Contact Us Module

- Enquiry Submission

## 👤 My Account Module

- Account Information Update

## 🔑 Change Password Module

- Password Change
- Password Validation

## 💳 Checkout Module

- Checkout Flow
- Order Placement Validation

---

# 📊 Reporting

The framework generates detailed execution reports using:

### Extent Reports

Features:

- Execution Summary
- Pass/Fail Statistics
- Detailed Logs
- Failure Information

Report Location:

```text
test-output/ExtentReport.html
```

---

# ▶ Execution Steps

## 1️⃣ Clone Repository

```bash
git clone https://github.com/pulime-sriram/nopcommerce-TestNG-Automation.git
```

## 2️⃣ Navigate to Project

```bash
cd nopcommerce-TestNG-Automation
```

## 3️⃣ Install Dependencies

```bash
mvn clean install
```

## 4️⃣ Execute Test Suite

```bash
mvn test
```

OR

Run:

```text
testng.xml
```

as a **TestNG Suite**.

---

# 📋 Prerequisites

Before executing the project, ensure the following are installed:

- Java JDK 8+
- Eclipse IDE
- Maven
- Google Chrome / Microsoft Edge
- Git

---

# 🎯 Design Patterns Used

### Page Object Model (POM)

Each application page is represented by a separate Java class containing:

- Web Element Locators
- Page Actions
- Reusable Methods

Examples:

```text
LoginPage.java
RegisterPage.java
ShoppingCartPage.java
ChangePasswordPage.java
```

---

# 🔄 Version Control

The project is maintained using Git and GitHub.

Frequently Used Commands:

```bash
git add .
git commit -m "Updated project"
git push origin main
```

---

# 👨‍💻 Author

### PULIME Venkata Sriram

Project Engineer

Automation Testing Capstone Project

---

# 🎉 Conclusion

This project demonstrates the implementation of a Selenium-TestNG Automation Framework using the Page Object Model design pattern. The framework provides reliable automated validation of major NopCommerce functionalities and supports functional as well as regression testing activities.