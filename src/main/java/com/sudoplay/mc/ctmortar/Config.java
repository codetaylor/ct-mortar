package com.sudoplay.mc.ctmortar;

import com.sudoplay.mc.ctmortar.items.Type;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {

  public static final String FILENAME = Mod.MOD_ID + ".cfg";

  public static final String CATEGORY_ITEM_MORTAR_DURABILITY = "1 - Mortar Durability";

  public static int[] DURABILITY = new int[Type.values().length];

  public static int getDurability(Type type) {

    return DURABILITY[type.getMeta()];
  }

  public static void read(Configuration config) {

    try {
      config.load();
      Config._read(config);

    } catch (Exception e) {
      Mod.LOG.log(Level.ERROR, "Error loading config file", e);

    } finally {

      if (config.hasChanged()) {
        config.save();
      }
    }
  }

  private static void _read(Configuration config) {

    config.addCustomCategoryComment(
        CATEGORY_ITEM_MORTAR_DURABILITY,
        "Each mortar type has a durability, specifically how many times it can be used to craft\n" +
            "with before it is destroyed. Setting this value to 0 will make the item indestructible."
    );

    DURABILITY[Type.Wood.getMeta()] = config.getInt(
        Type.Wood.getName(),
        CATEGORY_ITEM_MORTAR_DURABILITY,
        16,
        0,
        Short.MAX_VALUE,
        ""
    );
    DURABILITY[Type.Stone.getMeta()] = config.getInt(
        Type.Stone.getName(),
        CATEGORY_ITEM_MORTAR_DURABILITY,
        64,
        0,
        Short.MAX_VALUE,
        ""
    );
    DURABILITY[Type.Iron.getMeta()] = config.getInt(
        Type.Iron.getName(),
        CATEGORY_ITEM_MORTAR_DURABILITY,
        256,
        0,
        Short.MAX_VALUE,
        ""
    );
    DURABILITY[Type.Diamond.getMeta()] = config.getInt(
        Type.Diamond.getName(),
        CATEGORY_ITEM_MORTAR_DURABILITY,
        1024,
        0,
        Short.MAX_VALUE,
        ""
    );
  }

}
