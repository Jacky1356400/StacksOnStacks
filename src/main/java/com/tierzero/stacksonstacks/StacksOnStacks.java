package com.tierzero.stacksonstacks;

import com.tierzero.stacksonstacks.client.WireframeRenderHandler;
import com.tierzero.stacksonstacks.containers.BlockPileContainer;
import com.tierzero.stacksonstacks.containers.TilePileContainer;
import com.tierzero.stacksonstacks.core.CommonProxy;
import com.tierzero.stacksonstacks.core.ConfigHandler;
import com.tierzero.stacksonstacks.core.LogHandler;
import com.tierzero.stacksonstacks.lib.LibCore;
import com.tierzero.stacksonstacks.pile.PlacementHandler;
import com.tierzero.stacksonstacks.registration.RegistrationHandler;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LibCore.MOD_ID, name = LibCore.MOD_NAME, version = LibCore.VERSION, acceptedMinecraftVersions = LibCore.REQUIRED_VERSION)
public class StacksOnStacks {

	@Instance
	public static StacksOnStacks INSTANCE;
	
	@SidedProxy(clientSide = LibCore.PROXY_CLIENT, serverSide = LibCore.PROXY_COMMON)
	public static CommonProxy proxy;

	public static final Block CONTAINER = new BlockPileContainer().setRegistryName("sos.container");

	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event) {

		LogHandler.initLogger(event.getModLog());
		ConfigHandler.initConfig(event.getSuggestedConfigurationFile());
		
		proxy.preInit(event);

		GameRegistry.register(CONTAINER);
		GameRegistry.registerTileEntity(TilePileContainer.class, "sos.tile.container");

		MinecraftForge.EVENT_BUS.register(new PlacementHandler());
		MinecraftForge.EVENT_BUS.register(new WireframeRenderHandler());

	}
	
	@Mod.EventHandler
	public static void init(FMLInitializationEvent event) {

	}
	
	@Mod.EventHandler
	public static void postInit(FMLInitializationEvent event) {
		RegistrationHandler.loadRegistries();
	}
	
}
