package activity.sokra.com.navigation;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import activity.sokra.com.navigation.fragment.DoneFragement;
import activity.sokra.com.navigation.fragment.HomeFragement;
import activity.sokra.com.navigation.fragment.InboxFragement;

public class BottomNavigationViewActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.btnHome:
                        replaceFragment(R.id.container,new HomeFragement());
                        return true;
                    case R.id.btnSubscript:
                        replaceFragment(R.id.container,new DoneFragement());
                        return true;
                    case R.id.btnMail:
                        replaceFragment(R.id.container,new InboxFragement());
                        return true;

                        default:return false;
                }
            }
        });

    }

    private void replaceFragment(@IdRes int container, Fragment fragment){
        if (fragment !=null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(container,fragment);
            transaction.commit();
        }
    }
}
