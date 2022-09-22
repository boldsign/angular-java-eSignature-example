# BoldSign API Angular with Java Spring Boot examples
Demonstrates how to use BoldSign signing service. This sample uses Angular as frontend and Java Spring Boot as backend.

[![API Demo][api demo badge]][api demo link]

## Scenarios covered

This repository includes the below list of code examples using the BoldSign APIs:

- [Send document for signing](/client-angular/src/app\send-document)
- [Get detailed information of the document](/client-angular/src/app/get-document-properties)
- [Send document from template](/client-angular/src/app/embed-send-document-using-template)
- [Embed signing process within your app](/client-angular/src/app/embed-signing)
- [Embed send document within your app](/client-angular/src/app/embed-send-document)
- [Embed send document using template within your app](/client-angular/src/app/embed-send-document-using-template)

## Prerequisites
1. Signup for [BoldSign trial](https://account.boldsign.com/signup?planId=101)
2. Acquire needed BoldSign app credentials from here. [Authentication - Help Center - BoldSign](https://boldsign.com/help/api/general/authentication/#basic-authentication)
3. Check the node version, it should be v14.15.0 or above.
4. And also check if Angular is installed, if not kindly run this command on your terminal to install
```cmd
npm install -g @angular/cli
```
5. Now you have all the prerequisites ready to start BoldSign API for Angular.
6. Please follow installation steps provided in official Spring Boot application https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started.introducing-spring-boot

## Steps to run sample

1. Before running the sample, add your API key acquired from the [BoldSign Web App](https://app.boldsign.com/api-management/api-key/) in the ApiClient to your machine environmental variable with key as `apiKey`. This env value will be auto injected in this file [BaseApi.java](/server-spring-boot/src/main/java/com/boldsign/demo/boldsignapi/BaseApi.java).
2. To run the [Send document from template](/client-angular/src/app/send-document-using-template) sample, create a template from the web app with necessary fields. Copy the template ID from the web app once the template has been created. Add the copied template ID, in the sample template ID text box.
3. To run the [Embed signing process within your app](/client-angular/src/app/embed-signing) and [Embed send document using template within your app](/client-angular/src/app/embed-send-document-using-template) sample, create a template from the web app with necessary fields. Copy the template ID from the web app once the template has been created. Add the copied template ID, in the sample template ID text box.

### Angular
1. Open a new terminal and install the packages by using `npm install`.
2. Run `ng serve`. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

### Spring Boot

Please follow the steps provided in the Spring Boot documentation to run the application https://docs.spring.io/spring-boot/docs/1.5.22.RELEASE/reference/html/using-boot-running-your-application.html

## Useful Resources
- [Send document from template by filling existing fields](https://boldsign.com/help/api/template/send-document-to-sign-using-template/#send-document-from-template-by-filling-existing-fields)
- [Send document for sign](https://boldsign.com/help/api/document/send-document-for-sign/)
- [API Reference Link](https://api.boldsign.com/swagger/index.html)

### Contact Us
Any feedback or queries? Please feel free to [contact our support team](https://boldsign.com/contact-us/) or mail to support@boldsign.com.

[api demo link]: https://demos.boldsign.com/
[api demo badge]: https://img.shields.io/badge/-API%20Demo-blue
