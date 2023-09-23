package me.gamingtwist;

import com.sun.security.jgss.InquireType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.ClientStatusC2SPacket;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;

public class ReplyBotModClient implements ClientModInitializer {
    //Chat chat;
    static boolean requested = false;

    @Override
    public void onInitializeClient() {
        ClientReceiveMessageEvents.GAME.register(((message, overlay) -> {
            //MinecraftClient.getInstance().player.sendMessage(message);
            checkMessage(message);

        }));
        ClientReceiveMessageEvents.CHAT.register((message, signedMessage, sender, params, receptionTimestamp) -> {
            // Check if the message is from a player and not a system message
            //MinecraftClient.getInstance().player.sendMessage(message);
            checkMessage(message);

        });
    }

    private static void checkMessage(Text message) {
        if (!message.getString().toLowerCase().contains("!ice")) {
            return;
        }

        requested = true;

        MinecraftClient.getInstance().getNetworkHandler().sendPacket(new ClientStatusC2SPacket(ClientStatusC2SPacket.Mode.REQUEST_STATS));
    }

    public static boolean handleGimmeStatsCommand() {
        if (!requested) {
            return false;
        }

        int iceMined = MinecraftClient.getInstance().player.getStatHandler().getStat(Stats.MINED.getOrCreateStat(Blocks.ICE));
        MinecraftClient.getInstance().player.sendMessage(Text.of(Integer.toString(iceMined)));

        MinecraftClient.getInstance().getNetworkHandler().sendChatMessage("Ice mined: "+  java.text.NumberFormat.getNumberInstance().format(iceMined));

        requested = false;
        // Send REQUEST_STATS packet to the server
        // Flip a boolean marker to true

        return true;
    }
    // Method to handle the "Gimme Stats" command

}