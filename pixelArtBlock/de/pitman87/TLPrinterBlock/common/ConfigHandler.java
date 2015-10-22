package de.pitman87.TLPrinterBlock.common;

import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{
  public static Configuration configuration;
  public static boolean checkForUpdates = false;
  
  public static void init(File configFile)
  {
    if (configuration == null)
    {
      configuration = new Configuration(configFile);
      loadConfiguration();
    }
  }
  
  private static void loadConfiguration()
  {
    checkForUpdates = configuration.getBoolean("checkForUpdates", "general", true, "set to false, to turn off updatechecker");
    if (configuration.hasChanged()) {
      configuration.save();
    }
  }
  
  @SubscribeEvent
  public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
  {
    if (event.modID.equalsIgnoreCase("PrinterBlock")) {
      loadConfiguration();
    }
  }
}
