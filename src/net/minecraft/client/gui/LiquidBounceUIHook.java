package net.minecraft.client.gui;

/**
 * Hook class to replace default main menu with LiquidBounce UI
 * This should be called when the client finishes loading
 */
public class LiquidBounceUIHook {
    
    /**
     * Hook this into your client initialization to use LiquidBounce UI
     * @param mc Minecraft instance
     */
    public static void initLiquidBounceUI(net.minecraft.client.Minecraft mc) {
        if (mc.currentScreen == null) {
            mc.displayGuiScreen(new LiquidBounceMainMenu());
        }
    }
    
    /**
     * Replace any GuiMainMenu instantiation with this
     * @return LiquidBounce themed main menu
     */
    public static GuiScreen createLiquidBounceMainMenu() {
        return new LiquidBounceMainMenu();
    }
}
