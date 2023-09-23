package me.gamingtwist.mixin.client;

import me.gamingtwist.ReplyBotModClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.StatisticsS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinClientPlayNetworkHandler {

    @Inject(method = "onStatistics", at = @At("RETURN"))
    private void onStatistics(StatisticsS2CPacket packet, CallbackInfo info) {
        ReplyBotModClient.handleGimmeStatsCommand();

        // Check if the boolean marker is true
        // If true, send the chat message with stats to the player and flip it back to false
    }
}
