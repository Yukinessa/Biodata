package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Telfon, Lokasi, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Telfon = (Button) findViewById(R.id.telfon);
        Lokasi = (Button) findViewById(R.id.lokasi);
        Email = (Button) findViewById(R.id.email);

        ///Buka Telfon
        Telfon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Telepon = new Intent(Intent.ACTION_DIAL);
                Telepon.setData(Uri.parse("tel:089662036127"));
                startActivity(Telepon);
            }
        });

        ///Lokasi Map
        Lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Jl. Sadewa 2 No.8, Pendrikan Kidul, Kec. Semarang Tengah, Kota Semarang, Jawa Tengah 50131");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        ///kirim email
        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, "kun.amrin@gmail.com");
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }





}
