package net.minecraft.client.gui;

public class LiquidBounceSkinCustomizer extends GuiScreen {
    private GuiScreen parentScreen;
    private GuiButtonCustom changeSkinBtn;
    private GuiButtonCustom changeCapeBtn;
    private GuiButtonCustom backBtn;
    
    private static final int BG_COLOR = 0xFF1a1a1a;
    
    public LiquidBounceSkinCustomizer(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        
        int centerX = this.width / 2;
        int startY = this.height / 3;
        
        changeSkinBtn = new GuiButtonCustom(0, centerX - 85, startY, 170, 40, "Change Skin");
        changeCapeBtn = new GuiButtonCustom(1, centerX - 85, startY + 55, 170, 40, "Change Cape");
        backBtn = new GuiButtonCustom(2, centerX - 85, this.height - 60, 170, 40, "Back");
        
        this.buttonList.add(changeSkinBtn);
        this.buttonList.add(changeCapeBtn);
        this.buttonList.add(backBtn);
    }
    
    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            // Change Skin - placeholder
            this.mc.displayGuiScreen(this);
        } else if (button.id == 1) {
            // Change Cape - placeholder
            this.mc.displayGuiScreen(this);
        } else if (button.id == 2) {
            // Back to main menu
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Draw dark background
        drawRect(0, 0, this.width, this.height, BG_COLOR);
        
        // Draw title
        this.fontRendererObj.drawCenteredStringWithShadow("Customize Profile", this.width / 2, 30, 0xFFFFFF);
        
        // Draw subtitle
        this.fontRendererObj.drawCenteredStringWithShadow("Edit your skin and cape", this.width / 2, 50, 0x00BFFF);
        
        // Draw all buttons
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
