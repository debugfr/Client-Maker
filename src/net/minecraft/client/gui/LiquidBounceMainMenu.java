package net.minecraft.client.gui;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class LiquidBounceMainMenu extends GuiScreen {
    private GuiButtonCustom singleplayerBtn;
    private GuiButtonCustom multiplayerBtn;
    private GuiButtonCustom optionsBtn;
    private GuiButtonCustom quitBtn;
    private GuiButtonCustom skinEditBtn;
    
    private static final int BG_COLOR = 0xFF1a1a1a;
    private static final int MENU_LEFT_X = 30;
    private static final int MENU_TOP_Y = 50;
    private static final int BUTTON_WIDTH = 160;
    private static final int BUTTON_HEIGHT = 35;
    private static final int BUTTON_SPACING = 12;
    
    private int skinHeadX;
    private int skinHeadY;
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        
        // Left-side vertical menu
        int menuLeftX = MENU_LEFT_X;
        int menuTopY = MENU_TOP_Y;
        
        singleplayerBtn = new GuiButtonCustom(0, menuLeftX, menuTopY, BUTTON_WIDTH, BUTTON_HEIGHT, "Singleplayer");
        multiplayerBtn = new GuiButtonCustom(1, menuLeftX, menuTopY + BUTTON_HEIGHT + BUTTON_SPACING, BUTTON_WIDTH, BUTTON_HEIGHT, "Multiplayer");
        optionsBtn = new GuiButtonCustom(2, menuLeftX, menuTopY + (BUTTON_HEIGHT + BUTTON_SPACING) * 2, BUTTON_WIDTH, BUTTON_HEIGHT, "Options");
        quitBtn = new GuiButtonCustom(3, menuLeftX, menuTopY + (BUTTON_HEIGHT + BUTTON_SPACING) * 3, BUTTON_WIDTH, BUTTON_HEIGHT, "Quit");
        
        // Top-right skin edit button
        skinEditBtn = new GuiButtonCustom(4, this.width - 120, 15, 100, 35, "Edit Skin");
        
        this.buttonList.add(singleplayerBtn);
        this.buttonList.add(multiplayerBtn);
        this.buttonList.add(optionsBtn);
        this.buttonList.add(quitBtn);
        this.buttonList.add(skinEditBtn);
        
        // Skin head display position
        skinHeadX = this.width - 150;
        skinHeadY = 15;
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
            // Edit Skin
            this.mc.displayGuiScreen(new LiquidBounceSkinCustomizer(this));
        }
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Draw dark background
        drawRect(0, 0, this.width, this.height, BG_COLOR);
        
        // Draw header
        this.fontRendererObj.drawStringWithShadow("Main Menu", MENU_LEFT_X, 20, 0xFFFFFF);
        
        // Draw username/player info on top right
        String playerName = this.mc.getSession().getUsername();
        this.fontRendererObj.drawStringWithShadow(playerName, this.width - 160, 55, 0x00BFFF);
        
        // Draw player skin head
        drawSkinHead(skinHeadX, skinHeadY);
        
        // Draw footer
        this.fontRendererObj.drawStringWithShadow("LiquidBounce Client", MENU_LEFT_X, this.height - 20, 0x00BFFF);
        
        // Draw all buttons
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    private void drawSkinHead(int x, int y) {
        // Draw skin head frame
        drawRect(x - 2, y - 2, x + 42, y + 42, 0xFF00BFFF); // Cyan border
        drawRect(x, y, x + 40, y + 40, 0xFF2a2a2a); // Dark background
        
        // Placeholder for player head texture
        drawRect(x + 5, y + 5, x + 35, y + 35, 0xFF555555);
        
        // Draw "Head" text as placeholder
        GL11.glPushMatrix();
        GL11.glScalef(0.8f, 0.8f, 0.8f);
        this.fontRendererObj.drawString("HEAD", (int)((x + 12) / 0.8f), (int)((y + 15) / 0.8f), 0xFF888888);
        GL11.glPopMatrix();
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
