package net.eaglercraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class LiquidBounceMainMenu extends GuiScreen {
    private LiquidBounceButton singleplayerBtn;
    private LiquidBounceButton multiplayerBtn;
    private LiquidBounceButton optionsBtn;
    private LiquidBounceButton quitBtn;
    private SkinHeadDisplay skinDisplay;
    private LiquidBounceButton changeSkinBtn;
    
    private static final int DARK_BG = 0xFF1a1a1a;
    private static final int HEADER_COLOR = 0xFFFFFF;
    private static final int MENU_LEFT_X = 30;
    private static final int MENU_TOP_Y = 60;
    private static final int BUTTON_WIDTH = 180;
    private static final int BUTTON_HEIGHT = 35;
    private static final int BUTTON_SPACING = 12;
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        
        int menuX = MENU_LEFT_X;
        int menuY = MENU_TOP_Y;
        
        // Left-side vertical menu
        singleplayerBtn = new LiquidBounceButton(0, menuX, menuY, BUTTON_WIDTH, BUTTON_HEIGHT, "Singleplayer");
        multiplayerBtn = new LiquidBounceButton(1, menuX, menuY + BUTTON_HEIGHT + BUTTON_SPACING, BUTTON_WIDTH, BUTTON_HEIGHT, "Multiplayer");
        optionsBtn = new LiquidBounceButton(2, menuX, menuY + (BUTTON_HEIGHT + BUTTON_SPACING) * 2, BUTTON_WIDTH, BUTTON_HEIGHT, "Options");
        quitBtn = new LiquidBounceButton(3, menuX, menuY + (BUTTON_HEIGHT + BUTTON_SPACING) * 3, BUTTON_WIDTH, BUTTON_HEIGHT, "Quit");
        
        this.buttonList.add(singleplayerBtn);
        this.buttonList.add(multiplayerBtn);
        this.buttonList.add(optionsBtn);
        this.buttonList.add(quitBtn);
        
        // Top-right skin display and change button
        int skinX = this.width - 110;
        int skinY = 20;
        
        skinDisplay = new SkinHeadDisplay(skinX, skinY, 50, 50);
        changeSkinBtn = new LiquidBounceButton(4, skinX + 55, skinY, 50, 25, "Edit");
        
        this.buttonList.add(changeSkinBtn);
    }
    
    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            // Singleplayer
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        } else if (button.id == 1) {
            // Multiplayer
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        } else if (button.id == 2) {
            // Options
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        } else if (button.id == 3) {
            // Quit
            this.mc.shutdown();
        } else if (button.id == 4) {
            // Change Skin/Cape
            this.mc.displayGuiScreen(new LiquidBounceSkinCustomizer(this));
        }
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Draw dark background
        drawRect(0, 0, this.width, this.height, DARK_BG);
        
        // Draw top bar with brighter background
        drawRect(0, 0, this.width, 50, 0xFF0f0f0f);
        
        // Draw header text
        this.fontRendererObj.drawStringWithShadow("EagleCraft Client", 30, 20, HEADER_COLOR);
        
        // Draw skin display
        skinDisplay.draw(this.mc, mouseX, mouseY);
        
        // Draw buttons
        super.drawScreen(mouseX, mouseY, partialTicks);
        
        // Draw footer
        String footer = "Made with LiquidBounce UI";
        this.fontRendererObj.drawStringWithShadow(footer, this.width - this.fontRendererObj.getStringWidth(footer) - 10, this.height - 15, 0xFF666666);
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
