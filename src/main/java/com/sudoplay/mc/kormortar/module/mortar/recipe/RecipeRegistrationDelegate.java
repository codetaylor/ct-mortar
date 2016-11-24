package com.sudoplay.mc.kormortar.module.mortar.recipe;

import com.sudoplay.mc.kor.spi.recipe.KorRecipeFileRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kormortar.module.mortar.ModuleMortar;

/**
 * Created by codetaylor on 11/17/2016.
 */
public class RecipeRegistrationDelegate extends
    KorRecipeFileRegistrationDelegate {

  @KorInject
  public RecipeRegistrationDelegate(
      @KorJsonConfig(path = ModuleMortar.MODULE_ID, file = "recipes.json") Recipes recipeFile
  ) {
    super(recipeFile);
  }
}
