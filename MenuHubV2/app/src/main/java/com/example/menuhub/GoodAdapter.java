package com.example.menuhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MenuHub> merchantDatalist;

    public GoodAdapter(Context context, ArrayList<MenuHub> merchantDatalist) {
        this.context = context;
        this.merchantDatalist = merchantDatalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_goods, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        MenuHub item = merchantDatalist.get(position);
        holder.tvName.setText(item.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.setOnItemClickListener(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return merchantDatalist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    private ItemClickListener listener;

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public interface ItemClickListener {
        void setOnItemClickListener(int position);
    }
}
