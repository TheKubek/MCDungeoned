package net.kubek.mcd.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.kubek.mcd.networking.packet.SoulsPayload;
import net.minecraft.network.RegistryFriendlyByteBuf;

public class ModPackets {
    private static void registerClientbound(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry){
        registry.register(SoulsPayload.TYPE, SoulsPayload.CODEC);
        ClientPlayNetworking.registerGlobalReceiver(SoulsPayload.TYPE, ClientboundPackets::handleSoulsPayload);

    }
    private static void registerServerbound(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry){

    }
    public static void register(){
        registerClientbound(PayloadTypeRegistry.playS2C());
        registerServerbound(PayloadTypeRegistry.playC2S());
    }
}
