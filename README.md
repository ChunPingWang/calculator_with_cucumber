
### 1. 以 Maven 建立一個 Cucumber 專案
```gherkin=
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
### 2. 查看專案結構
![截圖 2025-01-26 凌晨12 43 41](https://github.com/user-attachments/assets/7a5c06bc-4309-4ef3-a6cb-5d2e42fa6d7e)

#### pom.xml 相關內容
```gherkin=
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>io.cucumber</groupId>
                <artifactId>cucumber-bom</artifactId>
                <version>7.20.1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.junit</groupId>
                <artifactId>junit-bom</artifactId>
                <version>5.11.2</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-suite</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

### 3. 查看 example.feature 內容，此為 cucumber 自動建立
<img width="547" alt="截圖 2025-01-26 凌晨12 46 00" src="https://github.com/user-attachments/assets/49681c7e-1525-4150-9dff-8961bbb9163e" />


### 4. 查看 StepDefinitions.class 內容，此為 cucumber 根據 example.feature 建立
<img width="424" alt="截圖 2025-01-26 凌晨12 47 33" src="https://github.com/user-attachments/assets/723a0179-b983-44c1-bc05-dfab2a8203ec" />


### 5. 刪除 example.feature ，新增 calculator.feature，內容如下：
```gherkin=
Feature: Calculator

  Scenario: Add two numbers
    Given the first number is 50
    And the second number is 70
    When the two numbers are added
    Then the result should be 120
```
### 6. 執行 maven 測試指令如下，並查看結果，取得 cucumber 提示，，表示  calculator.feature 已被讀取
```gherkin=
mvn test
```
<img width="718" alt="截圖 2025-01-26 凌晨1 02 12" src="https://github.com/user-attachments/assets/f5387c56-90bd-4b77-a22c-187e2f0e9a71" />

### 7. 將提示內容覆蓋於 StepDefinitions.class，再執行一次 Maven 測試指令會看到不ㄧ樣的提示內容，表示  StepDefinitions.class 已被讀取
<img width="924" alt="截圖 2025-01-26 凌晨1 05 41" src="https://github.com/user-attachments/assets/e5fee6b9-cc82-4867-b8c7-6b5a442b9d07" />

### 8. 修改 StepDefinitions.class 並新增 Calculator.class 
### 9. 執行 Maven 測試，完成此 Scenario: Add two numbers 測試與開發
```gherkin=
mvn test
```
<img width="932" alt="截圖 2025-01-26 下午1 43 09" src="https://github.com/user-attachments/assets/e0dd79ee-ad30-4683-9d6f-8e96847c15e0" /></BR>
或是點選 calculator.feature 檔左邊的執行鈕</BR> 
<img width="401" alt="截圖 2025-01-26 下午1 44 39" src="https://github.com/user-attachments/assets/6822dcb6-a644-48fb-a503-323a48c6e926" /></BR>
得到結果如下</BR>
<img width="833" alt="截圖 2025-01-26 下午1 34 27" src="https://github.com/user-attachments/assets/4f0909b0-ef01-4628-84f2-7ed9934453c6" /></BR>

### 10. 修改 Gherkin，將數值改成表格，內容如下：
```gherkin=
Feature: Calculator

Scenario Outline: Add two numbers
    Given the first number is <firstNumber>
    And the second number is <secondNumber>
    When the two numbers are added
    Then the result should be <result>

    Examples:
      | firstNumber | secondNumber | result |
      | 50          | 70           | 120    |
```
#### 修改 StepDefinitions.class 如下：
```gherkin=
package calculator;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    private Calculator calculator = new Calculator();
    private int result;
    @Given("the first number is {int}")
    public void theFirstNumberIs(Integer firstNumber) {
       this.calculator.firstNumber = firstNumber;
    }

    @And("the second number is {int}")
    public void theSecondNumberIs(Integer secondNumber) {
        this.calculator.secondNumber = secondNumber;
    }

    @When("the two numbers are added")
    public void theTwoNumbersAreAdded() {
        this.result = this.calculator.add();
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(Integer result) {
        assertEquals(result, this.result);
    }

}
```
### 11. 執行 Maven 測試成功，得到與之前一樣結果
```gherkin=
mvn test
```

### 12. 增加 Calculator 的減法功能
calculator.feature 內容為
```gherkin=
Feature: Calculator

  Scenario Outline: Add two numbers
    Given the first number is <firstNumber>
    And the second number is <secondNumber>
    When the two numbers are added
    Then the result should be <result>
    Examples:
      | firstNumber | secondNumber | result |
      | 50          | 70           | 120    |


  Scenario Outline: Subtracting two numbers
    Given the first number is <firstNumber>
    And the second number is <secondNumber>
    When the first number subtract the second number
    Then the result should be <result>
    Examples:
      | firstNumber | secondNumber | result |
      | 70          | 50           | 20     |
      | 50          | 70           | -20    |
      | 50          | 50           | 0      |
```

StepDefinition.class 增加一個 method 
```gherkin=
@When("the first number subtract the second number")
    public void theFirstNumberSubtractTheSecondNumber() {
        this.result = this.calculator.subtract();
    }
```

13. 執行 Maven 測試，取得下列結果

### Appendix and FAQ

:::info
**Find this document incomplete?** Leave a comment!
:::

###### tags: `Java` `BDD`
