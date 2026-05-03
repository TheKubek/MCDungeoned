package net.kubek.mcd.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kubek.mcd.data.ModData;
import net.kubek.mcd.networking.packet.SoulsHandler;
import net.kubek.mcd.networking.packet.SoulsPayload;

public class ServerEvents {
    public static void runServerEvents(){
        ServerPlayerEvents.JOIN.register(player -> {
            if(!player.hasAttached(ModData.SOULS)) {
                SoulsHandler.setSouls(player,0);
            }
            ServerPlayNetworking.send(player,new SoulsPayload(0,player.getAttached(ModData.SOULS)));
        });
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) ->{
            SoulsHandler.setSouls(newPlayer,oldPlayer.getAttached(ModData.SOULS));
        });
    }
}
