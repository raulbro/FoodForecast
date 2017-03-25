package Presenters;

import android.content.Context;

import java.util.List;

import APIClasses.APIRecipe;
import IPresenters.IRecipePresenter;
import APIPresenterListeners.RecipePresenterListener;
import Models.Recipe;
import Models.Search;
import Models.Singleton;
import Server.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by raulbr on 3/6/17.
 */

public class RecipePresenter implements IRecipePresenter {
    private final Context context;
    private final RecipePresenterListener mListener;
    private final APIService apiService;

    public RecipePresenter(RecipePresenterListener listener, Context context) {
        this.mListener = listener;
        this.context = context;
        this.apiService = new APIService();
    }

    @Override
    public List<APIRecipe.APIRecipeModel> getRecipes() {
        apiService
                .getAPI()
                .getRecipes(Singleton._SINGLETON.getCurrentUser().get_userName())
                .enqueue(new Callback<APIRecipe>() {
                    @Override
                    public void onResponse(Call<APIRecipe> call, Response<APIRecipe> response) {
                        APIRecipe result = response.body();
                        if(result != null)
                            Singleton._SINGLETON.setRecipesList(result.getRecipes());
                            mListener.recipeListener(result.getRecipes());
                    }

                    @Override
                    public void onFailure(Call<APIRecipe> call, Throwable t) {
                        try {
                            throw  new InterruptedException("On FAILURE getRecipes()");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return Singleton._SINGLETON.getRecipesList();
    }

    @Override
    public List<APIRecipe.APIRecipeModel> getRecipes(Search search) {
        List<APIRecipe.APIRecipeModel> filteredRecipes = Singleton._SINGLETON.getRecipesList();
        //filter recipes
        return filteredRecipes;
    }

    @Override
    public void addRecipe(APIRecipe.APIRecipeModel recipe) {
        apiService
                .getAPI()
                .addRecipe(recipe.getName(), recipe.getIngredients(), recipe.getDescription())
                .enqueue(new Callback<APIRecipe>() {
                    @Override
                    public void onResponse(Call<APIRecipe> call, Response<APIRecipe> response) {
                        APIRecipe result = response.body();
                        if(result != null)
                            mListener.addRecipeListener();
                    }
                    @Override
                    public void onFailure(Call<APIRecipe> call, Throwable t) {
                        try {
                            throw  new InterruptedException("On FAILURE addRecipe()");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
