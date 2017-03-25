package APIClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by raulbr on 3/24/17.
 */

public class APIRecipe {
    private List<APIRecipeModel> recipes;

    public List<APIRecipeModel> getRecipes() {
        return recipes;
    }

    public class APIRecipeModel {
        @SerializedName("recipeName")
        private String name;

        @SerializedName("recipeDesc")
        private String description;

        @SerializedName("recipeIngredients")
        private String ingredients;


        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getIngredients() {
            return ingredients;
        }
    }
}
