package com.example.healthyfish.screen22;

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
import com.example.healthyfish.Screen23.RecipesitemActivity;
import com.example.healthyfish.Screen6.Items.CategoryFishitem;
import com.example.healthyfish.Screen6.Items.MyListAdapter2;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    private static final String TAG = "ListAdapter";
    private ArrayList<HashMap<String, String>> listdata;


    public RecipesAdapter(ArrayList<HashMap<String, String>> listdata){
        this.listdata = listdata;
    }


    @NonNull
    @Override
    public RecipesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recipes_item, parent, false);
        RecipesAdapter.ViewHolder viewHolder = new RecipesAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesAdapter.ViewHolder holder, int position) {

        final HashMap<String, String> itemData = listdata.get(position);
        holder.recipeid.setText(itemData.get("id"));
        holder.nameView.setText(itemData.get("name"));
        holder.timeTextView.setText(itemData.get("time"));

        Picasso.get()
                .load(itemData.get("image"))
                .into(holder.imagee);

        holder.linearlayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), RecipesitemActivity.class);
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {return listdata.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView  imagee;
        public TextView  recipeid,nameView,timeTextView;
        public LinearLayout linearlayout3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imagee = (ImageView) itemView.findViewById(R.id.imagee);
            this.recipeid = (TextView) itemView.findViewById(R.id.recipeid);
            this.nameView = (TextView) itemView.findViewById(R.id.nameView);
            this.timeTextView = (TextView) itemView.findViewById(R.id.timeTextView);
            this.linearlayout3  = (LinearLayout) itemView.findViewById(R.id.linearlayout3);

        }
    }
}
