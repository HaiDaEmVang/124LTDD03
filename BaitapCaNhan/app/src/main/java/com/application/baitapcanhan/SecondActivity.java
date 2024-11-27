package com.application.baitapcanhan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.baitapcanhan.databinding.ActivitySecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<ItemViewHolder> data = new ArrayList<>();
        data.add(new ItemViewHolder("Ga nuong", "Thom ngon dam vi", ""));
        data.add(new ItemViewHolder("Ga nuong", "Thom ngon dam vi", ""));
        data.add(new ItemViewHolder("Ga nuong", "Thom ngon dam vi", ""));
        data.add(new ItemViewHolder("Ga nuong", "Thom ngon dam vi", ""));

        binding.view.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.view.setAdapter(new CustomAdapter(data,this));

    }
}