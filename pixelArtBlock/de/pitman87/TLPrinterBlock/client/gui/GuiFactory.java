package de.pitman87.TLPrinterBlock.client.gui;

import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionCategoryElement;
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionGuiHandler;
import cpw.mods.fml.client.config.GuiConfig;
import de.pitman87.TLPrinterBlock.common.ConfigHandler;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class GuiFactory
  implements IModGuiFactory
{
  public void initialize(Minecraft minecraftInstance) {}
  
  public Class<? extends GuiScreen> mainConfigGuiClass()
  {
    return GuiModConfig.class;
  }
  
  public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories()
  {
    return null;
  }
  
  public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element)
  {
    return null;
  }
  
  public static class GuiModConfig
    extends GuiConfig
  {
    public GuiModConfig(GuiScreen guiScreen)
    {
      super(new ConfigElement(ConfigHandler.configuration.getCategory("general")).getChildElements(), "PrinterBlock", false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString()));
    }
  }
}
