package net.kubek.mcd.mixin;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.kubek.mcd.item.ModItems;
import net.kubek.mcd.util.ModTags;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.Consumer;

@Mixin(ItemStack.class)
public class ItemTooltipMixin {
    @Inject(method = "addDetailsToTooltip", at = @At("HEAD"))
    public void addDetailsToTooltipMixin(
            Item.TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, @Nullable Player player, TooltipFlag tooltipFlag, Consumer<Component> consumer, CallbackInfo ci) {
        ItemStack stack = (ItemStack)(Object)this;
        if (stack.is(ModTags.Items.SOULS_COLLECTORS)) {
            consumer.accept(Component.translatable("tooltip.mcd.soul_collector"));
        } else if (stack.is(ModTags.Items.STRONG_SOULS_COLLECTORS)) {
            consumer.accept(Component.translatable("tooltip.mcd.strong_soul_collector"));
        }
    }


}