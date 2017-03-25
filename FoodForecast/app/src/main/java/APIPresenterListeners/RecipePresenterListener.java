package APIPresenterListeners;

import java.util.List;

import APIClasses.APIRecipe;

/**
 * Created by raulbr on 3/24/17.
 */

public interface RecipePresenterListener {
    void recipeListener(List<APIRecipe.APIRecipeModel> recipes);
    void addRecipeListener();
}
