package Server;

import java.util.List;

import APIClasses.APILogin;
import APIClasses.APIRecipe;
import Models.Recipe;
import Models.Search;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by raulbr on 3/24/17.
 */

public interface APIInterface {
    @POST("register/{userName}/{password}")
    public Call<APILogin> register(@Path("userName")String userName, @Path("password") String password);

    @POST("login/{userName}/{password}")
    public Call<APILogin> login(@Path("userName")String userName, @Path("password") String password);

    @GET("getRecpes")
    public Call<APIRecipe> getRecipes(@Path("usernName")String userName);
    public Call<APIRecipe> getSearchRecipes(String userName, Search search);

    @POST("addRecipe/{recipeName}/{recipeDesc}/{recipeIngredients}")
    public Call<APIRecipe> addRecipe(String recipeName, String recipeDesc, String recipeIngredients);
}
