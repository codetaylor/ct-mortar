package com.sudoplay.mc.kormortar;

import com.sudoplay.mc.kor.core.generation.annotation.KorGenerateLangEntries;
import com.sudoplay.mc.kor.core.generation.annotation.KorLangEntry;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kormortar.module.mortar.item.ItemMortarWood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;

/**
 * Created by sk3lls on 11/22/2016.
 */
@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "itemGroup." + KorMortar.MOD_ID + "_tab", value = "CTKor Mortar")
})
public class KorMortarCreativeTab extends
    CreativeTabs {

  private Kor kor;

  @KorInject
  public KorMortarCreativeTab(
      Kor kor
  ) {
    super(CreativeTabs.getNextID(), KorMortar.MOD_ID + "_tab");
    this.kor = kor;
  }

  @Nonnull
  @Override
  public Item getTabIconItem() {
    return this.kor.get(ItemMortarWood.class);
  }
}
