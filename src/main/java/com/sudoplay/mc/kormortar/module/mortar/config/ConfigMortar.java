package com.sudoplay.mc.kormortar.module.mortar.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by codetaylor on 11/23/2016.
 */
public class ConfigMortar extends
    KorConfigObject {

  @SerializedName("mortars")
  private Map<String, ConfigMortarEntry> entryMap;

  public ConfigMortar() {
    this.entryMap = new LinkedHashMap<>();

    this.entryMap.put("wood", new ConfigMortarEntry(16));
    this.entryMap.put("stone", new ConfigMortarEntry(64));
    this.entryMap.put("iron", new ConfigMortarEntry(256));
    this.entryMap.put("diamond", new ConfigMortarEntry(1024));
  }

  public ConfigMortarEntry getConfigMortarEntry(String name) {
    return this.entryMap.get(name);
  }
}
