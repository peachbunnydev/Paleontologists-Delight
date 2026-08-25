package net.peachbunny.paleontologists_delight.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.peachbunny.paleontologists_delight.PaleontologistsDelight;
import net.peachbunny.paleontologists_delight.item.PDModItems;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

public class PDModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, PaleontologistsDelight.MOD_ID);


    public static final Supplier<Block> BIG_EGG = BLOCKS.register("big_egg_block",
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), PDModItems.BIG_EGG));
}
