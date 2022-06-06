### Java-based automation test framework

#### Scope
* UI Testing (Selenium WebDriver)

##### Tools
* Cucumber
* TestNG
* Maven
* IntellijIdea

#### Reports
* Yandex Allure

#### Logging
* Log4j2

### Require
* Java 8
* Maven 3.6.1
* Chrome version 102

#### Install
1) Install GIT bash or similar tool
2) git clone ```https://github.com/CTAJlb/ti8m.git```
3) Install java & maven in your OS
4) Import project to IntellijIdea as maven builder

### Structure
main packages:

```$xslt
 |-ti8m                                  : Automation Test Framework
     |---res                             : Driver's for test execution
     |---src
        |---test
            |---java
                |---Injection_module     : ScenarioContext with modules and test data
                |---pages                : Page Objects / Html elements blocks
                |---steps                : Steps initialization with feature files
            |---resources                : Test feature files / Properties
     |---pom.xml                         : Builder with required dependencies 

```

#### Test execution
```
All scenarios:
mvn clean test

Separate scenario:
You can trigger any scenario by input tags in cucumber options
mvn clean test -D"cucumber.filter.tags=@004"
```

#### Allure Reports 
```
Allure json* files will be appeared in target/allure-results during test execution
E.x:
1) Execute scenarios:  
mvn clean test
2) After test execution is finished perfrom cmd command for generate report 
mvn allure:report
3) Navigate to target/site/index.html and open it

Report example:
![alt text](https://ibb.co/hVKvkMv)
