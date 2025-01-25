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
