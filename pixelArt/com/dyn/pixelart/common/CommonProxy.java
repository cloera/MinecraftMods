package com.dyn.pixelart.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;
import com.dyn.pixelart.UpdateChecker.UpdateChecker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy {
	public void load() {
		if (ConfigHandler.checkForUpdates) {
			FMLCommonHandler.instance().bus().register(new UpdateChecker("PrinterBlock", "1.7.10"));
		}
	}

	public void preInit() {
	}

	public World getClientWorld() {
		return null;
	}

	public void openGUI(EntityPlayer entityplayer, World world, int i, int j, int k, int blockMetadata, int l) {
	}
}
