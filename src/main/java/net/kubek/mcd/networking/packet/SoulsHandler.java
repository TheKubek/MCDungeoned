package net.kubek.mcd.networking.packet;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kubek.mcd.data.ModData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class SoulsHandler {
    public static void setSouls(ServerPlayer player, int value){
        player.setAttached(ModData.SOULS,value);
        ServerPlayNetworking.send(player,new SoulsPayload(0,value));
    }
    public static void addSouls(ServerPlayer player, int value){
        int current = player.getAttached(ModData.SOULS);
        player.setAttached(ModData.SOULS,current+value);
        ServerPlayNetworking.send(player,new SoulsPayload(0,current+value));
    }
    public static void removeSouls(ServerPlayer player, int value){
        int current = player.getAttached(ModData.SOULS);
        player.setAttached(ModData.SOULS,current-value);
        ServerPlayNetworking.send(player,new SoulsPayload(0,current-value));
    }




}
