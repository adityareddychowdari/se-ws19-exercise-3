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

## Updating the Starter Code
In case we provide bug fixes later, you have to merge them manually into your
code. To do this add the repository of the starter code as a
[remote][git-remote]:

    git remote add https://github.com/mmbuw-courses/se-ws19-exercise-$NUMBER.git

Where `$NUMBER` corresponds the exercise’s number, i.e. for the first assignment
the URL is `https://github.com/mmbuw-courses/se-ws19-exercise-1.git`.
You only have to do this once for each assignment.
After you did that you can pull the changes we made in the starter code with:

    git pull upstream master

Pay attention to Git’s output, you may have to fix some [merge
conflicts][git-merge-conflicts].

[gitforwindows]: https://gitforwindows.org/
[git-remote]: https://git-scm.com/docs/git-remote
[git-merge-conflicts]: https://git-scm.com/docs/git-merge#_how_conflicts_are_presented
