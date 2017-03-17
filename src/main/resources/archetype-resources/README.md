# ${projectName}

Generated with the [_Knot.x Extension Maven Archetype_](https://github.com/Knotx/knotx-extension-archetype).

## Running

To run the extension:

1. [Download the Knot.x fat jar](https://github.com/Cognifide/knotx/releases) specific to your Knot.x version. 
2. Copy it to the `apps` folder relative to this `README.md` file.
3. Build the extension using `mvn clean install`
4. Copy the fat jar from the `target` directory into the `apps` directory
5. Execute the `run.sh` bash script.

## Project structure

The project follows the following logical structure:

```
├── app (move executable jars here)
│   
├── content (HTML templates to be loaded by the local file system repository)
│   ├── local
│       ├── books.html
|
├── src
│   ├── main
│   |   ├── java
|   |   |     ├── ${package}
|   |   |            ├── adapters (custom service adapters)
|   |   |            ├── handlebars (custom handlebars helpers)
|   |   |            ├── knots (custom knots)
|   |   |
│   |   ├── resources (Additional Knot.x configuration files)
|   |
│   ├── test
│       ├── java (java test classes)
│       ├── resources (test resources)
|
├── knotx-standalone-1.0.0.json (Knot.x configuration)
├── knotx-standalone-1.0.0.logback.xml (Logging configuration)
├── run.sh (startup script)
├── pom.xml (Project Object Model for the extension)
├── README.md (this file)
```
