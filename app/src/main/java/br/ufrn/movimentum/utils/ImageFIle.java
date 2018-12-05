package br.ufrn.movimentum.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import br.ufrn.movimentum.R;

public class ImageFIle {

    public static final int REQUEST_EXTERNAL_STORAGE = 1;
    public static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static String trySaveImage(String name, Drawable d) {

//        Drawable d = getDrawable(R.drawable.boy);
        Bitmap write_b = ((BitmapDrawable) d).getBitmap();

        String img_file_name = "image.png";
        if(name != null || name.equals(""))
            img_file_name = name.replace(" ","_")+".png";
        String dir = saveToExternalStorage(write_b, img_file_name);
        return dir+"/"+img_file_name;
    }

    private static String saveToExternalStorage(Bitmap finalBitmap, String file_name) {

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
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


}
