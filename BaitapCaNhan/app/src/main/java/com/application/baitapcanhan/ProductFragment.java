package com.application.baitapcanhan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.baitapcanhan.databinding.FragmentProductBinding;

import java.util.ArrayList;
import java.util.List;


public class ProductFragment extends Fragment {

    FragmentProductBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);

        List<ItemViewHolder> data = new ArrayList<>();
        data.add(new ItemViewHolder("Giay Adidas", "kich thuoc phu hop voi moi lua tuoi", "https://product.hstatic.net/1000230642/product/bsm001100den1_01690cbb8f214c259165b1c34d7d9daf_grande.jpg"));
        data.add(new ItemViewHolder("Giay guci", "Thom ngon dam vi", "https://pos.nvncdn.com/80c639-72864/ps/20221117_G2MS1ZMNvAWqT87SbdKSwi4d.jpg"));
        data.add(new ItemViewHolder("Giay chanel", "Thom ngon dam vi", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkPahalACOAiPBuNVw0YKoi1sD5ZlNvruSVw&s"));
        data.add(new ItemViewHolder("Giay android", "Thom ngon dam vi", "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-ln2gpxt16aqgd1"));

        binding.view.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.view.setAdapter(new CustomAdapter(data,getContext()));



        return binding.getRoot();
    }
}