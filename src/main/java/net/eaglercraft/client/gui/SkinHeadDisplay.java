package net.eaglercraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class SkinHeadDisplay {
    private int x;
    private int y;
    private int width;
    private int height;
    private static final int FRAME_COLOR = 0xFF00BFFF;
    private static final int FRAME_WIDTH = 2;
    
    public SkinHeadDisplay(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void draw(Minecraft mc, int mouseX, int mouseY) {
        // Draw frame background
        drawRect(this.x - FRAME_WIDTH, this.y - FRAME_WIDTH,
                this.x + this.width + FRAME_WIDTH, this.y + this.height + FRAME_WIDTH, 0xFF1a1a1a);
        
        // Draw frame border
        drawRect(this.x - FRAME_WIDTH, this.y - FRAME_WIDTH,
                this.x + this.width + FRAME_WIDTH, this.y + FRAME_WIDTH, FRAME_COLOR);
        drawRect(this.x - FRAME_WIDTH, this.y + this.height,
                this.x + this.width + FRAME_WIDTH, this.y + this.height + FRAME_WIDTH, FRAME_COLOR);
        drawRect(this.x - FRAME_WIDTH, this.y - FRAME_WIDTH,
                this.x + FRAME_WIDTH, this.y + this.height + FRAME_WIDTH, FRAME_COLOR);
        drawRect(this.x + this.width, this.y - FRAME_WIDTH,
                this.x + this.width + FRAME_WIDTH, this.y + this.height + FRAME_WIDTH, FRAME_COLOR);
        
        // Draw placeholder head (you can replace this with actual skin rendering)
        drawRect(this.x, this.y, this.x + this.width, this.y + this.height, 0xFF8B8B8B);
        
        // Draw some texture detail
        drawRect(this.x + 5, this.y + 5, this.x + this.width - 5, this.y + 15, 0xFF6B6B6B);
    }
    
    private static void drawRect(int x1, int y1, int x2, int y2, int color) {
        if (x1 < x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        
        if (y1 < y2) {
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }
        
        float alpha = (float) (color >> 24 & 255) / 255.0F;
        float red = (float) (color >> 16 & 255) / 255.0F;
        float green = (float) (color >> 8 & 255) / 255.0F;
        float blue = (float) (color & 255) / 255.0F;
        
        GlStateManager.color(red, green, blue, alpha);
        GlStateManager.disableTexture2D();
        GlStateManager.glPolygonMode(1032, 6914);
        
        // Draw rectangle
        net.minecraft.client.renderer.Tessellator tessellator = net.minecraft.client.renderer.Tessellator.getInstance();
        net.minecraft.client.renderer.BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(7, net.minecraft.client.renderer.vertex.DefaultVertexFormats.POSITION);
        buffer.pos((double)x2, (double)y1, 0.0D).endVertex();
        buffer.pos((double)x1, (double)y1, 0.0D).endVertex();
        buffer.pos((double)x1, (double)y2, 0.0D).endVertex();
        buffer.pos((double)x2, (double)y2, 0.0D).endVertex();
        tessellator.draw();
        
        GlStateManager.glPolygonMode(1032, 6913);
        GlStateManager.enableTexture2D();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
