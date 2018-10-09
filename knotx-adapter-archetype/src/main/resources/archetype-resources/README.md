# ${projectName}

Generated with the [_Knot.x Extension Maven Archetype_](https://github.com/Knotx/knotx-extension-archetype).

Check out the [Knot.x Wiki](https://github.com/Cognifide/knotx/wiki/Adapter) for more information 
about the Adapter concept and APIs used here.

## Adding custom adapter to Knot.x Stack

To run the extension:

1. Build module with `mvn clean package`.
2. Download proper version of Knot.x stack for [Knot.x bintray](https://bintray.com/knotx/downloads/distro).
3. Update `conf/application.conf` with new module definition, global variables and `exampleAdapter.conf` include.
You will find all config entries in `conf/exampleStack.conf`.
4. Update `service.conf` and alter `services` to use example adapter.
5. Copy `includes/exampleAdapter.conf` to the stack `conf/includes` directory.
6. Copy `target/your-adapter-extensions.jar` to `lib` directory in stack instance.
7. Start your Knot.x stack instance.