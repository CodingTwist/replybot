package me.gamingtwist;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.dedicated.gui.PlayerStatsGui;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.registry.Registry;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("replybot");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		// Register a chat listener
//		ServerMessageEvents.CHAT_MESSAGE.register((message, sender, params) -> {
//		String text = message.signedBody().toString(); // Get the chat message as a string
//			System.out.println("Received chat message: " + text);
//
//			MinecraftClient.getInstance().getSession().getUsername();
//
//			int iceMine = sender.getStatHandler().getStat(Stats.MINED.getOrCreateStat(Blocks.ICE));
//
//			// Your custom logic to handle the chat message
//			if (text.contains("!ice")) {
//				System.out.println(iceMine);
//
//				// Do something when the chat message contains your_keyword
//			}
//		});
		LOGGER.info("Hello Fabric world!");
	}

}