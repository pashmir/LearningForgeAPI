package pashmir.learning.entities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import pashmir.learning.config.Registries;

public class MyEntity extends AnimalEntity {
	public static final String NAME = "myentity";
	
	public MyEntity(EntityType<? extends MyEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public MyEntity createChild(AgeableEntity myEntityFather) {
		MyEntity myEntityBaby =  (Registries.MYENTITY.get()).create(myEntityFather.world);
		return myEntityBaby;
	}
	
	
}
