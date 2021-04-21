package uk.ac.bham.student.starmegabucks;


import android.content.Intent;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {
    private ArrayList<CafeProduct> products;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ViewHolder(TextView v){
            super(v);
            textView = v;
        }
    }

    public CoffeeAdapter(ArrayList<CafeProduct> products){
        this.products = products;
    }

    @Override
    public CoffeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){
        ViewHolder vh = new ViewHolder(new TextView(parent.getContext()));
        vh.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,80f);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position){
        holder.textView.setText(products.get(position).toString());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),
                        DrinkDetailsActivity.class);
                intent.putExtra("apiID",products.get(position).getApiID());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return products.size();
    }
}
