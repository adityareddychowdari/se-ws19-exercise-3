# Software Engineering WS 2019 — Exercise 2
Starter code for the Software Engineering Exercise.

## Compiling and Running the Tests
To compile your code and run the tests, run one of the following commands.

On macOS, Linux, or the Git Bash of [Git for Windows][gitforwindows]:

    ./gradlew build

In the Windows Powershell:

    gradlew.bat build

After running this command you can find an overview over your test results in
`build/reports/tests/test/index.html`.

## Tests
We provided some [tests](src/test/java/exercise/). Those tests *must* pass,
otherwise you won’t get full points for this exercise. The tests also show the
function signatures of functions you have to implement in this exercise.

### XML Parser Test
The [tests for the XML parser](src/test/java/exercise/XMLParserTest.java) will
call your implemented functions with some test files. This way you can check if
your implementation works. These tests are run automatically with `gradle
build`.
You can find the test files in [`src/test/resources`](src/test/resources).

[gitforwindows]: https://gitforwindows.org/
