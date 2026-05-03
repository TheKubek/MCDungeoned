package net.kubek.mcd.item.tool;

import net.kubek.mcd.networking.packet.SoulsHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class ScytheItem extends net.minecraft.world.item.HoeItem {
    public ScytheItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Block block = world.getBlockState(blockPos).getBlock();
        BlockState blockState = world.getBlockState(blockPos);
        Player player = context.getPlayer();

        if (block instanceof CropBlock cropBlock) {
            if (cropBlock.isMaxAge(blockState)) {
                if(!world.isClientSide()) {
                    context.getItemInHand().hurtAndBreak(1,((ServerLevel) world),((ServerPlayer) context.getPlayer()),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND)
                    );
                    world.destroyBlock(blockPos, true, player);
                    world.setBlock(blockPos, block.defaultBlockState(),0);
                    SoulsHandler.removeSouls((ServerPlayer) player,1);
                }
            }
            return InteractionResult.SUCCESS;

        }
        else return super.useOn(context);



    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltipDisplay, consumer, tooltipFlag);
    }
}
