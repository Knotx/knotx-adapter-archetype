# How to release Knot.x Extension Maven Archetype

## Prerequisites
1. Sonatype.org [JIRA](https://issues.sonatype.org/secure/Signup!default.jspa) account

2. Your Sonatype.org account needs to be added to the Knot.x project (if it isn't, please contact the Knot.x team: 
[knotx.team@gmail.com](email:knotx.team@gmail.com))

3. A GPG key generated for the email you have registered on the Sonatype.org JIRA 
(Follow the [Working with PGP Signatures](http://central.sonatype.org/pages/working-with-pgp-signatures.html) 
guide to get one). 
**Don't forget to deploy your public key to the key server!** 

4. Add a `<server>` entry to [your `settings.xml` file](https://maven.apache.org/settings.html#Introduction)
   ```xml
   <servers>
     ...
     <server>
       <id>ossrh</id>
       <username>your_sonatype_org_jira_username</username>
       <password>your_sonatype_org_jira_password</password>
     </server>
       ...
   </servers>    
   ```

## Steps

1. Create a release branch from the `master` branch

   ```
   $> git checkout -b release/X.Y.Z
   ```
   where X, Y and Z are the major, mid and minor version number of the release respectively.

2. Set proper Knot.x version that corresponds `X.Y.Z` archetype version in [Knot](https://github.com/Knotx/knotx-extension-archetype/blob/master/knotx-knot-archetype/src/main/resources/archetype-resources/pom.xml)
 and [Adapter](https://github.com/Knotx/knotx-extension-archetype/blob/master/knotx-adapter-archetype/src/main/resources/archetype-resources/pom.xml) pom files.
Remember about updating Vert.x version too.

3. Update `archetype.properties` for both archetypes.

4. Set the release version

   ```
   $> mvn versions:set -DnewVersion=X.Y.Z -DgenerateBackupPoms=false
   ```

5. Commit changes to the release branch and push to the remote

   ```
   $> git add -A .
   $> git commit -m "Prepare release X.Y.Z"
   $> git push
   ```

6. Build & deploy the artifact to the Nexus Staging repository

   ```
   $> mvn clean deploy -Prelease -Dgpg.passphrase=<your_gpg_key_passphrase>
   ```
   
7. On successful deployment, confirm that the artifacts with version X.Y.Z are available on the Nexus Staging:
[https://oss.sonatype.org/content/groups/staging/io/knotx/archetypes/](https://oss.sonatype.org/content/groups/staging/io/knotx/archetypes/)

8. If everything is fine, promote the release to **Nexus Central Release Repositories**

   ```
   $> mvn nexus-staging:release
   ```
   
   In case you want to drop the release, you can use `nexus-staging:drop`
   
9. Create a release on Github: [https://github.com/Knotx/knotx-extension-archetype/releases/new](https://github.com/Knotx/knotx-extension-archetype/releases/new)
  - Set the proper Tag version, e.g.: `X.Y.Z` on the `release/X.Y.Z` branch
  - Set the title of the release: `X.Y.Z`
  - Set the description of the release:

```
    To generate a new project with dependency to Knot.x X.Y.Z use the following command:
    - Knot
    
    `
    mvn archetype:generate -DarchetypeGroupId=io.knotx.archetypes -DarchetypeArtifactId=knotx-knot-archetype -DarchetypeVersion=X.Y.Z
    `
    
    - Adapter
    
    `
    mvn archetype:generate -DarchetypeGroupId=io.knotx.archetypes -DarchetypeArtifactId=knotx-adapter-archetype -DarchetypeVersion=X.Y.Z
    `
```

**Replace `<X.Y.Z>` in the maven.org URL with the proper version**