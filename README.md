[![][travis img]][travis]
[![][license img]][license]
[![][gitter img]][gitter]

![Knot.x logo](https://raw.githubusercontent.com/Cognifide/knotx/master/icons/180x180.png)

# Knot.x Extension Maven Archetype

Use this archetype to generate a custom Knot.x extension:
 - [Knot / Gateway API](https://github.com/Cognifide/knotx/wiki/Knot)
 - [Adapter](https://github.com/Cognifide/knotx/wiki/Adapter)

Details regarding the content of a project generated using this archetype can be found
in the `README.md` file in `src/main/resources/archetype-resources` in a particular submodule 
(or in the main directory once a project has been generated).

## Building the archetype

To build the archetype and install it in your local Maven repository, simply run
```
    mvn clean install
```
## Using the Archetype to Generate a Project

Once you've built the archetype, you can generate a new project using the following command:
 - Knot
 ```
    mvn archetype:generate -DarchetypeGroupId=io.knotx.archetypes -DarchetypeArtifactId=knotx-knot-archetype -DarchetypeVersion=1.1.1-SNAPSHOT
 ```
 - Adapter
 ```
    mvn archetype:generate -DarchetypeGroupId=io.knotx.archetypes -DarchetypeArtifactId=knotx-adapter-archetype -DarchetypeVersion=1.1.1-SNAPSHOT
 ```
You will be asked to provide values for the following properties:

- `groupId` - this is the group ID of the Maven project being generated
- `artifactId` - this is the Artifact ID of the project being generated
- `version` - this is the initial version of the project being generated
- `package` - this is the base package for all Java classes in the Maven project being generated
- `projectName` - this is a human-readable project name to be used in the resulting `pom.xml` and documentation

[travis]:https://travis-ci.org/Knotx/knotx-extension-archetype/
[travis img]:https://api.travis-ci.org/Knotx/knotx-extension-archetype.svg?branch=master

[license]:https://github.com/Knotx/knotx-extension-archetype/blob/master/LICENSE
[license img]:https://img.shields.io/badge/License-Apache%202.0-blue.svg

[gitter]:https://gitter.im/Knotx/Lobby
[gitter img]:https://badges.gitter.im/Knotx/knotx-extensions.svg
