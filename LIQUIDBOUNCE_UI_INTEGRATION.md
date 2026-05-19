# LiquidBounce UI Integration Guide

## Files Added
The following files have been added to implement the LiquidBounce UI:

1. **LiquidBounceMainMenu.java** - Main menu screen with left-aligned buttons and top-right skin display
2. **GuiButtonCustom.java** - Custom button with LiquidBounce styling (dark gray with cyan accents)
3. **LiquidBounceSkinCustomizer.java** - Skin and cape customization screen
4. **LiquidBounceUIHook.java** - Integration hook for easy initialization

## Integration Steps

To integrate this UI into your client, you need to:

### Option 1: Replace GuiMainMenu instantiation
Find where your client creates `GuiMainMenu()` and replace it with:
```java
LiquidBounceUIHook.createLiquidBounceMainMenu()
```

### Option 2: Use the hook in initialization
In your client's startup/initialization code, add:
```java
LiquidBounceUIHook.initLiquidBounceUI(mc);
```

### Option 3: Direct instantiation
Simply instantiate the main menu directly:
```java
mc.displayGuiScreen(new LiquidBounceMainMenu());
```

## UI Layout

### Main Menu (LiquidBounceMainMenu.java)
- **Left Side**: Vertical menu with buttons
  - Singleplayer (top)
  - Multiplayer
  - Options
  - Quit (bottom)
  
- **Top Right**: Player customization area
  - Player head display (placeholder)
  - "Edit Skin" button for accessing customization
  
- **Player Info**: Username displayed with cyan color

### Color Scheme
- **Background**: `#1a1a1a` (dark gray/black)
- **Buttons**: `#2a2a2a` normal, `#3d3d3d` on hover
- **Text**: White, cyan (`#00BFFF`) on hover
- **Accents**: Cyan for UI highlights

## Customization Screen (LiquidBounceSkinCustomizer.java)
Features:
- Change Skin button
- Change Cape button
- Back button
- Same LiquidBounce styling

## Notes
- All buttons follow LiquidBounce's dark theme
- Smooth hover effects with color transitions
- Cyan accents match LiquidBounce's signature color
- Ready for further customization and feature additions
