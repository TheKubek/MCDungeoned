package net.kubek.mcd.mixin;

import net.kubek.mcd.util.ModTags;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerModel.class)
public class AttackRendererAnimationsMixin<T extends LivingEntity> {

    @Inject(method = "setupAnim", at = @At("TAIL"))
    private void setupAnim(AvatarRenderState state, CallbackInfo ci) {
        if(!(state.entityType == EntityType.PLAYER)) return;
        PlayerModel model = (PlayerModel)(Object)this;

        float swing = state.attackTime;

        // 1 = idle, 0 = pełny swing
        float idleWeight = 1.0F - swing;

        if (state.getMainHandItemStack().is(ModTags.Items.TWO_HANDED)) {

            if (state.attackArm == HumanoidArm.RIGHT) {

                setPose(model.rightArm,
                        -66, -23, 2,
                        idleWeight);
                if(!state.isInWater) {
                    setPose(model.leftArm,
                            -49, 44, 28,
                            idleWeight);
                }
            } else {

                setPose(model.leftArm,
                        -66, 23, 2,
                        idleWeight);
                if(!state.isInWater) {
                    setPose(model.rightArm,
                            -73, -40, 12,
                            idleWeight);
                }
            }
        }

        else if (state.getMainHandItemStack().is(ModTags.Items.HEAVY_ONE_HAND)) {

            if (state.attackArm == HumanoidArm.RIGHT) {

                applyPose(model.rightArm,
                        20, 28, 19,
                        idleWeight);

            } else {

                applyPose(model.leftArm,
                        20, -28, -19,
                        idleWeight);
            }
        }
    }

    private void applyPose(net.minecraft.client.model.geom.ModelPart arm,
                           float xDeg, float yDeg, float zDeg,
                           float weight) {

        arm.xRot += Math.toRadians(xDeg) * weight;
        arm.yRot += Math.toRadians(yDeg) * weight;
        arm.zRot += Math.toRadians(zDeg) * weight;
    }
private void setPose(net.minecraft.client.model.geom.ModelPart arm,
                           float xDeg, float yDeg, float zDeg,
                           float weight) {

        arm.xRot = (float) (Math.toRadians(xDeg) * weight);
        arm.yRot = (float) (Math.toRadians(yDeg) * weight);
        arm.zRot = (float) (Math.toRadians(zDeg) * weight);
    }

}