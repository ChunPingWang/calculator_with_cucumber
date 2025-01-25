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
![截圖 2025-01-26 凌晨12 43 41](https://github.com/user-attachments/assets/7a5c06bc-4309-4ef3-a6cb-5d2e42fa6d7e)

4. 查看 example.feature 內容，此為 cucumber 自動建立
<img width="547" alt="截圖 2025-01-26 凌晨12 46 00" src="https://github.com/user-attachments/assets/49681c7e-1525-4150-9dff-8961bbb9163e" />


5. 查看 StepDefinitions.class 內容，此為 cucumber 根據 example.feature 建立
<img width="424" alt="截圖 2025-01-26 凌晨12 47 33" src="https://github.com/user-attachments/assets/723a0179-b983-44c1-bc05-dfab2a8203ec" />


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
<img width="718" alt="截圖 2025-01-26 凌晨1 02 12" src="https://github.com/user-attachments/assets/f5387c56-90bd-4b77-a22c-187e2f0e9a71" />

8. 將提示內容覆蓋於 StepDefinitions.class，再執行一次 Maven 測試指令會看到不ㄧ樣的提示內容，表示  StepDefinitions.class 已被讀取
<img width="924" alt="截圖 2025-01-26 凌晨1 05 41" src="https://github.com/user-attachments/assets/e5fee6b9-cc82-4867-b8c7-6b5a442b9d07" />

9. 修改 StepDefinitions.class 並新增 Calculator.class 
10. 執行 Maven 測試，完成此 Scenario: Add two numbers 測試與開發