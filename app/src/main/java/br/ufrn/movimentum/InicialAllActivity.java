package br.ufrn.movimentum;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.movimentum.adapters.ExercicioAdapter;
import br.ufrn.movimentum.adapters.ItemList;
import br.ufrn.movimentum.model.UserManager;

import static android.content.ContentValues.TAG;

public class InicialAllActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private UserManager userManager;

    private NavigationView navigationView;

    TextView tv_user_name_nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        userManager = new UserManager(getApplicationContext());
        View header = navigationView.getHeaderView(0);
        tv_user_name_nav = (TextView) header.findViewById(R.id.tv_user_name_nav);

//        exercicios_realizados
//        exercicios_vizualizados
//        kanjis_vistos
//

        if(userManager.getActiveUser()!=null){
            navigationView.getMenu().getItem(0).setTitle("Exercícios Realizados: "+userManager.getActiveUser().getNumberExercRealizados());
            navigationView.getMenu().getItem(1).setTitle("Exercícios vizualizados: "+userManager.getActiveUser().getNumberExercVistos());
            navigationView.getMenu().getItem(2).setTitle("Kanjis Vistos: "+userManager.getActiveUser().getKanjis_vistos());
        }else{
            navigationView.getMenu().getItem(0).setTitle("Exercícios Realizados: x");
            navigationView.getMenu().getItem(1).setTitle("Exercícios vizualizados: x");
            navigationView.getMenu().getItem(2).setTitle("Kanjis Vistos: x");
        }
//

        if(userManager.getActiveUser()!=null && tv_user_name_nav != null) {
            Log.v(TAG, userManager.getActiveUser().getNome());

            tv_user_name_nav.setText(userManager.getActiveUser().getNome());
        }

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
//
        ListView listview = (ListView) findViewById(R.id.listview);
//
        String points = "0";
//
        if(userManager.getActiveUser()!=null){
            points = String.valueOf( (int) userManager.getActiveUser().getPontuacao());

        }
//
        List<ItemList> list_itens = new ArrayList<>();
        list_itens.add(new ItemList(1,"Tutorial", points,"10","02pts"));
        list_itens.add(new ItemList(2,"Exercício Inicial","0","10","09pts"));
        list_itens.add(new ItemList(3,"Kanjis Iniciais 1","0","22","18pts"));
        list_itens.add(new ItemList(4,"Kanjis iniciais 2","0","35","22pts"));
        list_itens.add(new ItemList(5,"Kanjis Intermediários","0","28","46pts"));
        list_itens.add(new ItemList(6,"Kanjis Difíceis","0","24","62pts"));

        ExercicioAdapter exercicioAdapter = new ExercicioAdapter(list_itens, this);
//
        listview.setAdapter(exercicioAdapter);
//
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        "Clicou no item " + position, Toast.LENGTH_LONG).show();
                if(position==0){
                    Intent intent = new Intent(InicialAllActivity.this, MainActivity.class);
                    startActivity(intent);
//                    finish();
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(InicialAllActivity.this).create();
                    alertDialog.setTitle("Alerta");
                    alertDialog.setMessage("Não implementado");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicial_all, menu);
        return true;
    }

    void alert(){
        AlertDialog alertDialog = new AlertDialog.Builder(InicialAllActivity.this).create();
        alertDialog.setTitle("Alerta");
        alertDialog.setMessage("Confirme para sair");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sair",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishAffinity();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            alert();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_inicial_all, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "TODOS";
                case 1:
                    return "INICIADOS";
                case 2:
                    return "FINALIZADOS";
            }
            return null;
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ajuda) {

        } else if (id == R.id.nav_share) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Estou ficando cada vez melhor! Já tenho 10 pontos e sou iniciante no Kaligraphy! :)");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_sair) {
            userManager.setInActiveUser(getApplicationContext());
            Intent intent = new Intent(getApplicationContext(), StartActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
