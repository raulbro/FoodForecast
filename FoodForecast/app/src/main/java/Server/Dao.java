package Server;

import java.util.List;

import APIClasses.APILogin;
import Models.Recipe;
import Models.Search;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raulbr on 2/26/17.
 */
public class Dao implements IDao {
    public static Dao _SINGLETON = new Dao();
    final boolean success = false;

    private APIInterface getInterfaceService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("BASE_URL")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final APIInterface interfaceService = retrofit.create(APIInterface.class);
        return interfaceService;
    }

    @Override
    public boolean register(String userName, String password) {
        return false;
    }

    @Override
    public boolean login(String userName, String password) {
//        APIInterface apiService = this.getInterfaceService();
//        Call<APILogin> mService = apiService.login(userName, password);
//        mService.enqueue(new Callback<APILogin>() {
//            @Override
//            public void onResponse(Call<APILogin> call, Response<APILogin> response) {
//                APILogin loginObject = response.body();
//                String returnedResponse = loginObject.isLogin;
//                if(returnedResponse.trim().equals("1")){
//                    success = true;
//                }
//            }
//            @Override
//            public void onFailure(Call<APILogin> call, Throwable t) {
//                call.cancel();
//            }
//        });
        return false;
    }

    @Override
    public List<Recipe> getRecipes(String userName) {
        return null;
    }

    @Override
    public List<Recipe> getSearchRecipes(String userName, Search search) {
        return null;
    }

    @Override
    public boolean addRecipe(String recipeName, String recipeDesc, String recipeIngredients) {
        return false;
    }
}
