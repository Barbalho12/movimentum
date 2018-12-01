package br.ufrn.movimentum;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SearchGroupActivity extends AppCompatActivity {

    private EditText et_search_group;
    private CheckBox cb_search_op1_group;
    private CheckBox cb_search_op2_group;
    private CheckBox cb_search_op3_group;
    private CheckBox cb_search_op4_group;
    private CheckBox cb_search_op5_group;
    private CheckBox cb_search_op6_group;
    private Button bt_search_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_group);

        initToolbar();
        initViewWidgets();
//        setValuesDefault();

        bt_search_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initViewWidgets() {
        et_search_group = findViewById(R.id.et_search_group);
        cb_search_op1_group = findViewById(R.id.cb_search_op1_group);
        cb_search_op2_group = findViewById(R.id.cb_search_op2_group);
        cb_search_op3_group = findViewById(R.id.cb_search_op3_group);
        cb_search_op4_group = findViewById(R.id.cb_search_op4_group);
        cb_search_op5_group = findViewById(R.id.cb_search_op5_group);
        cb_search_op6_group = findViewById(R.id.cb_search_op6_group);
        bt_search_group = findViewById(R.id.bt_search_group);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_search_group);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Buscar Grupo");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
