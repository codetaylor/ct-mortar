package com.sudoplay.mc.kormortar;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kormortar.module.mortar.ModuleMortar;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by codetaylor on 11/22/2016.
 */
@Mod(
    modid = KorMortar.MOD_ID,
    version = KorMortar.VERSION,
    name = KorMortar.NAME
)
public class KorMortar extends
    Kor {

  public static final String MOD_ID = "ctkormortar";
  public static final String VERSION = "@@VERSION@@";
  public static final String NAME = "CTKor Mortar";
  public static final double JSON_CONFIGS_VERSION = 1.0;

  @SuppressWarnings("unused")
  @Mod.Instance
  public static KorMortar INSTANCE;

  @Override
  public String getModId() {
    return MOD_ID;
  }

  @Override
  public String getModVersion() {
    return VERSION;
  }

  @Override
  public String getModName() {
    return NAME;
  }

  @Override
  public double getJsonConfigsVersion() {
    return JSON_CONFIGS_VERSION;
  }

  @Override
  @Mod.EventHandler
  protected void onPreInitialization(FMLPreInitializationEvent event) {

    this.registerModules(
        new ModuleMortar()
    );

    super.onPreInitialization(event);
  }

  @Override
  @Mod.EventHandler
  protected void onInitialization(FMLInitializationEvent event) {
    super.onInitialization(event);
  }

  @Override
  @Mod.EventHandler
  protected void onPostInitialization(FMLPostInitializationEvent event) {
    super.onPostInitialization(event);
  }
}
