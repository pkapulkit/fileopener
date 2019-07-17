package com.pka.fileopener;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.openfile);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/data/data/com.pka.fileopener/myExcel.xls");
                Intent excelOpenintent = new Intent(Intent.ACTION_VIEW);
                String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Environment.getExternalStorageDirectory().getAbsolutePath()+"/data/data/com.pka.fileopener/myExcel.xls"));
                excelOpenintent.setDataAndType(FileProvider.getUriForFile(MainActivity.this,BuildConfig.APPLICATION_ID + ".provider",file), mimeType);
                Intent intent1 = Intent.createChooser(excelOpenintent, "Open With");
                intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(intent1);

            }
        });
    }

}
