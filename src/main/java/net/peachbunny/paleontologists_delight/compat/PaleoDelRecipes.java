package net.peachbunny.paleontologists_delight.compat;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.peachbunny.paleontologists_delight.PaleontologistsDelight;
import net.peachbunny.paleontologists_delight.item.PDModItems;
import com.github.teamfossilsarcheology.fossil.item.ModItems;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

import java.util.List;
import java.util.Optional;

public class PaleoDelRecipes
{
    private final RecipeManager recipeManager;

    public PaleoDelRecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;

        if (level != null) {
            this.recipeManager = level.getRecipeManager();
        } else {
            throw new NullPointerException("Minecraft level must not be null.");
        }
    }

    public List<CraftingRecipe> getCraftingRecipes() {
        List<CraftingRecipe> recipes = Lists.newArrayList();

        addValidatedSpecialRecipe(recipes, "scarab_knife", null,
                NonNullList.of(
                        Ingredient.EMPTY,
                        Ingredient.of(Items.STICK),
                        Ingredient.of(ModItems.SCARAB_GEM.get())
                ),
                PDModItems.SCARAB_KNIFE.get()
        );

        return recipes;
    }
//
//    public List<CookingPotRecipe> getCookingRecipes()
//    {
//        List<CookingPotRecipe> recipes = Lists.newArrayList();
//
//        return recipes;
//    }

    public void addValidatedSpecialRecipe(List<CraftingRecipe> recipeList, String recipeId, String group, NonNullList<Ingredient> inputs, ItemLike output) {
        Optional<? extends Recipe<?>> specialRecipe = recipeManager.byKey(findRL(recipeId));

        specialRecipe.ifPresent((recipe) -> {
            recipeList.add(new ShapelessRecipe(recipe.getId(), group, CraftingBookCategory.MISC, new ItemStack(output.asItem()), inputs));
        });
    }

    public static ResourceLocation findRL(String name)
    {
        return new ResourceLocation(PaleontologistsDelight.MOD_ID, name);
    }
}