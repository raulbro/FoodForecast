package Models;

import java.util.List;

import APIClasses.APIRecipe;

/**
 * Created by raulbr on 3/6/17.
 */

public class Singleton {
    public static Singleton _SINGLETON = new Singleton();
    private User currentUser;
    private List<APIRecipe.APIRecipeModel> recipesList;

    private ViewEnum view = ViewEnum.SEARCH_RECIPE;

    public ViewEnum getView() {
        return view;
    }

    public void setView(ViewEnum view) {
        this.view = view;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<APIRecipe.APIRecipeModel> getRecipesList() {
        return recipesList;
    }

    public void setRecipesList(List<APIRecipe.APIRecipeModel> recipesList) {
        this.recipesList = recipesList;
    }
}
