package com.sudoplay.mc.ctmortar.items;

import javax.annotation.Nonnull;

public enum Type {

  Wood(0, "wood"),
  Stone(1, "stone"),
  Iron(2, "iron"),
  Diamond(3, "diamond");

  private final int meta;
  private final String name;

  Type(
      int meta,
      String name
  ) {

    this.meta = meta;
    this.name = name;
  }

  @Nonnull
  public String getName() {

    return this.name;
  }

  public int getMeta() {

    return this.meta;
  }
}
