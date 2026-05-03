package net.kubek.mcd.util;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.kubek.mcd.networking.packet.SoulsHandler;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class PlayerKilledEntity implements ServerLivingEntityEvents.AfterDeath{
    @Override
    public void afterDeath(LivingEntity livingEntity, DamageSource damageSource) {
        if(damageSource.getEntity() instanceof Player player){
            if(damageSource.getWeaponItem().is(ModTags.Items.SOULS_COLLECTORS)){
                SoulsHandler.addSouls((ServerPlayer) player, 1);
                if(!player.level().isClientSide()){
                    ((ServerLevel) player.level()).sendParticles(
                            ParticleTypes.SCULK_SOUL
                            ,livingEntity.getX()
                            ,livingEntity.getY()+1
                            ,livingEntity.getZ()
                            ,1
                            ,0,1,0
                            ,0.001);
                }
            }
            else if(damageSource.getWeaponItem().is(ModTags.Items.STRONG_SOULS_COLLECTORS  /*|| damageSource.getWeaponItem().getEnchantments*/)){
                SoulsHandler.addSouls((ServerPlayer) player, 5);
                if(!player.level().isClientSide()){
                    ((ServerLevel) player.level()).sendParticles(
                            ParticleTypes.SCULK_SOUL
                            ,livingEntity.getX()
                            ,livingEntity.getY()+1
                            ,livingEntity.getZ()
                            ,5
                            ,0,1,0
                            ,0.001);
                }
            }
        }
    }
}
