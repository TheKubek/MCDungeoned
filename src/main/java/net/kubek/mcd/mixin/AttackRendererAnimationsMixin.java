package net.kubek.mcd.mixin;

import net.kubek.mcd.item.weapon.SoulKnifeItem;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerModel.class)
public class AttackRendererAnimationsMixin<T extends LivingEntity> {

    @Inject(method = "setupAnim", at = @At("TAIL"))
    private void setupAnim(AvatarRenderState state, CallbackInfo ci) {

        if (state.getMainHandItemStack().getItem() instanceof SoulKnifeItem){
        PlayerModel model = (PlayerModel)(Object)this;


        float swing = state.attackTime;
        if (!(swing <= 0.0F)) {
            model.rightArm.xRot = (float) Math.toRadians(-26)+(float) Math.toRadians(-38)*swing;

            model.leftArm.xRot = (float) Math.toRadians(-49);
            model.leftArm.yRot = (float) Math.toRadians(44);
            model.leftArm.zRot = (float) Math.toRadians(28);

        }
        else{
            model.rightArm.xRot = (float) Math.toRadians(-66);
            model.rightArm.yRot = (float) Math.toRadians(-23);
            model.rightArm.zRot = (float) Math.toRadians(2);

            model.leftArm.xRot = (float) Math.toRadians(-49);
            model.leftArm.yRot = (float) Math.toRadians(44);
            model.leftArm.zRot = (float) Math.toRadians(28);
        }
        }
    }
}