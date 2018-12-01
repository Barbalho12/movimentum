package br.ufrn.movimentum;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewGroupActivity extends AppCompatActivity {

    private Spinner sp_local_new_group;
    private static int RESULT_LOAD_IMAGE = 1;

    private ImageView iv_image_new_group;

    private Button bt_time_init_new_group;
    private Button bt_time_end_new_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_new_group);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Novo Grupo");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addItemsOnSpinner();

        iv_image_new_group = findViewById(R.id.iv_image_new_group);
        iv_image_new_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        bt_time_init_new_group = findViewById(R.id.bt_time_init_new_group);
        bt_time_init_new_group.setBackgroundColor(Color.argb(180, 150, 200, 150));
        bt_time_init_new_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(NewGroupActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        bt_time_init_new_group.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });

        bt_time_end_new_group = findViewById(R.id.bt_time_end_new_group);
        bt_time_end_new_group.setBackgroundColor(Color.argb(180, 200, 150, 150));
        bt_time_end_new_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(NewGroupActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        bt_time_end_new_group.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
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

        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, list) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    tv.setTextColor(Color.GRAY);
                } else {
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
                if (i > 0) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {
            Uri fullPhotoUri = data.getData();
            iv_image_new_group.setImageURI(fullPhotoUri);
        }
    }
}
