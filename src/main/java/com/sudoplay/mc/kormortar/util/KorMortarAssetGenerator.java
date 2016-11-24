package com.sudoplay.mc.kormortar.util;

import com.sudoplay.mc.kor.core.generation.AssetGenerator;
import com.sudoplay.mc.kor.spi.util.FileUtils;
import com.sudoplay.mc.kormortar.module.mortar.ModuleMortar;

import java.io.File;
import java.io.IOException;

/**
 * Created by codetaylor on 11/22/2016.
 */
public class KorMortarAssetGenerator {

  public static void main(String... args) {

    File assetRoot = new File("subprojects/kor-mortar/src/main/resources/assets/ctkormortar");

    try {
      FileUtils.delete(assetRoot, System.out::println);

    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    AssetGenerator generator = new AssetGenerator(
        "subprojects/kor-mortar/assets",
        "subprojects/kor-mortar/src/main/resources/assets/ctkormortar"
    );

    generator.generate(
        new ModuleMortar()
    );
  }
}
