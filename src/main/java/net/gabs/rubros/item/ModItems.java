package net.gabs.rubros.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gabs.rubros.Rubros;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item GOLD_COIN = registerItem("gold_coin", new Item(new Item.Settings()));
    public static final Item HARVEST_GOLD_COIN = registerItem("harvest_gold_coin", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Rubros.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Rubros.LOGGER.info("Registering mod items for " + Rubros.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(GOLD_COIN);
            entries.add(HARVEST_GOLD_COIN);
        });

    }
}
