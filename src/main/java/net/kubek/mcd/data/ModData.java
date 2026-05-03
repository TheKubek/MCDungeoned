package net.kubek.mcd.data;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.kubek.mcd.MCDungeoned;
import net.minecraft.resources.Identifier;

public class ModData {
    public static final AttachmentType<Integer> SOULS = AttachmentRegistry.createPersistent(Identifier.fromNamespaceAndPath(MCDungeoned.MOD_ID,"souls"), Codec.INT);

    public static void registerModData(){}
}
