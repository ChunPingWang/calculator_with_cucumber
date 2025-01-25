1. 以 Maven 建立一個 Cucumber 專案
```gherkin
mvn archetype:generate                     \
"-DarchetypeGroupId=io.cucumber"           \
"-DarchetypeArtifactId=cucumber-archetype" \
"-DarchetypeVersion=7.20.1"                \
"-DgroupId=calculator"                  \
"-DartifactId=calculator"               \
"-Dpackage=calculator"                  \
"-Dversion=1.0.0-SNAPSHOT"                 \
"-DinteractiveMode=false"
```
2. 查看專案結構<BR>
![截圖 2025-01-26 凌晨12 43 41](https://github.com/user-attachments/assets/7b3ca6e5-7fe5-4ea1-89c5-cb6eaf5ec61d)

4. 查看 example.feature 內容，此為 cucumber 自動建立
![截圖 2025-01-26 凌晨12 47 33](https://github.com/user-attachments/assets/03646597-4ae5-42c3-8703-d83a47572a14)

5. 查看 StepDefinitions.class 內容，此為 cucumber 根據 example.feature 建立
![截圖 2025-01-26 凌晨12 46 00](https://github.com/user-attachments/assets/85ab0ff0-1ee2-4dd1-8175-16f9c0a65685)

6. 刪除 example.feature ，新增 calculator.feature，內容如下：
```gherkin
Feature: Calculator

  Scenario: Add two numbers
    Given the first number is 50
    And the second number is 70
    When the two numbers are added
    Then the result should be 120
```
7. 執行 maven 測試指令如下，並查看結果，取得 cucumber 提示，，表示  calculator.feature 已被讀取
```gherkin
mvn test
```
![截圖 2025-01-26 凌晨1.02.12.png](..%2F..%2F..%2F..%2FDesktop%2F%E6%88%AA%E5%9C%96%202025-01-26%20%E5%87%8C%E6%99%A81.02.12.png)

8. 將提示內容覆蓋於 StepDefinitions.class，再執行一次 Maven 測試指令會看到不ㄧ樣的提示內容，表示  StepDefinitions.class 已被讀取
![截圖 2025-01-26 凌晨1.05.41.png](..%2F..%2F..%2F..%2FDesktop%2F%E6%88%AA%E5%9C%96%202025-01-26%20%E5%87%8C%E6%99%A81.05.41.png)