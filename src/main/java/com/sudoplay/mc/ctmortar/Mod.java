package com.sudoplay.mc.ctmortar;

import com.sudoplay.mc.ctmortar.proxy.ProxyCommon;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Logger;

@net.minecraftforge.fml.common.Mod(
    modid = Mod.MOD_ID,
    version = Mod.VERSION,
    name = Mod.NAME
    //@@DEPENDENCIES@@
)
public class Mod {

  public static final String MOD_ID = "ctmortar";
  public static final String VERSION = "@@VERSION@@";
  public static final String NAME = "CT Mortar";

  @SuppressWarnings("unused")
  @net.minecraftforge.fml.common.Mod.Instance
  public static Mod INSTANCE;

  @SidedProxy(clientSide = "com.sudoplay.mc.ctmortar.proxy.ProxyClient", serverSide = "com.sudoplay.mc.ctmortar.proxy.ProxyServer")
  public static ProxyCommon PROXY;

  public static Logger LOG;

  @net.minecraftforge.fml.common.Mod.EventHandler
  protected void onPreInitialization(FMLPreInitializationEvent event) {

    LOG = event.getModLog();
    PROXY.onPreInitialization(event);
  }

  @net.minecraftforge.fml.common.Mod.EventHandler
  protected void onInitialization(FMLInitializationEvent event) {

    PROXY.onInitialization(event);
  }

  @net.minecraftforge.fml.common.Mod.EventHandler
  protected void onPostInitialization(FMLPostInitializationEvent event) {

    PROXY.onPostInitialization(event);
  }
}
