package pashmir.learning.tiles;

import java.util.List;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import pashmir.learning.config.Registries;

public class MyTile extends TileEntity implements ITickableTileEntity {
	public static final String NAME = "mytile";
	private Effect Effect = Effects.SPEED;
	public MyTile(){
		super( Registries.MYTILE.get() );
	}
	
	public void tick() {
		if (this.world.getGameTime() % 80L == 0L) {
			this.addEffectsToPlayers();
        }
    }

	
	private void addEffectsToPlayers() {
	      if (!this.world.isRemote) {
	         double d0 = (double)(64);//radius
	         
	         int i = 0; //potion lvl

	         int j = (20) * 20; //potion duration: 20 seconds
	         
	         AxisAlignedBB axisalignedbb = (new AxisAlignedBB(this.pos)).grow(d0).expand(0.0D, (double)this.world.getHeight(), 0.0D);
	         List<PlayerEntity> list = this.world.getEntitiesWithinAABB(PlayerEntity.class, axisalignedbb);

	         for(PlayerEntity playerentity : list) {
	            playerentity.addPotionEffect(new EffectInstance(this.Effect, j, i, true, true));

	         }
	      }
	   }
	
}
