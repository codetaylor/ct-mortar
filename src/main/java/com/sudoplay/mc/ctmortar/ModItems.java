package com.sudoplay.mc.ctmortar;

import com.sudoplay.mc.ctmortar.items.ItemMortar;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

  @GameRegistry.ObjectHolder(Mod.MOD_ID + ":mortar_wood")
  public static ItemMortar MORTAR_WOOD;

  @GameRegistry.ObjectHolder(Mod.MOD_ID + ":mortar_stone")
  public static ItemMortar MORTAR_STONE;

  @GameRegistry.ObjectHolder(Mod.MOD_ID + ":mortar_iron")
  public static ItemMortar MORTAR_IRON;

  @GameRegistry.ObjectHolder(Mod.MOD_ID + ":mortar_diamond")
  public static ItemMortar MORTAR_DIAMOND;

  @SideOnly(Side.CLIENT)
  public static void initItems() {

    MORTAR_WOOD.initModel();
    MORTAR_STONE.initModel();
    MORTAR_IRON.initModel();
    MORTAR_DIAMOND.initModel();
  }

}
