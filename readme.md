# Furnace Tools

## Overview

This is minecraft mod that adds a few tools to the game.
Furnace based tools are a bit more expensive than their vanilla counterparts, but they have the advantage of higher durability and the ability to smelt blocks.

## Build Mod

First, you need to prepare your workspace. This mod uses Minecraft Forge, so you need to download the applicable version of Forge and run the following command:

```bash
gradlew setupDecompWorkspace
```
Currently, the mod is built against Minecraft 1.12.2, recommended Forge version is `1.12.2-14.23.5.2859`.
Link: https://files.minecraftforge.net/net/minecraftforge/forge/index_1.12.2.html (forgefiles)

Second, clone this repository, into `src` directory.
You must check that the `FurnaceTools.java` file is located in `./src/main/java/net/maplenotes/furnacetools/` directory.

Third, edit `build.gradle`. Append under in that tail:

```
sourceSets {
    main {
        output.resourcesDir = output.classesDir
    }
}

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}
```

If you want test play, use `gradlew runClient` command.

Finally, you can build the mod using the following command:

```bash
gradlew build
```

Binary file will be created in `./build/libs/` directory.
