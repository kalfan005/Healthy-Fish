package com.example.healthyfish.Screen6.Categoryclasses;



import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen6.Items.CategoryFishitem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{


    private static final String TAG = "ListAdapter";
    private ArrayList<HashMap<String, String>> listdata;


    public MyListAdapter(ArrayList<HashMap<String, String>> listdata) {
        this.listdata = listdata;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.listitem_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Entered bindview holder");
        final HashMap<String, String> itemData = listdata.get(position);
        holder.textView.setText(itemData.get("category_id"));
        holder.textView2.setText(itemData.get("name"));

        Picasso.get()
                .load(itemData.get("image"))
                .into(holder.imageView00);


        holder.linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), CategoryFishitem.class);
                i.putExtra("category_id", itemData.get("category_id").toString());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {return listdata.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView00;
        public TextView textView,textView2;
        public LinearLayout linearlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView00 = (ImageView) itemView.findViewById(R.id.imageView00);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.textView2 = (TextView) itemView.findViewById(R.id.textView2);
            this.linearlayout = (LinearLayout) itemView.findViewById(R.id.linearlayout);
        }
    }
}
