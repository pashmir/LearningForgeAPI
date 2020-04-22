package pashmir.learning.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pashmir.learning.Learning;
import pashmir.learning.blocks.MyBlock;

public class Registries {
	private static final Logger LOGGER = LogManager.getLogger();
	//creation of deferred register for blocks
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Learning.MODID);
	//adding my custom blocks from the blocks class
	public static final RegistryObject<Block> MYBLOCK = BLOCKS.register(MyBlock.NAME, () -> new MyBlock() );
	//creation of defered register for items
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Learning.MODID);
	//adding custom items from the items class
	
	static {
		//block item are not in items class since they depend on the blocks class
		ITEMS.register(MyBlock.NAME, () -> new BlockItem( MYBLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).maxStackSize(16) ));
	}
	
	public Registries(){	
	}
	
	public static final void registerAll() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("Adding blocks to registry");
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("Adding items to registry");
	}
}
