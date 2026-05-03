package net.kubek.mcd;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.kubek.mcd.data.ModData;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.util.Util;

import java.util.Objects;

public class HudRenderingEntrypoint implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Attach our rendering code to before the chat hud layer. Our layer will render right before the chat. The API will take care of z spacing.
        HudElementRegistry.addLast(Identifier.fromNamespaceAndPath(MCDungeoned.MOD_ID, "souls"), HudRenderingEntrypoint::render);
    }

    private static void render(GuiGraphics graphics, DeltaTracker tickCounter) {
//        int color = 0xFFFF0000; // Red
//        int targetColor = 0xFF00FF00; // Green
//
//        // You can use the Util.getMillis() function to get the current time in milliseconds.
//        // Divide by 1000 to get seconds.
//        double currentTime = Util.getMillis() / 1000.0;
//
//        // "lerp" simply means "linear interpolation", which is a fancy way of saying "blend".
//        float lerpedAmount = Mth.abs(Mth.sin((float) currentTime));
//        int lerpedColor = ARGB.linearLerp(lerpedAmount, color, targetColor);
//
//        // Draw a square with the lerped color.
//        // x1, x2, y1, y2, color
//        graphics.fill(0, 0, 10, 10, lerpedColor);

        if(!Minecraft.getInstance().player.isCreative()&&
                !Minecraft.getInstance().player.isSpectator()&&
                Minecraft.getInstance().player.hasAttached(ModData.SOULS)) {
            int x = graphics.guiWidth() / 9;
            int y = graphics.guiHeight() - 19;
            Identifier texture = Identifier.fromNamespaceAndPath(MCDungeoned.MOD_ID, "textures/gui/sprites/souls_icon.png");
            graphics.blit(
                    RenderPipelines.GUI_TEXTURED,
                    texture,
                    x, y,
                    0, 0,
                    67, 20,
                    67, 20
            );
            graphics.drawString(Minecraft.getInstance().font, (Minecraft.getInstance().player.getAttached(ModData.SOULS)).toString(), x+14 , y + 6 , 0xffFFFFFF);
        }
    }
}
