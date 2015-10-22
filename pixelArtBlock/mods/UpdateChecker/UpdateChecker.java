package mods.UpdateChecker;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import net.minecraft.server.MinecraftServer;

public class UpdateChecker
  implements Notifier
{
  private boolean checkUpdate = true;
  String mod;
  String version;
  
  public UpdateChecker(String mod, String version)
  {
    this.mod = mod;
    this.version = version;
  }
  
  public static void checkVersion(String mod, final String version, final Notifier notifier)
  {
    Thread check = new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          URL u = new URL("https://dl.dropbox.com/u/27946323/versions.txt");
          InputStream in = u.openStream();
          Properties p = new Properties();
          p.load(in);
          String newVersion = p.getProperty(this.val$mod);
          if (version.compareTo(newVersion) != 0) {
            notifier.notifyOnUpdate();
          }
        }
        catch (Exception e) {}
      }
    });
    check.start();
  }
  
  @SubscribeEvent
  public void tickStart(TickEvent.ServerTickEvent event)
  {
    if (this.checkUpdate)
    {
      checkVersion(this.mod, this.version, this);
      this.checkUpdate = false;
    }
  }
  
  public void notifyOnUpdate()
  {
    MinecraftServer.func_71276_C().func_71244_g("New update available for " + this.mod + "!");
  }
}
