package net.kubek.mcd.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kubek.mcd.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new RecipeProvider(provider,recipeOutput) {
                @Override
                public void buildRecipes() {
                    registerScytheRecipe(ItemTags.WOODEN_TOOL_MATERIALS, ModItems.WOODEN_SCYTHE,recipeOutput, Items.OAK_PLANKS);
                    registerScytheRecipe(ItemTags.STONE_TOOL_MATERIALS, ModItems.STONE_SCYTHE,recipeOutput, Items.COBBLESTONE);
                    registerScytheRecipe(Items.COPPER_INGOT,ModItems.COPPER_SCYTHE,recipeOutput);
                    registerScytheRecipe(Items.IRON_INGOT,ModItems.IRON_SCYTHE,recipeOutput);
                    registerScytheRecipe(Items.GOLD_INGOT,ModItems.GOLDEN_SCYTHE,recipeOutput);
                    registerScytheRecipe(Items.DIAMOND,ModItems.DIAMOND_SCYTHE,recipeOutput);
                    netheriteSmithing(ModItems.DIAMOND_SCYTHE,RecipeCategory.TOOLS,ModItems.NETHERITE_SCYTHE);
                    shaped(RecipeCategory.TOOLS,ModItems.FROST_SCYTHE)
                            .pattern(" S ")
                            .pattern("S#S")
                            .pattern(" S ")
                            .define('#',ModItems.NETHERITE_SCYTHE)
                            .define('S', Items.BLUE_ICE)
                            .unlockedBy(getHasName(ModItems.NETHERITE_SCYTHE),has(ModItems.NETHERITE_SCYTHE))
                            .save(recipeOutput);
                }
                void registerScytheRecipe(Item input, Item output, RecipeOutput recipeExporter){
                    shaped(RecipeCategory.TOOLS,output)
                            .pattern("## ")
                            .pattern(" S#")
                            .pattern(" S ")
                            .define('#',input)
                            .define('S', Items.STICK)
                            .unlockedBy(getHasName(input),has(input))
                            .save(recipeExporter);
                }
                void registerScytheRecipe(TagKey<Item> input, Item output, RecipeOutput recipeExporter, ItemLike criterion){
                    shaped(RecipeCategory.TOOLS,output)
                            .pattern("## ")
                            .pattern(" S#")
                            .pattern(" S ")
                            .define('#',input)
                            .define('S', Items.STICK)
                            .unlockedBy(getHasName(criterion),has(criterion))
                            .save(recipeExporter);
                }
            };

    }

    @Override
    public String getName() {
        return "Minecraft Dungeoned Recipes";
    }
}
