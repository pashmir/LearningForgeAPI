package pashmir.learning;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import pashmir.learning.config.Registries;
import pashmir.learning.config.Renderers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("learning")
public class Learning {
	public static final String MODID = "learning";
	// Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Learning() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        // Register client renderers
        //Renderers.registerAll();
        
        // Register everything
        LOGGER.info("Calling registrarion class...");
        Registries.registerAll();
    }

}
