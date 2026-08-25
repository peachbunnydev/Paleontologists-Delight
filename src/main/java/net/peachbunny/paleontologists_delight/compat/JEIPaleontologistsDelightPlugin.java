package net.peachbunny.paleontologists_delight.compat;

import com.google.common.collect.Lists;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.peachbunny.paleontologists_delight.PaleontologistsDelight;

import java.util.List;

@JeiPlugin
public class JEIPaleontologistsDelightPlugin implements IModPlugin{
    @Override
    public ResourceLocation getPluginUid()
    {
        return new ResourceLocation(PaleontologistsDelight.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        IModPlugin.super.registerCategories(registration);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        RecipeManager rm = Minecraft.getInstance().level.getRecipeManager();
        PaleoDelRecipes pdl = new PaleoDelRecipes();

        registration.addRecipes(RecipeTypes.CRAFTING, pdl.getSpecialCraftingRecipes());
        //List<CraftingRecipe> recipes = Lists.newArrayList();

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration)
    {
        IModPlugin.super.registerGuiHandlers(registration);
    }
}
