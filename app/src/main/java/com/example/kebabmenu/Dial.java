package com.example.kebabmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        EditText edtPhone=findViewById(R.id.edtPhone);
        Button btnDial=findViewById(R.id.btnDial);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PhoneNumber = edtPhone.getText().toString();
                if (PhoneNumber.isEmpty()) {
                    Toast.makeText(Dial.this, "ENTER Number", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(PhoneNumber));
                    startActivity(intent);
                }



            }
        });
    }
}