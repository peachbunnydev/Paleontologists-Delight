package net.peachbunny.paleontologists_delight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.peachbunny.paleontologists_delight.PaleontologistsDelight;
import net.peachbunny.paleontologists_delight.block.EggBlock;
import net.peachbunny.paleontologists_delight.block.PDModBlocks;

public class PDModBlockStateProvider extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public PDModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, PaleontologistsDelight.MOD_ID, exFileHelper);
    }

    protected void registerStatesAndModels()
    {
        customEggBlock(PDModBlocks.BIG_EGG.get());
    }

    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public ResourceLocation resourcePDBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(PaleontologistsDelight.MOD_ID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourcePDBlock(blockName(block)), models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourcePDBlock(path), models().existingFileHelper);
    }

    public void customEggBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            int bites = state.getValue(EggBlock.BITES);
            String suffix = bites > 0 ? "_bite" + bites : "";
            return ConfiguredModel.builder()
                    .modelFile(existingModel(blockName(block) + suffix))
                    .rotationY(((int) state.getValue(EggBlock.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                    .build();
        });
    }
}
