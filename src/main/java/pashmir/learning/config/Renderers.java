package pashmir.learning.config;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pashmir.learning.entities.MyEntityRenderer;


public class Renderers {
	public static void registerAll() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(Renderers::RendererRegistration);
	}
	
	private static void RendererRegistration(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(Registries.MYENTITY.get(),new MyEntityRenderer());
	}
}
