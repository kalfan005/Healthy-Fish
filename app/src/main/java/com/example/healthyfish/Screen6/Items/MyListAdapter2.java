package com.example.healthyfish.Screen6.Items;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyfish.R;

import com.example.healthyfish.Screen8.Fishquantity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


public class MyListAdapter2 extends RecyclerView.Adapter<MyListAdapter2.ViewHolder2>  {

    private static final String TAG = "ListAdapter";
    private ArrayList<HashMap<String, String>> listdata2;


    public MyListAdapter2(ArrayList<HashMap<String, String>> listdata) {
        this.listdata2 = listdata;

    }
    @NonNull
    @Override
    public MyListAdapter2.ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_fish, parent, false);
        MyListAdapter2.ViewHolder2 viewHolder1 = new MyListAdapter2.ViewHolder2(listItem);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter2.ViewHolder2 holder, int position) {

        final HashMap<String, String> itemData = listdata2.get(position);
        holder.textView01.setText(itemData.get("product_id"));
        holder.textView02.setText(itemData.get("name"));
        holder.textView03.setText(itemData.get("price"));

        Picasso.get()
                .load(itemData.get("image"))
                .into(holder.imageView01);



        holder.linearlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Fishquantity.class);
                i.putExtra("product_id", itemData.get("product_id"));
                i.putExtra("name", itemData.get("name"));
                i.putExtra("price", itemData.get("price"));
                i.putExtra("image", itemData.get("image"));
                v.getContext().startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return listdata2.size();
    }


    public class ViewHolder2 extends RecyclerView.ViewHolder {

        public ImageView imageView01;
        public TextView textView01,textView02,textView03;
        public LinearLayout linearlayout2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);

            this.imageView01 = (ImageView) itemView.findViewById(R.id.imageView01);
            this.textView01 = (TextView) itemView.findViewById(R.id.textView01);
            this.textView02 = (TextView) itemView.findViewById(R.id.textView02);
            this.textView03 = (TextView) itemView.findViewById(R.id.textView03);
            this.linearlayout2 = (LinearLayout) itemView.findViewById(R.id.linearlayout2);
        }
    }
}
