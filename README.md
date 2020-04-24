# Learning forge mod creation
## The following mod must contain
- A modded block * Done *
- A modded item (not the block item)
- A modded tile entity * Done *
- A modded entity
- A custom recipe * Done *
- A cosmetic piece of armor
- Each of which is desired to have a custom feature

## What I learned
There's no mcmod.info, instead there is a mods.toml that has to be in META-INF folder for some reason.

Running the client from eclipse shows no version number but it does show when ran outside eclipse.

There has to be a pack.mcmeta that tells the game about the mod's resources. It is written in json format and only specifies a a pack object of version 5 and a description.

Running the client from eclipse shows the debug console.

The example mod has some methods which show you how to communicate between mods and how to log or do things in events while the game loads.

I learned how to use the deferred register in the registries class.

I learned how to make tile entities in deferred registers. The tile entity type is created at runtime, so the tile entity constructor can call it even though there is no explicit declaration in the code.

I learned a lot about data packs. Forge treats the data folder as the data folder of a datapack. After I read the docs it was not so clear where I should save this data folder. I found out it must go in the resources folder.