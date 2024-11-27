package com.application.baitapcanhan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.itemViewHolder> {

    private final List<ItemViewHolder> listPost;
    private final Context context;

    public CustomAdapter(List<ItemViewHolder> listPost, Context context) {
        this.listPost = listPost;
        this.context = context;
    }
    @NonNull
    @Override
    public CustomAdapter.itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_viewholder, parent, false);
        return new itemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.itemViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = listPost.get(position);
        Glide.with(context).load(itemViewHolder.getHinhAnh()).into(holder.pic);
        holder.mota.setText(itemViewHolder.getMota());
        holder.ten.setText(itemViewHolder.getTen());
    }




    @Override
    public int getItemCount() {
        return listPost.size();
    }


    public class itemViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView ten, mota;
        public itemViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.image);
            ten = itemView.findViewById(R.id.title);
            ten = itemView.findViewById(R.id.description);
        }
    }
}
