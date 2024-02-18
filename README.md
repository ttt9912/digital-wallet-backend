# How to run this application

## Prerequisites
- Java 21 installed
- Access token

## 1. Enter your access token in the configuration 
Authentication and Consent flows are out of scope of this project. 
An access token has to be obtained manually and set in the application configuration.

Set the `natwest.client.accesstoken` property in:
[application.yml](digital-wallet-backend-app/src/main/resources/application.yml)

Relevant information (How to obtain an access token using Postman):
[https://developer.sandbox.natwest.com/api-catalog/4168067/getting-started](https://developer.sandbox.natwest.com/api-catalog/4168067/getting-started)

## 2. Run the Spring Boot application
Main class: `ch.thts.digitalwalletbackend.app.DigitalWalletBackendApplication`