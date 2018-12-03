package br.ufrn.movimentum;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class ViewGroupActivity extends AppCompatActivity {

    private ImageView iv_image_view_group;
    private TextView tv_title_view_group;
    private TextView tv_capacity_view_group;
    private TextView tv_local_view_group;
    private TextView tv_interval_group;
    private TextView tv_days_group;
    private Button bt_request_participate_group;
    private Button bt_view_local_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group);

        initToolbar();
        initViewWidgets();
        setValuesDefault();

        bt_request_participate_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        bt_view_local_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setValuesDefault() {
        String desc = "Este grupo é destinado para pessoas que curtem praticar corrida regulamente, " +
                "com a finalidade principal de buscar saúde e qualidade de vida. Para auxiliar cada " +
                "membro, um profissinal de educação física tem disponibilidade para retirar dúvidas.";
        WebView wv_view_group = findViewById(R.id.wv_view_group);
        wv_view_group.setVerticalScrollBarEnabled(false);
        String descHTML =  "<html><body style='text-align:justify;color:gray;'>  "+desc+" </body></html>";
        wv_view_group.loadData(descHTML,"text/html","utf-8");
        wv_view_group.setBackgroundColor(Color.TRANSPARENT);
        wv_view_group.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        //tv_descript_view_group.setText(desc);

        String pathName = "android.resource://"+getPackageName()+"/";
        Uri uri = Uri.parse(pathName+R.drawable.running_group);
        iv_image_view_group.setImageURI(uri);
        tv_title_view_group.setText("Corrida Livre");
        tv_local_view_group.setText("Em torno da UFRN");
        tv_interval_group.setText("18h00 - 19h00");
        tv_days_group.setText("qui,sex");
        tv_capacity_view_group.setText("17/30");
        tv_capacity_view_group.setTextColor(Color.rgb(80,170,80));
        //tv_descript_view_group.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }

    private void initViewWidgets() {
        iv_image_view_group = findViewById(R.id.iv_image_view_group);
        tv_title_view_group = findViewById(R.id.tv_title_view_group);
//        tv_descript_view_group = findViewById(R.id.tv_descript_view_group);
        tv_capacity_view_group = findViewById(R.id.tv_capacity_view_group);
        tv_local_view_group = findViewById(R.id.tv_local_view_group);
        tv_interval_group = findViewById(R.id.tv_interval_group);
        tv_days_group = findViewById(R.id.tv_days_group);
        bt_request_participate_group = findViewById(R.id.bt_request_participate_group);
        bt_view_local_group = findViewById(R.id.bt_view_local_group);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_view_group);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Informações do Grupo");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
