package com.sudoplay.mc.kormortar.module.mortar.recipe;

import com.sudoplay.mc.kor.core.recipe.RecipeFile;
import com.sudoplay.mc.kor.core.recipe.shaped.RecipeShaped;
import com.sudoplay.mc.kor.core.recipe.shapeless.RecipeShapeless;
import com.sudoplay.mc.kormortar.KorMortar;

/**
 * Created by sk3lls on 11/22/2016.
 */
public class Recipes extends
    RecipeFile {

  public Recipes() {

    this.recipeShapedMap.put("mortar_wood", new RecipeShaped(
        KorMortar.MOD_ID + ":mortar_wood",
        new String[]{
            "null, null, ore:stickWood",
            "ore:plankWood, minecraft:flint, ore:plankWood",
            "null, ore:plankWood, null"
        }
    ));

    this.recipeShapelessMap.put("sand", new RecipeShapeless(
        "minecraft:sand",
        KorMortar.MOD_ID + ":mortar_wood:*, minecraft:gravel"
    ));

  }
}
