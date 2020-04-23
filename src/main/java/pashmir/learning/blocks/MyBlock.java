package pashmir.learning.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.extensions.IForgeBlock;
import pashmir.learning.tiles.MyTile;

public class MyBlock extends Block implements IForgeBlock{
	public static final String NAME = "myblock"; 
	public MyBlock(){
		super(Block.Properties.create(Material.IRON));
	}
	
	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world){
		if (hasTileEntity(state)) {
			return new MyTile();			
		}
		return null;
	}
}
