package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiButtonCustom extends GuiButton {
    private static final int BUTTON_COLOR = 0xFF2a2a2a;
    private static final int BUTTON_HOVER_COLOR = 0xFF3d3d3d;
    private static final int BUTTON_TEXT_COLOR = 0xFFFFFF;
    private static final int BUTTON_HOVER_TEXT_COLOR = 0xFF00BFFF;
    private static final int BORDER_TOP_COLOR = 0xFF4a4a4a;
    private static final int BORDER_BOTTOM_COLOR = 0xFF1a1a1a;
    
    public GuiButtonCustom(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }
    
    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (!this.visible) {
            return;
        }
        
        boolean isHovered = mouseX >= this.xPosition && mouseY >= this.yPosition &&
                           mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
        
        this.hovered = isHovered;
        
        // Draw button background
        int bgColor = isHovered ? BUTTON_HOVER_COLOR : BUTTON_COLOR;
        drawRect(this.xPosition, this.yPosition,
                this.xPosition + this.width, this.yPosition + this.height, bgColor);
        
        // Draw top border (highlight)
        drawRect(this.xPosition, this.yPosition,
                this.xPosition + this.width, this.yPosition + 1, BORDER_TOP_COLOR);
        
        // Draw bottom border (shadow)
        drawRect(this.xPosition, this.yPosition + this.height - 1,
                this.xPosition + this.width, this.yPosition + this.height, BORDER_BOTTOM_COLOR);
        
        // Draw left border
        drawRect(this.xPosition, this.yPosition,
                this.xPosition + 1, this.yPosition + this.height, BORDER_TOP_COLOR);
        
        // Draw right border
        drawRect(this.xPosition + this.width - 1, this.yPosition,
                this.xPosition + this.width, this.yPosition + this.height, BORDER_BOTTOM_COLOR);
        
        // Draw text
        int textColor = isHovered ? BUTTON_HOVER_TEXT_COLOR : BUTTON_TEXT_COLOR;
        mc.fontRendererObj.drawCenteredString(this.displayString,
                this.xPosition + this.width / 2,
                this.yPosition + (this.height - 8) / 2,
                textColor);
    }
}
