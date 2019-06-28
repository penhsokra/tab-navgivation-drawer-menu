package activity.sokra.com.navigation;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import activity.sokra.com.navigation.adapter.ViewPagerAdapter;
import activity.sokra.com.navigation.fragment.DoneFragement;
import activity.sokra.com.navigation.fragment.HomeFragement;
import activity.sokra.com.navigation.fragment.InboxFragement;
import activity.sokra.com.navigation.fragment.SnoozedFragement;

public class TabeLayoutActivity extends AppCompatActivity {
    TabLayout tableLayout;
    Toolbar toolbar;
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;
    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabe_layout);

        tableLayout = findViewById(R.id.tablayout);
        toolbar = findViewById(R.id.toolbar_main);
        viewPager = findViewById(R.id.viewPager);

        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        fragments.add(new HomeFragement());
        fragments.add(new DoneFragement());
        fragments.add(new InboxFragement());
        fragments.add(new SnoozedFragement());

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewPagerAdapter);

        tableLayout.setupWithViewPager(viewPager);


        for (int i = 0;i<=tableLayout.getTabCount();i++){

            TabLayout.Tab tab = tableLayout.getTabAt(i);

            if(i== 0){
                tab.setIcon(R.drawable.ic_home_black_24dp);
            }else if(i==1){
                tab.setIcon(R.drawable.ic_snooze_black_24dp);
            }else if(i==2){
                tab.setIcon(R.drawable.ic_done_black_24dp);
            }else if (i == 3){
                tab.setIcon(R.drawable.ic_settings_black_24dp);
            }

        }



    }
}
