package com.example.kgpaisaaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt,b2;
    TextView t1;
    String data ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.editText);
        bt = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
       t1 = findViewById(R.id.textView);



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = et.getText().toString();
                if (amount.length() > 0) {
                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                    db.insertLabel(amount);


                    et.setText("");


                } else {
                    Toast.makeText(getApplicationContext(), "Please enter right amount",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                String data="expences";
               List<String > l1=db.getAllLabels();
              int size= l1.size();
         String x=" ";
         int sum=0;
               for(int i=0;i<size;i++)
               {
                   x=l1.get(i);
                   data= data +x+"\n";

                              }

                  t1.append(data);



            }
        });



    }
}