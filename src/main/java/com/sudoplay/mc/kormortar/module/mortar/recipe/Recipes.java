package com.sudoplay.mc.kormortar.module.mortar.recipe;

import com.sudoplay.mc.kor.core.recipe.RecipeFile;
import com.sudoplay.mc.kor.core.recipe.shaped.RecipeShaped;
import com.sudoplay.mc.kor.core.recipe.shapeless.RecipeShapeless;
import com.sudoplay.mc.kormortar.KorMortar;

/**
 * Created by codetaylor on 11/22/2016.
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

    this.recipeShapedMap.put("mortar_stone", new RecipeShaped(
        KorMortar.MOD_ID + ":mortar_stone",
        new String[]{
            "null, null, ore:stickWood",
            "ore:stone, minecraft:flint, ore:stone",
            "null, ore:stone, null"
        }
    ));

    this.recipeShapedMap.put("mortar_iron", new RecipeShaped(
        KorMortar.MOD_ID + ":mortar_iron",
        new String[]{
            "null, null, ore:stickWood",
            "ore:ingotIron, minecraft:flint, ore:ingotIron",
            "null, ore:ingotIron, null"
        }
    ));

    this.recipeShapedMap.put("mortar_diamond", new RecipeShaped(
        KorMortar.MOD_ID + ":mortar_diamond",
        new String[]{
            "null, null, ore:stickWood",
            "ore:gemDiamond, minecraft:flint, ore:gemDiamond",
            "null, ore:gemDiamond, null"
        }
    ));

    this.recipeShapelessMap.put("sand from gravel in mortar_wood", new RecipeShapeless(
        "minecraft:sand",
        KorMortar.MOD_ID + ":mortar_wood:*, ore:gravel"
    ));

    this.recipeShapelessMap.put("sand from gravel in mortar_stone", new RecipeShapeless(
        "minecraft:sand",
        KorMortar.MOD_ID + ":mortar_stone:*, ore:gravel"
    ));

    this.recipeShapelessMap.put("sand from gravel in mortar_iron", new RecipeShapeless(
        "minecraft:sand",
        KorMortar.MOD_ID + ":mortar_iron:*, ore:gravel"
    ));

    this.recipeShapelessMap.put("sand from gravel in mortar_diamond", new RecipeShapeless(
        "minecraft:sand",
        KorMortar.MOD_ID + ":mortar_diamond:*, ore:gravel"
    ));
  }
}
