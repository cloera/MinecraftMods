package de.pitman87.TLPrinterBlock.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import mods.UpdateChecker.Notifier;
import mods.UpdateChecker.UpdateChecker;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;

public class ClientTickHandler
  implements Notifier
{
  private boolean checkUpdate = true;
  
  @SubscribeEvent
  public void tickStart(TickEvent.ClientTickEvent event)
  {
    if ((this.checkUpdate) && (Minecraft.func_71410_x().field_71439_g != null))
    {
      UpdateChecker.checkVersion("PrinterBlock", "1.7.10", this);
      this.checkUpdate = false;
    }
  }
  
  public void notifyOnUpdate()
  {
    MinecraftServer.func_71276_C().func_71203_ab().func_148539_a(new ChatComponentText("���b New update available for PrinterBlock!"));
  }
}
