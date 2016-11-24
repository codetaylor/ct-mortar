package com.sudoplay.mc.kormortar.module.mortar.config;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.KorConfigUtil;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
import com.sudoplay.mc.kormortar.module.mortar.ModuleMortar;
import com.sudoplay.mc.kormortar.shared.MortarType;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by codetaylor on 11/22/2016.
 */
public class ModuleMortarConfigAdapter implements
    KorForgeConfigurationAdapter<TextConfigData> {

  @Override
  public void adapt(Configuration configuration, TextConfigData textConfigData) {
    String category;

    category = ModuleMortar.Config.CATEGORY_ITEM_MORTAR;

    configuration.addCustomCategoryComment(
        category,
        "Disabling a mortar type here will prevent the item from being loaded."
    );

    for (MortarType mortarType : MortarType.values()) {
      KorConfigUtil.adaptBoolean(category, mortarType.getName(), true, configuration, textConfigData);
    }

    category = ModuleMortar.Config.CATEGORY_ITEM_MORTAR_DURABILITY;

    configuration.addCustomCategoryComment(
        category,
        "Each mortar type has a durability, specifically how many times it can be used to craft\n" +
            "with before it is destroyed. Setting this value to 0 will make the item indestructible."
    );

    KorConfigUtil.adaptInteger(category, MortarType.Wood.getName(), 16, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, MortarType.Stone.getName(), 64, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, MortarType.Iron.getName(), 256, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, MortarType.Diamond.getName(), 1024, configuration, textConfigData);
  }
}
