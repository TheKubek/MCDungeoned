package net.kubek.mcd.item.weapon;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class StormlanderItem extends Item {
    public StormlanderItem(Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity livingEntity2) {
        super.hurtEnemy(itemStack, livingEntity, livingEntity2);
    }
}
