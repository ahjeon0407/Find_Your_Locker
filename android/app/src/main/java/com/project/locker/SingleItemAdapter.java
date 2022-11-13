package com.project.locker;

import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SingleItemAdapter extends RecyclerView.Adapter<SingleItemAdapter.ViewHolder> {

    private ArrayList<SingleItem> array_singleItem = new ArrayList<>();


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView num;

        public ViewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.title);
            num = view.findViewById(R.id.num);

        }
    }

    public SingleItemAdapter(ArrayList<SingleItem> array_singleItem) {
        this.array_singleItem = array_singleItem;
    }

    @Override
    public SingleItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list, parent, false);
        SingleItemAdapter.ViewHolder vh = new SingleItemAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(SingleItemAdapter.ViewHolder holder, int position) {
        SingleItem item = array_singleItem.get(position);

        holder.title.setText(item.getName());
        holder.num.setText(item.getNum());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mPosition = holder.getAdapterPosition();
                Context context = view.getContext();
                Intent detailActivity = new Intent(context, DetailActivity.class);

                detailActivity.putExtra("title", array_singleItem.get(mPosition).getName());

                ((Keep)context).startActivity(detailActivity);
            }
        });
    }

    @Override
    public int getItemCount(){
        return array_singleItem.size();
    }
}
