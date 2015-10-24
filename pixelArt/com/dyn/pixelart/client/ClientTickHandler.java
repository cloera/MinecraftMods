package com.dyn.pixelart.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import com.dyn.pixelart.UpdateChecker.Notifier;
import com.dyn.pixelart.UpdateChecker.UpdateChecker;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;

public class ClientTickHandler implements Notifier {
	private boolean checkUpdate = true;

	@SubscribeEvent
	public void tickStart(TickEvent.ClientTickEvent event) {
		if ((this.checkUpdate) && (Minecraft.getMinecraft().thePlayer != null)) {
			UpdateChecker.checkVersion("PrinterBlock", "1.7.10", this);
			this.checkUpdate = false;
		}
	}

	public void notifyOnUpdate() {
		MinecraftServer.getServer().getConfigurationManager()
				.sendChatMsg(new ChatComponentText("New update available for PrinterBlock!"));
	}
}
