package br.ufrn.movimentum;

import android.Manifest;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class NewGroupActivity extends AppCompatActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private Spinner sp_local_new_group;
    private static int RESULT_LOAD_IMAGE = 1;

    private ImageView iv_image_new_group;

    private TextView tv_title_new_group;

    private Button bt_time_init_new_group;
    private Button bt_time_end_new_group;

    private Button bt_create_new_group;

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

        tv_title_new_group = findViewById(R.id.tv_title_new_group);

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
//        bt_time_init_new_group.setBackgroundColor(Color.argb(180, 150, 200, 150));
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
//        bt_time_end_new_group.setBackgroundColor(Color.argb(180, 200, 150, 150));
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


        bt_create_new_group = findViewById(R.id.bt_create_new_group);
        bt_create_new_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Drawable d = iv_image_new_group.getDrawable();
                Bitmap write_b = ((BitmapDrawable) d).getBitmap();

                String img_file_name = "image.png";
                if(tv_title_new_group.getText() != null || tv_title_new_group.getText().toString().equals(""))
                    img_file_name = tv_title_new_group.getText().toString().replace(" ","_")+".png";
                String dir = saveToExternalStorage(write_b, img_file_name);

                Bitmap read_b = loadImageFromStorage(dir, img_file_name);
                iv_image_new_group.setImageBitmap(read_b);


                Snackbar.make(view, "Não implementado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


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

    private Uri groupImageView;

    protected String getName(){
        File file= new File(groupImageView.getPath());
        return file.getName();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {
            groupImageView = data.getData();
            iv_image_new_group.setImageURI(groupImageView);
        }
    }


    private String saveToInternalStorage(Bitmap bitmapImage, String file_name) {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("images", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, file_name);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    private String saveToExternalStorage(Bitmap finalBitmap, String file_name) {
//        verifyStoragePermissions(this);
////        String root = Environment.getExternalStorageDirectory().toString();
////        File myDir = new File(root + "/saved_images");
////        myDir.mkdirs();
//
//        File file = new File(Environment.getExternalStorageDirectory() + "/" + file_name);
////        if (file.exists()) file.delete ();
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
//            out.flush();
//            out.close();
//            return Environment.getExternalStorageDirectory().toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;

//
//        File sdCardDirectory = Environment.getExternalStorageDirectory();
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/images");
        if (!myDir.exists())
            myDir.mkdirs();
        File file = new File (myDir, file_name);
        if (file.exists()) file.delete ();
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
//            sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            // Parse the saved image path to uri
//            Uri savedImageURI = Uri.parse(file.getAbsolutePath());
            return myDir.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    private Bitmap loadImageFromStorage(String path, String file_name) {
        try {
            File f = new File(path, file_name);
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            return b;
//            ImageView img=(ImageView)findViewById(R.id.iv_image_new_group);
//            img.setImageBitmap(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
