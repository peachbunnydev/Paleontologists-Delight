package net.peachbunny.paleontologists_delight.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.peachbunny.paleontologists_delight.PaleontologistsDelight;

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
        PaleoDelRecipes pdr = new PaleoDelRecipes();

        registration.addRecipes(RecipeTypes.CRAFTING, pdr.getCraftingRecipes());


    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration)
    {
        IModPlugin.super.registerGuiHandlers(registration);
    }
}
