package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.newsapp.adaptors.PagerAdaptor;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar mtoolbar;

    private TabLayout tabLayout;
    private PagerAdaptor pagerAdapter;
    private ViewPager viewPager;
    private TabItem mHome,mSports,mHealth,mScience,mEntertainment,mTechnology;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting ID's
        mtoolbar = findViewById(R.id.toolbar);

        mHome = findViewById(R.id.homeTabItem);
        mSports = findViewById(R.id.sportsTabItem);
        mHealth = findViewById(R.id.healthTabItem);
        mScience = findViewById(R.id.scienceTabItem);
        mEntertainment = findViewById(R.id.entertainmentTabItem);
        mTechnology = findViewById(R.id.technologyTabItem);

        viewPager = findViewById(R.id.fragmentContainer);
        tabLayout = findViewById(R.id.include_tabLayout);

        // Functionality
        setSupportActionBar(mtoolbar);

        // Pager Adapter
        pagerAdapter = new PagerAdaptor(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());



                    if(tab.getPosition()==0 ||
                    tab.getPosition()==1 ||
                    tab.getPosition()==2 ||
                    tab.getPosition()==3 ||
                    tab.getPosition()==4 ||
                    tab.getPosition()==5){
                        pagerAdapter.notifyDataSetChanged();
                    }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));








    }
}