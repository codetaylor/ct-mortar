package com.sudoplay.mc.kormortar.module.mortar.item;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.ForgeEventListener;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kormortar.KorMortar;
import com.sudoplay.mc.kormortar.KorMortarCreativeTab;

import static com.sudoplay.mc.kormortar.module.mortar.ModuleMortar.Config;

/**
 * Created by codetaylor on 11/22/2016.
 */

@KorRegistrationTextConfigDependency(dependsOn = {
    @KorTextConfigDependency(filename = Config.FILENAME, category = Config.CATEGORY_ITEM_MORTAR, key = "diamond")
})

@KorGenerateModelItemSingleTexture(
    name = "mortar_diamond",
    modId = KorMortar.MOD_ID
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item.mortar_diamond.name", value = "Mortar (Diamond)")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 4, row = 1, target = "items/mortar_diamond", source = "KorMortar.png")
})

@ForgeEventListener
public class ItemMortarDiamond extends
    AbstractItemMortar {

  @KorInject
  public ItemMortarDiamond(
      Kor kor,
      @KorTextConfig(file = Config.FILENAME) TextConfigData textConfigData
  ) {
    super(
        KorMortar.MOD_ID,
        "mortar_diamond"
    );
    setCreativeTab(kor.get(KorMortarCreativeTab.class));
    setMaxDamage(textConfigData.getCategory(Config.CATEGORY_ITEM_MORTAR_DURABILITY).getInteger("diamond"));
    setMaxStackSize(1);
  }
}
