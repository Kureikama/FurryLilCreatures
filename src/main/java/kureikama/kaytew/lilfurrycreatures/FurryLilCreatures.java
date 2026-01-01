package kureikama.kaytew.lilfurrycreatures;

import kureikama.kaytew.lilfurrycreatures.blocks.NestingFloor;
import kureikama.kaytew.lilfurrycreatures.items.Ball;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FurryLilCreatures implements ModInitializer {
	public static final String MOD_ID = "furry-lil-creatures";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello FURRY!!");

        // Initializes ModItems, loading items from its static variables
        Ball.initialize();
        NestingFloor.initialize();
	}
}