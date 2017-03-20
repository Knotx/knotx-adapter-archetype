![Knot.x logo](https://avatars2.githubusercontent.com/u/24564424?v=3&s=400)

# Knot.x Extension Maven Archetype

Use this archetype to generate a custom [_Knot.x_](https://github.com/Cognifide/knotx/wiki) extension. Details regarding the contents of a project generated using this archetype can be found
in the `README.md` file in `src/main/resources/archetype-resources` (or in the main directory once a project has been generated).

## Building the archetype

To build the archetype and install it in your local Maven repository, simply run

    mvn clean install
    
## Using the Archetype to Generate a Project

Once you've built the archetype, you can generate a new project using the following command:

    mvn archetype:generate -DarchetypeGroupId=io.knotx.archetypes -DarchetypeArtifactId=knotx-extension-archetype -DarchetypeVersion=1-SNAPSHOT
    
You will be asked to provide values for the following properties:

- `groupId` - this is the group ID of the Maven project being generated
- `artifactId` - this is the Artifact ID of the project being generated
- `version` - this is the initial version of the project being generated
- `package` - this is the base package for all Java classes in the Maven project being generated
- `projectName` - this is a human-readable project name to be used in the resulting `pom.xml` and documentation
