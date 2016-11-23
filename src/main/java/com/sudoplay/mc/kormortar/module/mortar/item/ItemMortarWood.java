package com.sudoplay.mc.kormortar.module.mortar.item;

import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.item.KorBasicItem;
import com.sudoplay.mc.kor.spi.registry.ForgeEventListener;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kormortar.KorMortar;
import com.sudoplay.mc.kormortar.KorMortarCreativeTab;
import com.sudoplay.mc.kormortar.module.mortar.ModuleMortar;
import com.sudoplay.mc.kormortar.module.mortar.config.ConfigMortarWood;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import static com.sudoplay.mc.kormortar.module.mortar.ModuleMortar.Config;

/**
 * Created by sk3lls on 11/22/2016.
 */

@KorRegistrationTextConfigDependency(dependsOn = {
    @KorTextConfigDependency(filename = Config.FILENAME, category = Config.CATEGORY_ITEM_MORTAR, key = "wood")
})

@KorGenerateModelItemSingleTexture(
    name = "mortar_wood",
    modId = KorMortar.MOD_ID
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item.mortar_wood.name", value = "Mortar (Wood)")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 1, row = 1, target = "items/mortar_wood", source = "KorMortar.png")
})

@ForgeEventListener
public class ItemMortarWood extends
    KorBasicItem {

  @KorInject
  public ItemMortarWood(
      Kor kor,
      @KorJsonConfig(path = ModuleMortar.MODULE_ID, file = "mortar_properties.json") ConfigMortarWood config
  ) {
    super(
        KorMortar.MOD_ID,
        "mortar_wood"
    );
    setCreativeTab(kor.get(KorMortarCreativeTab.class));
    setMaxDamage(config.getConfigMortarEntry("wood").getDurability());
    setMaxStackSize(1);
  }

  @SubscribeEvent
  public void onItemCraftedEvent(
      PlayerEvent.ItemCraftedEvent event
  ) {
    int sizeInventory;
    ItemStack itemStack;
    boolean slotIsNotEmpty;

    sizeInventory = event.craftMatrix.getSizeInventory();

    for (int i = 0; i < sizeInventory; i++) {
      itemStack = event.craftMatrix.getStackInSlot(i);
      slotIsNotEmpty = itemStack != null;

      if (slotIsNotEmpty
          && itemStack.getItem() == this
          && itemStack.getItemDamage() < getMaxDamage()) {

        int itemDamage = itemStack.getItemDamage() + 1;

        if (itemDamage == getMaxDamage()) {
          // item, get rekt
          event.player.worldObj.playSound(event.player, event.player.posX, event.player.posY, event.player.posZ, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1.0f, 1.0f);

        } else {
          itemStack.stackSize += 1;
          itemStack.setItemDamage(itemDamage);
        }
      }
    }
  }
}
