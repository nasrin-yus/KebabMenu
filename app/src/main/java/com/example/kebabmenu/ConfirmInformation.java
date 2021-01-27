package com.example.kebabmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);
       //findviewByIdea
        EditText edtName=findViewById(R.id.edtName);
        EditText edtFamily=findViewById(R.id.edtFamily);
        Button btnSave=findViewById(R.id.btnSave);
        Button btnEdit=findViewById(R.id.btnEdit);
        //name & family
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String family = intent.getStringExtra("family");
        edtName.setText(name);
        edtFamily.setText(family);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name = edtName.getText().toString();
               String family = edtFamily.getText().toString();
                Intent intent1=new Intent();
                intent1.putExtra("name", name);
                intent1.putExtra("family", family);
                setResult(Activity.RESULT_OK,intent1);
               finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  name = edtName.getText().toString();
                String family = edtFamily.getText().toString();
                getSharedPreferences("myInfo", Context.MODE_PRIVATE).edit().putString("name", name).apply();
                getSharedPreferences("myInfo", Context.MODE_PRIVATE).edit().putString("family", family).apply();
                Intent intent=new Intent(ConfirmInformation.this,EnterInformation.class);
                Toast.makeText(ConfirmInformation.this, "Your Information Saved!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });



    }
}