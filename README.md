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
2. 查看專案結構
![截圖 2025-01-26 凌晨12 43 41](https://github.com/user-attachments/assets/7b3ca6e5-7fe5-4ea1-89c5-cb6eaf5ec61d)

3. 查看 example.feature 內容，此為 cucumber 自動建立
![截圖 2025-01-26 凌晨12 47 33](https://github.com/user-attachments/assets/03646597-4ae5-42c3-8703-d83a47572a14)

4. 查看 StepDefinitions.class 內容，此為 cucumber 根據 example.feature 建立
![截圖 2025-01-26 凌晨12 46 00](https://github.com/user-attachments/assets/85ab0ff0-1ee2-4dd1-8175-16f9c0a65685)
