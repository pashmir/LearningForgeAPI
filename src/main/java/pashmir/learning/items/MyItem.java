package pashmir.learning.items;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import pashmir.learning.Learning;

public class MyItem extends ArmorItem{
	public static final String NAME = "myitem";
	public MyItem() {
		super(ArmorMaterial.DIAMOND, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).group(ItemGroup.COMBAT));
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return (Learning.MODID + ":textures/models/armor/myitem.png");
    }
}
