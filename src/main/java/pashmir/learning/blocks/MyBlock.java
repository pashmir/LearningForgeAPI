package pashmir.learning.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MyBlock extends Block{
	public static final String NAME = "myblock"; 
	public MyBlock(){
		super(Block.Properties.create(Material.IRON));
	}
}
