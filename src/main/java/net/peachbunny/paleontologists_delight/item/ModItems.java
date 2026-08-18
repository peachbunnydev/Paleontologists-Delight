package net.peachbunny.paleontologists_delight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.peachbunny.paleontologists_delight.PaleontologistsDelight;
import vectorwing.farmersdelight.common.item.KnifeItem;

import static vectorwing.farmersdelight.common.registry.ModItems.basicItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PaleontologistsDelight.MOD_ID);

    public static final RegistryObject<Item> SCARAB_KNIFE = ITEMS.register("scarab_knife", () -> new KnifeItem(Tiers.DIAMOND, 0.5F, -2.0F, basicItem()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
