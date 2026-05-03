package net.kubek.mcd.networking.packet;

import net.kubek.mcd.MCDungeoned;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record SoulsPayload(int oldValue, int newValue) implements CustomPacketPayload {
    public static final Type<SoulsPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(MCDungeoned.MOD_ID,"souls_payload"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SoulsPayload> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            SoulsPayload::oldValue,
            ByteBufCodecs.VAR_INT,
            SoulsPayload::newValue,

            SoulsPayload::new
    );
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
