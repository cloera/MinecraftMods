package com.dyn.pixelart.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;
import com.dyn.pixelart.client.gui.GuiPrinter;
import com.dyn.pixelart.common.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {
	public void preInit() {
	}

	public void load() {
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
	}

	public void openGUI(EntityPlayer player, World world, int x, int y, int z, int meta, int dir) {
		FMLClientHandler.instance().displayGuiScreen(player, new GuiPrinter(world, x, y, z, meta, dir));
	}
}
