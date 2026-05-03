package net.kubek.mcd.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.kubek.mcd.data.ModData;
import net.kubek.mcd.networking.packet.SoulsPayload;

public class ClientboundPackets {
    public static void handleSoulsPayload(SoulsPayload soulsPayload, ClientPlayNetworking.Context context){
        context.player().setAttached(ModData.SOULS, soulsPayload.newValue   ());
    }
}
