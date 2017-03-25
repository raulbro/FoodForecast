package Server;

import java.util.List;

import APIClasses.APILogin;
import Models.Recipe;
import Models.Search;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
/**
 * Created by raulbr on 3/24/17.
 */

public interface IDao {
    public boolean register(String userName, String password);
    public boolean login(String userName,String password);
    public List<Recipe> getRecipes(String userName);
    public List<Recipe> getSearchRecipes(String userName, Search search);
    public boolean addRecipe(String recipeName, String recipeDesc, String recipeIngredients);
}
