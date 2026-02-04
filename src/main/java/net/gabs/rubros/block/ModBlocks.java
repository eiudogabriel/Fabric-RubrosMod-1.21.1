package net.gabs.rubros.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gabs.rubros.Rubros;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block HARVEST_GOLD_BLOCK = registerBlock("harvest_gold_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block HARVEST_GOLD_ORE = registerBlock("harvest_gold_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block HARVEST_GOLD_DEEPSLATE_ORE = registerBlock("harvest_gold_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Rubros.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Rubros.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        Rubros.LOGGER.info("Registering Mod Blocks for " + Rubros.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.HARVEST_GOLD_BLOCK);
        });
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.HARVEST_GOLD_ORE);
            entries.add(ModBlocks.HARVEST_GOLD_DEEPSLATE_ORE);
        });
    }
}
