package com.estebanposada.medellinsites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class Restaurants extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        PagerAdapter2 adapter2 = new PagerAdapter2(getSupportFragmentManager());
        viewPager2 = (ViewPager) findViewById(R.id.pager2);
        viewPager2.setAdapter(adapter2);

        viewPager2.setOnPageChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setText("El Rancherito").setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Mondongos").setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Frutos del Mar").setTabListener(this);
        actionBar.addTab(tab);

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager2.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
            getSupportActionBar().setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public class PagerAdapter2 extends FragmentPagerAdapter {

        public PagerAdapter2(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new rest1();
                case 1:
                    return new rest2();
                case 2:
                    return new rest3();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
