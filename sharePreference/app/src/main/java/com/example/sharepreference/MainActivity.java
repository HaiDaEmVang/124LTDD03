package com.example.sharepreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    EditText textInput;
    Button btn;
    ListView listView;
    SharedPreferences sharedPreferences;
    List<String> dsNguoiYeuCu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsNguoiYeuCu = new ArrayList<>();
        sharedPreferences = getSharedPreferences("dsNguoiYeuCu", MODE_PRIVATE);

        Set<String> mySet = sharedPreferences.getStringSet("ds", new HashSet<>());
        dsNguoiYeuCu = new ArrayList<>(mySet);
        anhxa();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dsNguoiYeuCu);
        listView.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = String.valueOf(textInput.getText());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                mySet.add(value);
                editor.putStringSet("ds", mySet);
                editor.apply();
            }
        });


    }

    public void anhxa(){
        textInput = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        listView = findViewById(R.id.list);

    }
}