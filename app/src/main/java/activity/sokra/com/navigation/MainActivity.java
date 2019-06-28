package activity.sokra.com.navigation;

import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;

import activity.sokra.com.navigation.fragment.DoneFragement;
import activity.sokra.com.navigation.fragment.HomeFragement;
import activity.sokra.com.navigation.fragment.InboxFragement;
import activity.sokra.com.navigation.fragment.SnoozedFragement;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.DrawerLayoutNav);
        toolbar = findViewById(R.id.toolbar_main);
        navigationView = findViewById(R.id.nav);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_toogle_open,R.string.nav_toogle_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().findItem(R.id.checkbox);
        final CompoundButton checkbox =(CompoundButton) menuItem.getActionView();
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.btnHome:
                setToolbarTitle("Home");
                replaceFragment(R.id.container,new HomeFragement());
                return true;
            case R.id.btnInbox:
                setToolbarTitle("Inobx");
                replaceFragment(R.id.container,new InboxFragement());
                return true;
            case R.id.btnSnoozed:
                setToolbarTitle("Snooze");
                replaceFragment(R.id.container,new SnoozedFragement());
                return true;
            case R.id.btnDone:
                setToolbarTitle("Done");
                replaceFragment(R.id.container,new DoneFragement());
                return true;
        }

        return false;

    }




    private void replaceFragment(@IdRes int container, Fragment fragment){
        if (fragment !=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(container,fragment);
            fragmentTransaction.commit();
        }

    }

    private void setToolbarTitle(String s){
        getSupportActionBar().setTitle(s);
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
