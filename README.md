# UI Automation Assignments

***Tokopedia*** UI Automation Test project

## Part 1: Getting sstarted

### Requirements

Here is complete list of the setup:

- Eclipse IDE
- Chrome Browser 101.0.4951.41 or earlier
- Java 8

### Installation

#### 1. Install Eclipse IDE

To run this project you will need an IDE. You may use your preferred IDE, but in this case, we are going to use Eclipse. In order to install it, please download [Eclipse for Java](https://www.eclipse.org/downloads/packages/).

Complete the installation process.

Open the eclipse, and then go to Help > Eclipse Marketplace...

And then search TestNG.

You will see something similar with this:

<img src="readme-images/TestNG1.png">

Complete the installation. To verify your installation, go to Window > Show View > Other.

You will see something similar with this:

<img src="readme-images/TestNG2.png">

#### 2. Install Java 8 and set JAVA_HOME

Since we are using java to write our test, we need to install Java Development Kit (JDK). Specifically, [Java 8](https://java.com/en/download/manual.jsp).

Download and complete installation process.

After that, add these two lines to your system environment:

> JAVA_HOME with Path/of/your/JDK/
> 
> Append %JAVA_HOME%\bin into your system Path

#### 3. Install Google Chrome 101.0.4951.41 or earlier

To install google chrome.

You may visit this [site](https://www.google.com/chrome/).

## Part 2: Run the Test

### 1. Clone the Project

After completing the installation processes, you're almost there to run the test.

In order to do it, clone project ***TokopediaTest*** project from [github](https://github.com/haga2554/TokopediaTest).

### 2. Open Project with Eclipse and Build

Once, the project cloned to your local machine, open this project with Eclipse.

Then go to Project > Clean...

After that go to Project > Build Project.

Since the project is using Maven, this process will also retrieving all required depedencies that stated in the ***pom.xml*** file.

Please wait untill all those depedencies are successfully downloaded.

### 3. Execute the Test

If you reached this part, then you're all set and ready to execute the test scenarios.

All the test scenarios are located in src/test/java/scenarios

Open one file e.g.

> SortProductsFromHighestAndCheckoutFirstItem.java

To execute the test, simply

> go to Run > Run As > TestNG
>
> or
> 
> right click on the code then go to Run As > TestNG

Once the execute process is done. Update the project folder, you will see ScreenCaptures folder in the project explorer.

This folder will automatically generated every runtime process, marked with specific timestamp so we will not losing any results/evidences.

There will be test-outpot folder, containing the test report that generated every runtime process. To see it, you may open ***index.html*** inside this folder using your browser.

## Part 3: Framework Summary

This project uses Maven, Java, selenium, and TestNG. This combination is aminging for Maintainability, Usability, and Reporting.

Maven is long to be known as one of the most common project management tool. It helps the maintainability of this project to work collaboratively, swap and manage many depedencies, etc. The alternative version of this tool is gradle, which newer and more simple depedencies manager.

TestNG itselft choosen as it is the advanced version of JUnit/NUnit. The use of TestNG will allow test engineers to cover many test categories whether it unit, functional, e2e, or integration. And also this framework comes with built-in report that will be generated every runtime process.

