package net.kubek.mcd.item.tool;

import net.kubek.mcd.data.ModData;
import net.kubek.mcd.networking.packet.SoulsHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;


public class FrostScytheItem extends ScytheItem{
    public FrostScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }
    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = attacker.level();
        if(attacker instanceof Player entity) {
            if (!world.isClientSide() && entity.getCooldowns().getCooldownPercent(this.getDefaultInstance(), 0) == 0 && entity.getAttached(ModData.SOULS)>=5) {
                target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS,200,1));
                target.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,200,1));
                entity.getCooldowns().addCooldown(this.getDefaultInstance(), 900);
                SoulsHandler.removeSouls((ServerPlayer) entity,5);

            }
        }
        super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        consumer.accept(Component.translatable("tooltip.mcd.frost_scythe"));
        super.appendHoverText(itemStack, tooltipContext, tooltipDisplay, consumer, tooltipFlag);
    }
}
