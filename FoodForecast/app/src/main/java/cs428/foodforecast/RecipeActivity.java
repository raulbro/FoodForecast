package cs428.foodforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import APIClasses.APIRecipe;
import APIPresenterListeners.RecipePresenterListener;

public class RecipeActivity extends AppCompatActivity implements RecipePresenterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    @Override
    public void recipeListener(List<APIRecipe.APIRecipeModel> recipes) {

    }

    @Override
    public void addRecipeListener() {

    }
}
