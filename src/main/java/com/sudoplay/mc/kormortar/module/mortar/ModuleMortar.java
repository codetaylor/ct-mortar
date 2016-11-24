package com.sudoplay.mc.kormortar.module.mortar;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.OnLoadConfigurationsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterCreativeTabsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterItemsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterRecipesEvent;
import com.sudoplay.mc.kormortar.KorMortarCreativeTab;
import com.sudoplay.mc.kormortar.module.mortar.item.ItemMortarDiamond;
import com.sudoplay.mc.kormortar.module.mortar.item.ItemMortarIron;
import com.sudoplay.mc.kormortar.module.mortar.item.ItemMortarStone;
import com.sudoplay.mc.kormortar.module.mortar.item.ItemMortarWood;
import com.sudoplay.mc.kormortar.module.mortar.recipe.RecipeRegistrationDelegate;

import java.io.File;

/**
 * Created by codetaylor on 11/22/2016.
 */
public class ModuleMortar implements
    IKorModule {

  public static final String MODULE_ID = "mortar";

  public static class Config {
    public static final String FILENAME = MODULE_ID + "/" + MODULE_ID + ".cfg";

    public static final String CATEGORY_ITEM_MORTAR = "1 - Mortar";
    public static final String CATEGORY_ITEM_MORTAR_DURABILITY = "2 - Mortar Durability";
  }

  @Override
  public String getKorModuleId() {
    return MODULE_ID;
  }

  @Subscribe
  public void onLoadConfigurationsEvent(OnLoadConfigurationsEvent event) {
    event.getConfigurationService()

        .loadConfiguration(
            new File(Config.FILENAME),
            new ModuleMortarConfigAdapter()
        );
  }

  @Subscribe
  public void onRegisterCreativeTabsEvent(OnRegisterCreativeTabsEvent event) {
    event.getRegistryService().register(

        KorMortarCreativeTab.class
    );
  }

  @Subscribe
  public void onRegisterItemsEvent(OnRegisterItemsEvent event) {
    event.getRegistryService().register(

        ItemMortarWood.class,
        ItemMortarStone.class,
        ItemMortarIron.class,
        ItemMortarDiamond.class
    );
  }

  @Subscribe
  public void onRegisterRecipesEvent(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        RecipeRegistrationDelegate.class
    );
  }
}
