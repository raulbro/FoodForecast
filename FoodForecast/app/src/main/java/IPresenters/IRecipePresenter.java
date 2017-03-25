package IPresenters;

import java.util.List;

import APIClasses.APIRecipe;
import Models.Recipe;
import Models.Search;

/**
 * Created by raulbr on 3/6/17.
 */

public interface IRecipePresenter {
    public List<APIRecipe.APIRecipeModel> getRecipes();
    public List<APIRecipe.APIRecipeModel> getRecipes(Search search);
    public void addRecipe(APIRecipe.APIRecipeModel recipe);
}
