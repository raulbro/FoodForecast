package cs428.foodforecast;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import Models.Singleton;
import Models.ViewEnum;
import cs428.foodforecast.dummy.DummyContent;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,CalendarFragment.OnFragmentInteractionListener,
        ShopListFragment.OnListFragmentInteractionListener,RecipeDetailsFragment.OnFragmentInteractionListener, RecipeListFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        refreshViewState();
    }

    public void refreshViewState()
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        android.support.v4.app.Fragment searchFrag = fm.findFragmentById(R.id.search_fragment);
        android.support.v4.app.Fragment calendarFragment = fm.findFragmentById(R.id.calendar_fragment);
        Fragment shopCartFragment = fm.findFragmentById(R.id.nav_shopping_cart_fragment);
        Fragment recipeDetails = fm.findFragmentById(R.id.recipe_details_fragment);
        ft.hide(searchFrag);
        ft.hide(calendarFragment);
        ft.hide(shopCartFragment);
        ft.hide(recipeDetails);
        switch (Singleton._SINGLETON.getView()){
            case SEARCH_RECIPE:
                ft.show(searchFrag);
            break;

            case CALENDAR:
                ft.show(calendarFragment);
            break;

            case SHOP_CART:
                ft.show(shopCartFragment);
            break;

            case RECIPE:
                ft.show(recipeDetails);
            break;
        }

        ft.commit();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Singleton model = Singleton._SINGLETON;
        if (id == R.id.nav_search) {
            // Handle the camera action
            model.setView(ViewEnum.SEARCH_RECIPE);
        } else if (id == R.id.nav_calendar) {
            model.setView(ViewEnum.CALENDAR);
        } else if (id == R.id.nav_shopping_cart) {
            model.setView(ViewEnum.SHOP_CART);
        } else if (id == R.id.nav_prefs) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        refreshViewState();
        return true;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        refreshViewState();
    }

        @Override
        public void onFragmentInteraction(Uri uri) {

        }

}

