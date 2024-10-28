package com.example.sharepreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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
    ArrayAdapter<String> adapter; // Moved the adapter declaration here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize list and shared preferences
        dsNguoiYeuCu = new ArrayList<>();
        sharedPreferences = getSharedPreferences("dsNguoiYeuCu", MODE_PRIVATE);
        Set<String> mySet = sharedPreferences.getStringSet("ds", new HashSet<>());
        dsNguoiYeuCu = new ArrayList<>(mySet);

        anhxa();

        // Set up the adapter and attach it to the ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsNguoiYeuCu);
        listView.setAdapter(adapter);

        // Button click listener to add new item
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = textInput.getText().toString().trim(); // Use trim() to avoid whitespace entries
                if (!value.isEmpty()) { // Check for empty input
                    dsNguoiYeuCu.add(value); // Update the list
                    saveToSharedPreferences(); // Save the new value
                    adapter.notifyDataSetChanged(); // Notify the adapter of the change
                    textInput.setText(""); // Clear the input field
                }
            }
        });
    }

    private void saveToSharedPreferences() {
        Set<String> mySet = new HashSet<>(dsNguoiYeuCu); // Create a new HashSet from the list
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("ds", mySet);
        editor.apply();
    }

    public void anhxa() {
        textInput = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        listView = findViewById(R.id.list);
    }
}
