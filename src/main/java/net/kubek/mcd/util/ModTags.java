package net.kubek.mcd.util;

import net.kubek.mcd.MCDungeoned;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        private static TagKey<Block> createTag(String name){
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MCDungeoned.MOD_ID,name));
        }
    }
    public static class Items{

        public static final TagKey<Item> SCYTHES = createTag("scythes");
        public static final TagKey<Item> SOULS_COLLECTORS = createTag("souls_collectors");
        public static final TagKey<Item> STRONG_SOULS_COLLECTORS = createTag("strong_souls_collectors");
        public static final TagKey<Item> TWO_HANDED = createTag("two_handed");
        public static final TagKey<Item> HEAVY_ONE_HAND = createTag("heavy_one_hand");

        private static TagKey<Item> createTag(String name){
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCDungeoned.MOD_ID,name));
        }
    }
}
