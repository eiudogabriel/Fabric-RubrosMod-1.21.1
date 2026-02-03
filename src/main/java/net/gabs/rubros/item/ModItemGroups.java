package net.gabs.rubros.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.gabs.rubros.Rubros;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup GOLD_GENERATED_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Rubros.MOD_ID, "gold_generated_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GOLD_COIN))
                    .displayName(Text.translatable("itemgroup.rubros.gold_generated_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GOLD_COIN);
                        entries.add(ModItems.HARVEST_GOLD_COIN);
                    }).build());


    public static void registerItemGroups() {
        Rubros.LOGGER.info("Registering Item groups for " + Rubros.MOD_ID);
    }
}
