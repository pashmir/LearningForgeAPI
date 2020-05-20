package pashmir.learning.entities;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import pashmir.learning.Learning;

public class MyEntityRenderer implements IRenderFactory<MyEntity>{

	@Override
	public EntityRenderer<? super MyEntity> createRenderFor(EntityRendererManager manager) {
		// TODO Auto-generated method stub
		return this;
	}


}
