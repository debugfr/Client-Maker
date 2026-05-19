package net.eaglercraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class LiquidBounceButton extends GuiButton {
    private static final int BUTTON_COLOR = 0xFF2a2a2a;
    private static final int BUTTON_HOVER_COLOR = 0xFF3d3d3d;
    private static final int BUTTON_BORDER_COLOR = 0xFF1a1a1a;
    private static final int BUTTON_TEXT_COLOR = 0xFFFFFF;
    private static final int BUTTON_TEXT_HOVER_COLOR = 0xFF00BFFF;
    
    private boolean isHovered = false;
    
    public LiquidBounceButton(int buttonId, int x, int y, int width, int height, String displayString) {
        super(buttonId, x, y, width, height, displayString);
    }
    
    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (!this.visible) return;
        
        this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition &&
                       mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
        this.isHovered = this.hovered;
        
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        
        // Draw button background
        int bgColor = this.hovered ? BUTTON_HOVER_COLOR : BUTTON_COLOR;
        drawRect(this.xPosition, this.yPosition,
                this.xPosition + this.width, this.yPosition + this.height, bgColor);
        
        // Draw top border (highlight)
        drawRect(this.xPosition, this.yPosition,
                this.xPosition + this.width, this.yPosition + 1, 0xFF4a4a4a);
        
        // Draw bottom border (shadow)
        drawRect(this.xPosition, this.yPosition + this.height - 1,
                this.xPosition + this.width, this.yPosition + this.height, 0xFF0a0a0a);
        
        // Draw left border
        drawRect(this.xPosition, this.yPosition,
                this.xPosition + 1, this.yPosition + this.height, 0xFF0a0a0a);
        
        // Draw right border
        drawRect(this.xPosition + this.width - 1, this.yPosition,
                this.xPosition + this.width, this.yPosition + this.height, 0xFF4a4a4a);
        
        // Draw text
        int textColor = this.hovered ? BUTTON_TEXT_HOVER_COLOR : BUTTON_TEXT_COLOR;
        mc.fontRendererObj.drawCenteredString(this.displayString,
                this.xPosition + this.width / 2,
                this.yPosition + (this.height - 8) / 2,
                textColor);
    }
}
