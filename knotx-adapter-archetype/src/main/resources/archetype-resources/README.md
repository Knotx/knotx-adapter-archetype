# ${projectName}

Generated with the [_Knot.x Extension Maven Archetype_](https://github.com/Knotx/knotx-extension-archetype).

Check out the [Knot.x Wiki](https://github.com/Cognifide/knotx/wiki/Adapter) for more information 
about the Adapter concept and APIs used here.

## Running

To run the extension:

1. [Download the Knot.x fat jar](https://oss.sonatype.org/content/groups/public/io/knotx/knotx-standalone/1.1.2/knotx-standalone-1.1.2.fat.jar). 
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
|   |   |            ├── adapter (custom service adapters)
|   |   |
│   |   ├── resources (Additional Knot.x configuration files)
|   |
│   ├── test
│       ├── java (java test classes)
│       ├── resources (test resources)
|
├── knotx-standalone.json (Knot.x configuration)
├── knotx-standalone.logback.xml (Logging configuration)
├── run.sh (startup script)
├── pom.xml (Project Object Model for the extension)
├── README.md (this file)
```

## Running the application

When you run `run.sh` you will see output similar to the following:
```
2017-08-04 15:10:21 [vert.x-eventloop-thread-2] INFO  i.k.r.FilesystemRepositoryConnectorVerticle - Starting <FilesystemRepositoryConnectorVerticle>
2017-08-04 15:10:21 [vert.x-eventloop-thread-3] INFO  i.k.s.FragmentSplitterVerticle - Starting <FragmentSplitterVerticle>
2017-08-04 15:10:21 [vert.x-eventloop-thread-1] INFO  io.knotx.server.KnotxServerVerticle - Starting <KnotxServerVerticle>
2017-08-04 15:10:21 [vert.x-eventloop-thread-0] INFO  i.k.a.example.ExampleServiceAdapter - Starting <ExampleServiceAdapter>
2017-08-04 15:10:21 [vert.x-eventloop-thread-4] INFO  i.k.k.a.FragmentAssemblerVerticle - Starting <FragmentAssemblerVerticle>
2017-08-04 15:10:21 [vert.x-eventloop-thread-7] INFO  i.k.k.t.HandlebarsKnotVerticle - Starting <HandlebarsKnotVerticle>
2017-08-04 15:10:21 [vert.x-eventloop-thread-6] INFO  i.k.knot.action.ActionKnotVerticle - Starting <ActionKnotVerticle>
2017-08-04 15:10:21 [vert.x-eventloop-thread-5] INFO  i.k.knot.service.ServiceKnotVerticle - Starting <ServiceKnotVerticle>
2017-08-04 15:10:22 [vert.x-eventloop-thread-1] INFO  io.knotx.server.KnotxServerVerticle - Knot.x HTTP Server started. Listening on port 8092
2017-08-04 15:10:22 [vert.x-eventloop-thread-0] INFO  i.k.launcher.KnotxStarterVerticle - Knot.x STARTED

                Deployed 3bd0365c-10ba-4a53-a29c-59b4df06eaff [knotx:io.knotx.FragmentSplitter]
                Deployed defc43bc-ffe0-40cf-8c0c-1be06c5e8739 [knotx:${package}.adapter.example.ExampleServiceAdapter]
                Deployed 6891d9d6-bcfc-42fa-8b21-bd4ea11154da [knotx:io.knotx.FragmentAssembler]
                Deployed 59a2967f-0d87-4dea-ad37-b8fe1dafb898 [knotx:io.knotx.FilesystemRepositoryConnector]
                Deployed b923df1c-f8f9-4615-9b9e-4fba3806a575 [knotx:io.knotx.ActionKnot]
                Deployed c135524e-b4b1-452c-b8e7-628dfc58195d [knotx:io.knotx.ServiceKnot]
                Deployed 93ea2509-e045-49f8-9ddb-fc167e16f020 [knotx:io.knotx.HandlebarsKnot]
                Deployed 880116cf-54a7-4849-954e-dfb4eb536685 [knotx:io.knotx.KnotxServer]
```
Then you can verify the application:
```
$ curl http://localhost:8092/content/local/template.html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Adapter Example</title>
</head>
<body>
  <h1>Adapter Example</h1>
  <!-- start compiled snippet -->
    <p>Message from custom Adapter: Hello Knot.x</p>
  <!-- end compiled snippet -->
</body>
</html>
```