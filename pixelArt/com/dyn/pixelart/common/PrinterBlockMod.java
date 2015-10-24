package com.dyn.pixelart.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import com.dyn.pixelart.common.block.BlockPrinter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid = "PrinterBlock", name = "PrinterBlock", version = "1.7.10", guiFactory = "com.dyn.pixelart.client.gui.GuiFactory")
public class PrinterBlockMod {
	public static final String VERSION = "1.7.10";
	public static final String MODID = "PrinterBlock";
	@SidedProxy(clientSide = "com.dyn.pixelart.client.ClientProxy", serverSide = "com.dyn.pixelart.common.CommonProxy")
	public static CommonProxy proxy;
	public static FMLEventChannel channel;
	public static Block printerBlock;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();

		ConfigHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigHandler());

		printerBlock = new BlockPrinter().setHardness(0.2F).setStepSound(Block.soundTypePiston)
				.setBlockName("TLPrinterBlock");
		GameRegistry.registerBlock(printerBlock, "TLPrinterBlock");
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent evt) {
		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel("PrinterBlock");
		channel.register(new PacketHandler());

		proxy.load();

		//we dont really want them crafting it
		/*GameRegistry.addRecipe(new ItemStack(printerBlock),
				new Object[] { "ABC", "#X#", "###", Character.valueOf('#'), Items.iron_ingot, Character.valueOf('X'),
						new ItemStack(Blocks.wool, 1, 0), Character.valueOf('A'), new ItemStack(Items.dye, 0, 1),
						Character.valueOf('B'), new ItemStack(Items.dye, 0, 2), Character.valueOf('C'),
						new ItemStack(Items.dye, 0, 4) });*/
	}

	@Mod.EventHandler
	public void modsLoaded(FMLPostInitializationEvent evt) {
	}

	@Mod.EventHandler
	public void serverStarted(FMLServerStartedEvent event) {
	}
}
