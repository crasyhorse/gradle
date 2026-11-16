# Unit Converter — Java + Gradle multi-project demo

A small Java 17 example designed to demonstrate **Gradle**, with **two independent subprojects**:

- **`converter-core`** (`java-library`): a reusable library for converting temperature and distance. It has JUnit 5 unit tests.
- **`converter-cli`** (`application`): a command-line application that **depends on `converter-core`** and calls its methods.

## Requirements

- Java **17 or newer**
- Gradle **8.x or newer** installed and available as `gradle` (this demo does not include a Gradle wrapper)

## Project structure

```text
unit-converter-gradle/
├── settings.gradle                  # registers both subprojects
├── build.gradle                     # shared configuration + JUnit
├── converter-core/
│   ├── build.gradle                 # java-library plugin
│   └── src/
│       ├── main/java/.../UnitConverter.java
│       └── test/java/.../UnitConverterTest.java
└── converter-cli/
    ├── build.gradle                 # application plugin + project dependency
    └── src/main/java/.../Main.java
```

## Try it

Run the following commands **from the root directory**:

```bash
gradle projects                                             # see both modules
gradle tasks --all                                          # see available tasks
gradle build                                                # compile, test, package both modules
gradle :converter-cli:run --args="c-to-f 25"                # 77.00 °F
gradle :converter-cli:run --args="km-to-mi 10"              # 6.21 mi
gradle :converter-core:test                                 # only library tests
gradle :converter-cli:dependencies --configuration runtimeClasspath  # see module dependency
gradle clean                                                # delete generated outputs
```

Gradle's normal output includes task messages around the application output.

## Gradle concepts to demonstrate

1. **`settings.gradle`** names the build and includes the two modules.
2. **Plugins:** `java-library` adds library tasks; `application` adds `run` and distribution tasks.
3. **Project dependencies:** `implementation project(':converter-core')` lets the CLI call the library. Gradle builds the library first when necessary.
4. **Lifecycle:** `gradle build` compiles, runs tests, and packages code; `gradle clean` removes generated artifacts.
5. **Testing:** `gradle test` invokes the JUnit 5 tests in `converter-core`.
6. **Incremental builds:** run `gradle build` twice. The second run should show cached/up-to-date work when nothing changed.

## No external runtime dependency

The application uses only the Java standard library. Gradle downloads **JUnit 5** from Maven Central when you run tests, so the first full build requires internet access.
