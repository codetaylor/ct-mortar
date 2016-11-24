package com.sudoplay.mc.kormortar.module.mortar.item;

import com.sudoplay.mc.kor.spi.item.KorBasicItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import javax.annotation.Nonnull;

/**
 * Created by codetaylor on 11/23/2016.
 */
/* package */ abstract class AbstractItemMortar extends
    KorBasicItem {

  /* package */ AbstractItemMortar(String modId, String name) {
    super(modId, name);
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
          && itemStack.getItemDamage() <= getMaxDamage()) {

        if (getMaxDamage() == 0) {
          itemStack.stackSize += 1;
          continue;
        }

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

  @Nonnull
  @Override
  public Item setMaxDamage(int maxDamageIn) {
    return super.setMaxDamage(Math.max(0, maxDamageIn));
  }
}
