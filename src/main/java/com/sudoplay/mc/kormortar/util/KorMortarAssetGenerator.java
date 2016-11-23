package com.sudoplay.mc.kormortar.util;

import com.sudoplay.mc.kor.core.generation.AssetGenerator;
import com.sudoplay.mc.kormortar.module.mortar.ModuleMortar;

/**
 * Created by sk3lls on 11/22/2016.
 */
public class KorMortarAssetGenerator {

  public static void main(String... args) {

    AssetGenerator generator = new AssetGenerator(
        "subprojects/kor-mortar/assets",
        "subprojects/kor-mortar/src/main/resources/assets/ctkormortar"
    );

    generator.generate(
        new ModuleMortar()
    );
  }
}
