# SDET Interview Challenge framework - By Daniel Gonzales

**Requeriments**

Make sure following requirements are met:

1. Gradle (download from here: https://gradle.org/releases/)
2. Java 8
3. Intellij idea
4. Git
5. Allure Report (download from here: https://bintray.com/qameta/generic/allure2/2.7.0)

Make sure Gradle, Java and Allure are added to your environment variable specifically to the PATH

***Configurations***

Open gradle.properties and fill the required variables

**Execution**

To execute feature files run following cmd command:
> gradle webFeatures

**Generate Allure Report**

To generate allure report run following command:

> allure generate --clean

Then open allure-report/index.html on a browser

OR

> allure serve

To open allure-report run following command
> allure open

**Run Static Code Analysis**

> gradle clean check

It executes the static code analysis tasks, makes use of the gradle Checkstyle and PMD plugins, the analysis reports are located in the following paths:</br> </br>
Checkstyle reports for main and test sources
> build/reports/checkstyle/

PMD reports for main and test sources
> build/reports/pmd/

***Note***
--
To setup allure plugin on jenkins follow this tutorial: https://docs.qameta.io/allure/#_jenkins

---
References
---

1. Selenium (https://www.selenium.dev/documentation/en/)
2. Appium (http://appium.io/docs/en/about-appium/api/)
3. Cucumber (https://docs.cucumber.io/docs/cucumber/)
4. Rest Assured (https://javadoc.io/doc/io.rest-assured/rest-assured/latest/index.html)

---
Reports
---
![image](https://user-images.githubusercontent.com/17088826/119212120-5df94a00-ba84-11eb-93d2-d5558aa09328.png)

![image](https://user-images.githubusercontent.com/17088826/119212128-66518500-ba84-11eb-8a61-2e9b2b236370.png)
