package net.gabs.rubros;

import net.fabricmc.api.ModInitializer;

import net.gabs.rubros.block.ModBlocks;
import net.gabs.rubros.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rubros implements ModInitializer {
	public static final String MOD_ID = "rubros";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}