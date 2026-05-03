package net.kubek.mcd.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kubek.mcd.MCDungeoned;
import net.kubek.mcd.item.tool.FrostScytheItem;
import net.kubek.mcd.item.tool.ScytheItem;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ModItems {
    public static final Item WOODEN_SCYTHE = registerItem("wooden_scythe",properties ->new ScytheItem(ToolMaterial.WOOD,1f,-3f,properties));
    public static final Item STONE_SCYTHE = registerItem("stone_scythe", properties -> new ScytheItem(ToolMaterial.STONE,1f,-3f,properties));
    public static final Item COPPER_SCYTHE = registerItem("copper_scythe", properties -> new ScytheItem(ToolMaterial.COPPER,1f,-3f,properties));
    public static final Item IRON_SCYTHE = registerItem("iron_scythe",properties -> new ScytheItem(ToolMaterial.IRON,1f,-3f,properties));
    public static final Item GOLDEN_SCYTHE = registerItem("golden_scythe",properties -> new ScytheItem(ToolMaterial.GOLD,1f,-3f,properties));
    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe",properties -> new ScytheItem(ToolMaterial.DIAMOND,1f,-3f,properties));
    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe",properties -> new ScytheItem(ToolMaterial.NETHERITE,1f,-3f,properties.fireResistant()));

    public static final Item FROST_SCYTHE = registerItem("frost_scythe",properties -> new FrostScytheItem(ToolMaterial.NETHERITE,1f,-3f,properties.fireResistant().rarity(Rarity.EPIC)));

//    public static final Item FISTS = registerItem("fists",properties -> new Item(properties.component(DataComponents.ATTACK_RANGE, new AttackRange(0,2,0,3,1,1)).equippableUnswappable(EquipmentSlot.OFFHAND).sword(ToolMaterial.IRON,1f,-1f)));

    private static Item registerItem(String name, Function<Item.Properties, Item> function){
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MCDungeoned.MOD_ID,name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(MCDungeoned.MOD_ID,name)))));
    }
    public static final void registerModItems(){

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries ->{
            entries.addAfter(Items.WOODEN_HOE,WOODEN_SCYTHE);
            entries.addAfter(Items.STONE_HOE,STONE_SCYTHE);
            entries.addAfter(Items.COPPER_HOE,COPPER_SCYTHE);
            entries.addAfter(Items.IRON_HOE,IRON_SCYTHE);
            entries.addAfter(Items.GOLDEN_HOE,GOLDEN_SCYTHE);
            entries.addAfter(Items.DIAMOND_HOE,DIAMOND_SCYTHE);
            entries.addAfter(Items.NETHERITE_HOE,NETHERITE_SCYTHE);
            entries.addAfter(NETHERITE_SCYTHE,FROST_SCYTHE);
        });

    }
}
