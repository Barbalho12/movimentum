package br.ufrn.movimentum;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SearchNewsActivity extends AppCompatActivity {

    private EditText et_search_news;
    private CheckBox cb_search_op1_news;
    private CheckBox cb_search_op2_news;
    private CheckBox cb_search_op3_news;
    private CheckBox cb_search_op4_news;
    private CheckBox cb_search_op5_news;
    private Button bt_search_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_news);

        initToolbar();
        initViewWidgets();
//        setValuesDefault();

        bt_search_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initViewWidgets() {
        et_search_news = findViewById(R.id.et_search_news);
        cb_search_op1_news = findViewById(R.id.cb_search_op1_news);
        cb_search_op2_news = findViewById(R.id.cb_search_op2_news);
        cb_search_op3_news = findViewById(R.id.cb_search_op3_news);
        cb_search_op4_news = findViewById(R.id.cb_search_op4_news);
        cb_search_op5_news = findViewById(R.id.cb_search_op5_news);
        bt_search_news = findViewById(R.id.bt_search_news);
    }


    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_search_news);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Buscar Notícias");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
