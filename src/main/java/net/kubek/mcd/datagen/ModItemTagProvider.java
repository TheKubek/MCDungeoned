package net.kubek.mcd.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kubek.mcd.item.ModItems;
import net.kubek.mcd.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(ModTags.Items.SCYTHES)
                .add(ModItems.WOODEN_SCYTHE)
                .add(ModItems.STONE_SCYTHE)
                .add(ModItems.IRON_SCYTHE)
                .add(ModItems.GOLDEN_SCYTHE)
                .add(ModItems.DIAMOND_SCYTHE)
                .add(ModItems.NETHERITE_SCYTHE)
                .add(ModItems.FROST_SCYTHE);

        valueLookupBuilder(ModTags.Items.SOULS_COLLECTORS)
                .add(Items.NETHERITE_SWORD)
                .add(Items.NETHERITE_SPEAR)
                .add(Items.NETHERITE_AXE)
                .add(ModItems.GOLDEN_SCYTHE)
                .add(ModItems.DIAMOND_SCYTHE)
                .add(ModItems.NETHERITE_SCYTHE)
                .add(ModItems.SOUL_KNIFE);
        valueLookupBuilder(ModTags.Items.STRONG_SOULS_COLLECTORS)
                .add(ModItems.FROST_SCYTHE);
        valueLookupBuilder(ModTags.Items.TWO_HANDED)
                .add(ModItems.SOUL_KNIFE);
        valueLookupBuilder(ModTags.Items.HEAVY_ONE_HAND)
                .add(ModItems.HAMMER)
                .add(ModItems.STORMLANDER);
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.SOUL_KNIFE);
        valueLookupBuilder(ItemTags.HOES)
                .addTag(ModTags.Items.SCYTHES);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.HAMMER)
                .add(ModItems.STORMLANDER);

    }
}
