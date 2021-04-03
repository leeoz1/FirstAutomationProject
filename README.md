# Full Stack Automation Final Project
### This project created to demonstrate knowledge and skills in Automation Testing.



### About

The project demonstates a flexible infrastructure, using seperated components of common operations, page objects, actions, flows and tests.
Using this type of infrastructure allows the 'tests' section to be created in a very simple manner with minimal lines of code usage along the way.

The infrastructure's hierarchy is allowing to run tests for different platforms and can easily be maintained.

**The project is well documented with clean and structured code comments & annotations.**
#

### infrastructure: 


- Page Object Design Pattern
- Project Layers(Extensions/Work Flows/Test Cases etc.)
- Support for Different Clients/Browsers
- Failure Mechanism
- External Files Support
- Allure Reporting System: including Screenshots, HTML source, JSON source and DB table
- Visual Testing (using sikulix API)
- Synchronization (Explicitly & Implicitly Waits, Timeouts)
- Support of the following platforms:
   - Web app support
   - Mobile app support
   - REST API
   - Electron
   - DB support
   - CI Jenkins Support
##   
### Installations Required:


- [Allure report framework](https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/)

- [Appium Studio](https://experitest.com/mobile-test-automation/appium-studio/)

- [Jenkins](https://www.jenkins.io/download/)

- [Electron Todolist](https://www.electronjs.org/apps/todolist)

- [Sauce labs apk version 2.7.1](https://github.com/saucelabs/sample-app-mobile/releases)

- Students.jar API server is added to the project
##

### Useful command lines
Running Jenking locally:

`cd [file path] -> java -Dhudson.util.ProcessTreeKiller.disable=true -jar jenkins.war --httpPort=9090`

Running Students.jar server:

`cd [file path] -> java -jar students.jar --server.port=9000`
#
#### Example of test failure report:
In this test the expected value is different from actual value:

![](https://i.ibb.co/x532QcY/Screen-Shot-2021-04-04-at-1-22-39.png)

> Verifications.verifyDoubleEquals(UIActions.getTotalPrice(), UIActions.convertToDouble(swagLabsOverview.getNum_itemTotal()));

#
#### Known issues
Due to the various platforms compressed in one single project, conflicts might occur. 

*For example:*
- Selenium Firefox driver overlaps with appium driver.
- Sikulix visual testing API fails to identify visual elements (only when tests are running through Jenkins).
