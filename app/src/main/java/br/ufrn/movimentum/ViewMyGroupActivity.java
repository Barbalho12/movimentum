package br.ufrn.movimentum;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.ufrn.movimentum.fragments.CommunityFragment;
import br.ufrn.movimentum.fragments.DetailsGroupFragment;
import br.ufrn.movimentum.fragments.InitFragment;
import br.ufrn.movimentum.fragments.NewsFragment;
import br.ufrn.movimentum.fragments.NewsGroupFragment;
import br.ufrn.movimentum.model.UserManager;

import static android.content.ContentValues.TAG;

public class ViewMyGroupActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
//    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_my_group);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Grupo");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

//        navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

//        userManager = new UserManager(getApplicationContext());
//        View header = navigationView.getHeaderView(0);
//        tv_user_name_nav = (TextView) header.findViewById(R.id.tv_user_name_nav);
//        tv_user_role_nav= (TextView) header.findViewById(R.id.tv_user_role_nav);

//        if (userManager.getActiveUser() != null) {
//            navigationView.getMenu().getItem(0).setTitle("Exercícios Realizados: " + userManager.getActiveUser().getNumberExercRealizados());
//            navigationView.getMenu().getItem(1).setTitle("Exercícios vizualizados: " + userManager.getActiveUser().getNumberExercVistos());
//            navigationView.getMenu().getItem(2).setTitle("Kanjis Vistos: " + userManager.getActiveUser().getKanjis_vistos());
//        } else {
//            navigationView.getMenu().getItem(0).setTitle("Exercícios Realizados: x");
//            navigationView.getMenu().getItem(1).setTitle("Exercícios vizualizados: x");
//            navigationView.getMenu().getItem(2).setTitle("Kanjis Vistos: x");
//        }


//        if (userManager.getActiveUser() != null && tv_user_name_nav != null) {
//            Log.v(TAG, userManager.getActiveUser().getNome());
//
//            tv_user_name_nav.setText(userManager.getActiveUser().getNome());
//        }

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

//        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container_my_group);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs_my_group);
        tabLayout.setupWithViewPager(mViewPager);

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return DetailsGroupFragment.newInstance(0);
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return NewsGroupFragment.newInstance(1);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Detalhes";
                case 1:
                    return "Notícias";
            }
            return null;
        }
    }

}
