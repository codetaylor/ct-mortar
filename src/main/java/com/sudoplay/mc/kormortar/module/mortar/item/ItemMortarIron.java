package com.sudoplay.mc.kormortar.module.mortar.item;

import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.ForgeEventListener;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kormortar.KorMortar;
import com.sudoplay.mc.kormortar.KorMortarCreativeTab;
import com.sudoplay.mc.kormortar.module.mortar.ModuleMortar;
import com.sudoplay.mc.kormortar.module.mortar.config.ConfigMortar;

import static com.sudoplay.mc.kormortar.module.mortar.ModuleMortar.Config;

/**
 * Created by codetaylor on 11/22/2016.
 */

@KorRegistrationTextConfigDependency(dependsOn = {
    @KorTextConfigDependency(filename = Config.FILENAME, category = Config.CATEGORY_ITEM_MORTAR, key = "iron")
})

@KorGenerateModelItemSingleTexture(
    name = "mortar_iron",
    modId = KorMortar.MOD_ID
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item.mortar_iron.name", value = "Mortar (Iron)")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 3, row = 1, target = "items/mortar_iron", source = "KorMortar.png")
})

@ForgeEventListener
public class ItemMortarIron extends
    AbstractItemMortar {

  @KorInject
  public ItemMortarIron(
      Kor kor,
      @KorJsonConfig(path = ModuleMortar.MODULE_ID, file = "mortar_properties.json") ConfigMortar config
  ) {
    super(
        KorMortar.MOD_ID,
        "mortar_iron"
    );
    setCreativeTab(kor.get(KorMortarCreativeTab.class));
    setMaxDamage(config.getConfigMortarEntry("iron").getDurability());
    setMaxStackSize(1);
  }
}
