package pashmir.learning.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pashmir.learning.Learning;
import pashmir.learning.blocks.MyBlock;
import pashmir.learning.entities.MyEntity;
import pashmir.learning.items.MyItem;
import pashmir.learning.tiles.MyTile;

public class Registries {
	private static final Logger LOGGER = LogManager.getLogger();
	//creation of deferred register for blocks
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Learning.MODID);
	//adding my custom blocks from the blocks package
	public static final RegistryObject<Block> MYBLOCK = BLOCKS.register(MyBlock.NAME, () -> new MyBlock() );
	//creation of deferred register for items
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Learning.MODID);
	//adding custom items from the items package
	public static final RegistryObject<Item> MYITEM = ITEMS.register(MyItem.NAME , () -> new MyItem() );
	//creation of deferred register for tile entities
	public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Learning.MODID);
	//adding custom TEs from the tile entities package
	public static final RegistryObject<TileEntityType<?>> MYTILE = TILES.register(MyTile.NAME,() -> TileEntityType.Builder.create( MyTile::new, MYBLOCK.get()).build(null) );
	//creation of deferred register for entities
	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Learning.MODID);
	//adding custom entity from entities package
	public static final RegistryObject<EntityType<MyEntity>> MYENTITY = ENTITIES.register(MyEntity.NAME, () -> EntityType.Builder.create( MyEntity::new , EntityClassification.MISC).build(null));
	
	static {
		//my block item are not in items package since they depend on the blocks class
		//if more blocks were added, it would be convenient to register the items using a stream
		ITEMS.register(MyBlock.NAME, () -> new BlockItem( MYBLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).maxStackSize(16) ));
	}
	
	public Registries(){	
	}
	
	public static final void registerAll() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("Adding blocks to registry");
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("Adding items to registry");
		TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("Adding tile entities to registry");
		ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("Adding entities to registry");
	}
}
