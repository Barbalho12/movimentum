package br.ufrn.movimentum;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewGroupActivity extends AppCompatActivity {

    private Spinner sp_local_new_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_new_group);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

//        mActionBar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
//        mActionBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //What to do on back clicked
//            }
//        });

        addItemsOnSpinner();

    }

    // add items into spinner dynamically
    public void addItemsOnSpinner() {
        sp_local_new_group = (Spinner) findViewById(R.id.sp_local_new_group);
        List<String> list = new ArrayList<String>();
        list.add("Escolha o local");
        list.add("Arena das Dunas");
        list.add("UFRN - Pista de atletismo");
        list.add("UFRN - Ginásio 1");
        list.add("UFRN - Ginásio 2");
        list.add("UFRN - Piscina 2");
        list.add("UFRN - Piscina 1");
        list.add("Em torno da UFRN");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);

        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item, list){
            @Override
            public boolean isEnabled(int position){
                if(position == 0){return false;
                } else { return true; }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                }else {
                    tv.setTextColor(Color.BLACK);
                }

                return view;
            }
        };
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_local_new_group.setAdapter(dataAdapter);
        sp_local_new_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItemText = (String) adapterView.getItemAtPosition(i);
                if(i > 0){
                    // Ação realizada quando um elemento diferente
                    // do hint é selecionado
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }



    @Override
    public void onBackPressed() {

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }
}
