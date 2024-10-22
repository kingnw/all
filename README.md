# NIT3213 Android Project

## Overview

Welcome to the NIT3213 Android project! This application is part of an assignment where users can log in and interact with an API to view a list of architectural entities. The app features a login screen, a dashboard displaying a list of architecture entities, and a detailed information page for each entity.

---

## Key Features

### 1. **Login Functionality**
- **Simple Login**: Enter your credentials to authenticate, but incase u wanna login in mine just put **Safal** as username and **s4680098** as password. The app checks your username and password with an API and retrieves a `keypass` that grants access to other features.
  
- **API Authentication Endpoint**: 
  - `POST /footscray/auth` 
  - Returns a `keypass` upon successful login.

- **Note**: You may need to attempt the login process two or three times due to API response times.

---

### 2. **Dashboard**
- **Entity List**: Once logged in, the dashboard displays a list of architecture entities fetched from the API. Each entry includes a **profile image** and **basic information** about the entity.
  
- **API Fetch Endpoint**: 
  - `GET /dashboard/{keypass}`
  - Retrieves the list of entities using the `keypass` received during login.

---

### 3. **Entity Details**
- **Detailed View**: Click on any entity in the dashboard to view more information, such as:
  - **Name**
  - **Year Built**
  - **Architect**
  - **Location**
  - **Height**
  - **Style**
  
- **Profile Image**: Each entity’s details page is accompanied by a relevant picture.

---

### 4. **Unit Testing**
- Basic unit tests are included to validate the login process and ensure that the app interacts with the API correctly.
- The tests are located in:
  - `app/src/test/java/com/example/nit3213project` (GitHub)
  - `app:kotlin+java:com.example.nit3213project(test)` (Android Studio)

---

## Project Structure

Here's a breakdown of the key directories and files in the project:

### **Source Code:**
- **Package**: `com.example.nit3213project`
  - Located at: `app/src/main/java/com/example/nit3213project` (GitHub)
  - Located at: `app:kotlin+java:com.example.nit3213project` (Android Studio)
  - Contains all the **Activity** files and **network/api** files.

### **Layouts and UI:**
- **Resource Folder**: 
  - Located at: `app/src/main/res` (GitHub)
  - Located at: `app/res`(Android Studio)
  - Contains all the **UI**  related files like  **layout** files for the user interface.

### **Testing:**
- **Unit Tests**:
  - Located at: `app/src/test/java/com/example/nit3213project` (GitHub)
  - Includes tests for login functionality and API interactions.

---

## Installation

### What You Need
1. **Android Studio**: Ensure you have Android Studio installed to run the project.
2. **API Access**: Make sure you can access the relevant API;s.

### Installation Steps
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/kingnw/all.git
