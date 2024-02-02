package com.example.healthyfish.Screen16;

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

public class ProductAdapter3 extends RecyclerView.Adapter<ProductAdapter3.ProductViewHolder3>{

    private Context mCtx3;
    private List<product3> productList3;


    public ProductAdapter3(Context mCtx3, List<product3> productList3){

        this.mCtx3 = mCtx3;
        this.productList3 = productList3;
    }

    @Override

    public ProductViewHolder3 onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx3);
        View view = inflater.inflate(R.layout.order_list, null);
        return new ProductViewHolder3(view);
    }

    @Override

    public void onBindViewHolder( ProductAdapter3.ProductViewHolder3 holder, int position) {

        product3 product3 = productList3.get(position);
        holder.textViewTitle2.setText(product3.getTitle2());
        holder.textViewShortDesc2.setText(product3.getShortdesc2());
        holder.textViewdetail.setText(product3.getDetail());
        holder.textViewOderid.setText(product3.getOrderid());
        holder.textViewOrdernumber.setText(String.valueOf(product3.getOrdernumber()));
        int productImage = product3.getImage2();
        holder.imageView2.setImageResource(productImage);
    }


    @Override
    public int getItemCount() {
        return productList3.size();
    }

    public class ProductViewHolder3 extends RecyclerView.ViewHolder {

        TextView textViewTitle2, textViewShortDesc2, textViewdetail ,textViewOderid,textViewOrdernumber;
        ImageView imageView2;
        public ProductViewHolder3(View itemView) {
            super(itemView);

            textViewTitle2 = itemView.findViewById(R.id.textViewTitle2);
            textViewShortDesc2 = itemView.findViewById(R.id.textViewShortDesc2);
            textViewdetail = itemView.findViewById(R.id.textViewdetail);
            textViewOderid = itemView.findViewById(R.id.textViewOderid);
            textViewOrdernumber = itemView.findViewById(R.id.textViewOrdernumber);
            imageView2 = itemView.findViewById(R.id.imageView2);

        }
    }
}
