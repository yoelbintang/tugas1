package com.example.yolzmvn.biodata_mhs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*public void showText(View v){
        String teks = inpText.getText().toString();
        txtHello.setText(teks);
    }*/

    Intent it;
    EditText edtPhone, edtmaps;

    /*public void showActivity2(View v){
        String teks = inpText.getText().toString();

        it = new Intent(this, Main2Activity.class);
        it.putExtra("data.key", teks);
        startActivity(it);
    }*/

    public void callPhone(View v){
        edtPhone = (EditText) findViewById(R.id.inpPhone);
        String phone = edtPhone.getText().toString();
        Uri uri = Uri.parse("tel:"+phone);
        it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }

    public void openmaps(View v){
        //edtmaps = (EditText) findViewById(R.id.inpmaps);
        //String maps = edtmaps.getText().toString();
        Uri uri = Uri.parse("https://www.google.com/maps/search/semarang/@-6.991862, 110.481215");
        it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);

    }

    public void openemail(View v){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"yoelbintang2@gmail.com"});
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
}