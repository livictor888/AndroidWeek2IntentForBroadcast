package com.example.intentforbroadcast;

import static android.Manifest.permission.CALL_PHONE;
import android.content.pm.PackageManager;
import androidx.core.content.ContextCompat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // called when the "BROWSE URL" button is clicked
    public void browse(View view) {
        // obtain the link input by the user
        EditText editText = findViewById(R.id.editTextURL);
        String link = "http://" + editText.getText().toString();
        // create a uri (uniform resource identifier) object for the link
        Uri uri = Uri.parse(link);
        // create the intent (implicit) and start it
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    // called when the "MAKE PHONE CALL" button is clicked
    public void call(View view) {
        // obtain the phone number input by the user
        EditText editText = findViewById(R.id.editTextPhone);
        String phone = "tel:" + editText.getText().toString();
        // create a uri (uniform resource identifier) object for the phone number
        Uri uri = Uri.parse(phone);
        // create the intent (implicit) and start it
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);

//        // create the intent with ACTION_CALL, instead of ACTION_DIAL
//        Intent intent = new Intent(Intent.ACTION_CALL, uri);
//        // check if the permission to call is granted before starting the intent
//        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//            startActivity(intent);
//        } else {
//            requestPermissions(new String[]{CALL_PHONE}, 1);
//        }
    }
}