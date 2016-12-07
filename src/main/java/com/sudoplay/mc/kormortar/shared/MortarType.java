package com.sudoplay.mc.kormortar.shared;

import com.sudoplay.mc.kor.spi.item.ISubType;

import javax.annotation.Nonnull;

/**
 * Created by codetaylor on 11/22/2016.
 */
public enum MortarType implements
    ISubType {

  Wood(0, "wood"),
  Stone(1, "stone"),
  Iron(2, "iron"),
  Diamond(3, "diamond");

  private final int meta;
  private final String name;

  MortarType(int meta, String name) {
    this.meta = meta;
    this.name = name;
  }

  @Nonnull
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getMeta() {
    return this.meta;
  }
}
