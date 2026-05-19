package net.eaglercraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class LiquidBounceSkinCustomizer extends GuiScreen {
    private GuiScreen parentScreen;
    private LiquidBounceButton applySkinBtn;
    private LiquidBounceButton applyCapeBtn;
    private LiquidBounceButton backBtn;
    
    private static final int DARK_BG = 0xFF1a1a1a;
    private static final int HEADER_COLOR = 0xFFFFFF;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 35;
    
    public LiquidBounceSkinCustomizer(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        
        applySkinBtn = new LiquidBounceButton(0, centerX - BUTTON_WIDTH / 2, centerY - 50, BUTTON_WIDTH, BUTTON_HEIGHT, "Change Skin");
        applyCapeBtn = new LiquidBounceButton(1, centerX - BUTTON_WIDTH / 2, centerY, BUTTON_WIDTH, BUTTON_HEIGHT, "Change Cape");
        backBtn = new LiquidBounceButton(2, centerX - BUTTON_WIDTH / 2, centerY + 50, BUTTON_WIDTH, BUTTON_HEIGHT, "Back");
        
        this.buttonList.add(applySkinBtn);
        this.buttonList.add(applyCapeBtn);
        this.buttonList.add(backBtn);
    }
    
    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            // Open skin file selector
            openSkinSelector();
        } else if (button.id == 1) {
            // Open cape file selector
            openCapeSelector();
        } else if (button.id == 2) {
            // Go back
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Draw dark background
        drawRect(0, 0, this.width, this.height, DARK_BG);
        
        // Draw top bar
        drawRect(0, 0, this.width, 50, 0xFF0f0f0f);
        
        // Draw header
        this.fontRendererObj.drawCenteredStringWithShadow("Customize Your Character", this.width / 2, 20, HEADER_COLOR);
        
        // Draw info text
        this.fontRendererObj.drawCenteredStringWithShadow("Select a PNG file for your skin or cape", this.width / 2, this.height - 25, 0xFF888888);
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    private void openSkinSelector() {
        // TODO: Implement file chooser for skin
        // This would typically open a file dialog to select a skin texture
    }
    
    private void openCapeSelector() {
        // TODO: Implement file chooser for cape
        // This would typically open a file dialog to select a cape texture
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
