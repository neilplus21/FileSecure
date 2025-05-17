# FileSecure

**FileSecure** is a secure file storage application built using Java and MySQL. It provides OTP-based user authentication via email, enabling users to upload, encrypt, and store files securely in a MySQL database. The system ensures that only authenticated users can access and manage their files.

## Features

* User Registration and Login with Email OTP Verification
* Secure File Upload with Binary Storage in MySQL
* File Retrieval with Email-based Access Control
* OTP Sending using Jakarta Mail (SMTP with Gmail)
* Database Integration using JDBC and MySQL

## Technologies Used

* **Java 17+**
* **MySQL 8.0+**
* **Jakarta Mail API (JavaMail)**
* **Maven** (for dependency management)
* **IntelliJ IDEA** (recommended IDE)

> Make sure you enable 2FA and generate an app password from your Google account.

## Notes

* App passwords are used for Gmail integration.
* File content is stored as BLOBs in the MySQL database.
* Only registered users with OTP validation can access their data.


