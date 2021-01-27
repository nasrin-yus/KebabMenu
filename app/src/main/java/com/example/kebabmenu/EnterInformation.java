package com.example.kebabmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_information);

       //findviewByIdea
        EditText edtEnterName = findViewById(R.id.edtEnterName);
        EditText edtEnterFamily = findViewById(R.id.edtEnterFamily);
        Button btnOK = findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtEnterName.getText().toString();
                String family = edtEnterFamily.getText().toString();
                Intent intent=new Intent(EnterInformation.this,ConfirmInformation.class);
                intent.putExtra("name", name);
                intent.putExtra("family", family);
                startActivityForResult(intent,100);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       EditText edtEnterName = findViewById(R.id.edtEnterName);
       EditText edtEnterFamily = findViewById(R.id.edtEnterFamily);

     super.onActivityResult(requestCode, resultCode, data);
           if (requestCode == 100) {
             if (resultCode == Activity.RESULT_OK) {
                String name = data.getStringExtra("name");
                String family=data.getStringExtra("family");
                 edtEnterName.setText(name);
                 edtEnterFamily.setText(family);
                 Toast.makeText(EnterInformation.this, "Edit Your Information!", Toast.LENGTH_SHORT).show();
             }
        }

    }
}
