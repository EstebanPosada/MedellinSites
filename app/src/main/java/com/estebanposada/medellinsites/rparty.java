package com.estebanposada.medellinsites;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class rparty extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rparty);


        PagerAdapter4 adapter4 = new PagerAdapter4(getSupportFragmentManager());
        viewPager4 = (ViewPager) findViewById(R.id.pager4);
        viewPager4.setAdapter(adapter4);

        viewPager4.setOnPageChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setText("Tibiri Tabara").setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("La Ruana de Juana").setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("La Garganta").setTabListener(this);
        actionBar.addTab(tab);

    }

    public class PagerAdapter4 extends FragmentPagerAdapter {

        public PagerAdapter4(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new rumb1();
                case 1:
                    return new rumb2();
                case 2:
                    return new rumb3();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager4.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
