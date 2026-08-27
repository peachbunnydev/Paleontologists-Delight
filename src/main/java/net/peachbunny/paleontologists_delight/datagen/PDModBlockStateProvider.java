package net.peachbunny.paleontologists_delight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.peachbunny.paleontologists_delight.PaleontologistsDelight;
import net.peachbunny.paleontologists_delight.block.PDModBlocks;

public class PDModBlockStateProvider extends BlockStateProvider {
    public PDModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, PaleontologistsDelight.MOD_ID, exFileHelper);
    }

    protected void registerStatesAndModels()
    {
        simpleBlock(PDModBlocks.BIG_EGG.get(), new ModelFile.UncheckedModelFile(modLoc("block/big_egg_block")));
    }
}
