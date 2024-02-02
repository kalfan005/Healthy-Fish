package com.example.healthyfish.Screen10;

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

public class ProductAdapter2 extends RecyclerView.Adapter<ProductAdapter2.ProductViewHolder2> {

    private Context mCtx2;
    private List<product2> productList2;

    public ProductAdapter2(Context mCtx2, List<product2> productList2){
        this.mCtx2 = mCtx2;
        this.productList2 = productList2;
    }
    @NonNull
    @Override
    public ProductViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx2);
        View view = inflater.inflate(R.layout.layout_cut, null);
        return new ProductViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter2.ProductViewHolder2 holder, int position) {
        product2 product = productList2.get(position);

        holder.textViewShortDesc2.setText(product.getShortdesc());
        holder.textViewPrice2.setText(String.valueOf(product.getPrice()));
        int productImage = product.getImage();
        holder.imageView2.setImageResource(productImage);
    }

    @Override
    public int getItemCount() {
        return productList2.size();
    }

    public class ProductViewHolder2 extends RecyclerView.ViewHolder {

        TextView  textViewShortDesc2, textViewPrice2;
        ImageView imageView2;
        public ProductViewHolder2(@NonNull View itemView) {
            super(itemView);

            textViewShortDesc2 = itemView.findViewById(R.id.textViewShortDesc2);
            textViewPrice2 = itemView.findViewById(R.id.textViewPrice2);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }
    }
}
