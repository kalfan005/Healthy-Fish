package com.example.healthyfish.Screen7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyfish.R;

import java.util.List;

public class GridAdapter1 extends RecyclerView.Adapter<GridAdapter1.ViewHolder> {

    private Context context2;
    private List<Griditem1> gridItems2;

    public GridAdapter1(Context context, List<Griditem1> gridItems2) {
        this.context2 = context;
        this.gridItems2 = gridItems2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context2).inflate(R.layout.griditem_seafish, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Griditem1 item = gridItems2.get(position);
        if (position >= 0 && position < gridItems2.size()) {
            item = gridItems2.get(position);

            // Check if the item is not null
            if (item != null) {

                holder.imageView.setImageResource(item.getImageId());
                holder.titleTextView.setText(item.getTitle());
                holder.priceTextView.setText(item.getPrice());

            }
        }
    }

    @Override
    public int getItemCount() {
        if (gridItems2.isEmpty()) {
            return 0;
        } else {
            return gridItems2.size();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView priceTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gridItemImageView1);
            titleTextView = itemView.findViewById(R.id.gridItemTitle);
            priceTextView = itemView.findViewById(R.id.gridItemPrice);
        }
    }
}
