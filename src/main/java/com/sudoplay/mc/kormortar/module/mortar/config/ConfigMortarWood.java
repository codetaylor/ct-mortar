package com.sudoplay.mc.kormortar.module.mortar.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sk3lls on 11/23/2016.
 */
public class ConfigMortarWood extends
    KorConfigObject {

  @SerializedName("mortars")
  private Map<String, ConfigMortarEntry> entryMap;

  public ConfigMortarWood() {
    this.entryMap = new LinkedHashMap<>();

    this.entryMap.put("wood", new ConfigMortarEntry(20));
  }

  public ConfigMortarEntry getConfigMortarEntry(String name) {
    return this.entryMap.get(name);
  }
}
