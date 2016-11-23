package com.sudoplay.mc.kormortar.shared;

import com.sudoplay.mc.kor.spi.item.ISubType;

/**
 * Created by sk3lls on 11/22/2016.
 */
public enum MortarType implements
    ISubType {

  Wood(0, "wood");

  private final int meta;
  private final String name;

  MortarType(int meta, String name) {

    this.meta = meta;
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getMeta() {
    return this.meta;
  }
}
