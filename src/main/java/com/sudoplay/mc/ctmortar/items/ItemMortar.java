package com.sudoplay.mc.ctmortar.items;

import com.sudoplay.mc.ctmortar.Config;
import com.sudoplay.mc.ctmortar.Mod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ItemMortar extends
    Item {

  public ItemMortar(
      Type type
  ) {

    MinecraftForge.EVENT_BUS.register(this);

    String name = "mortar_" + type.getName();
    this.setRegistryName(name);
    this.setUnlocalizedName(Mod.MOD_ID + "." + name);
    this.setMaxDamage(Config.getDurability(type));
    this.setMaxStackSize(1);
  }

  @SideOnly(Side.CLIENT)
  public void initModel() {

    ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
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
      slotIsNotEmpty = !itemStack.isEmpty();

      if (slotIsNotEmpty
          && itemStack.getItem() == this
          && itemStack.getItemDamage() <= getMaxDamage()) {

        if (getMaxDamage() == 0) { // the item is indestructible
          itemStack.setCount(itemStack.getCount() + 1);
          continue;
        }

        int itemDamage = itemStack.getItemDamage() + 1;

        if (itemDamage >= getMaxDamage()) { // the item's durability has expired
          // item, get rekt
          event.player.world.playSound(
              event.player,
              event.player.posX,
              event.player.posY,
              event.player.posZ,
              SoundEvents.ENTITY_ITEM_BREAK,
              SoundCategory.PLAYERS,
              1.0f,
              1.0f
          );

        } else {
          // ensure the item stays in the crafting table (and utterly ruin it a little bit)
          itemStack.setCount(itemStack.getCount() + 1);
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

  @Override
  public boolean isEnchantable(ItemStack stack) {

    return false;
  }
}
