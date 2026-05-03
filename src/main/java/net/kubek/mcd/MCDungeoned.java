package net.kubek.mcd;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.networking.v1.EntityTrackingEvents;
import net.kubek.mcd.data.ModData;
import net.kubek.mcd.event.ServerEvents;
import net.kubek.mcd.item.ModItems;
import net.kubek.mcd.networking.ModPackets;
import net.kubek.mcd.networking.packet.SoulsHandler;
import net.kubek.mcd.util.ModTags;
import net.kubek.mcd.util.PlayerKilledEntity;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCDungeoned implements ModInitializer {
	public static final String MOD_ID = "mcd";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        ModItems.registerModItems();
        ModData.registerModData();
        ServerEvents.runServerEvents();
        ModPackets.register();


        ServerLivingEntityEvents.AFTER_DEATH.register(new PlayerKilledEntity());
	}
}