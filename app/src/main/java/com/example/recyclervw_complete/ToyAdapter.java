package com.example.recyclervw_complete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Toy;
import com.example.model.Toys;

public class ToyAdapter extends RecyclerView.Adapter<ToyAdapter.ToyViewHolder>{

    private Context context;
    private Toys    toys;
    private int     single_layout;

    public interface OnItemClickListener{
        public void onItemClicked(Toy toy);
    }

    public interface OnItemLongClickListener{
        public boolean onItemLongClicked(Toy toy);
    }

    private OnItemClickListener     listener;
    private OnItemLongClickListener longlistener;

    public ToyAdapter(Context context, Toys toys, int single_layout, OnItemClickListener listener, OnItemLongClickListener longlistener) {
        this.context       = context;
        this.toys          = toys;
        this.single_layout = single_layout;
        this.listener      = listener;
        this.longlistener  = longlistener;
    }

    @NonNull
    @Override
    public ToyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(single_layout, parent, false);
        return new ToyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToyViewHolder holder, int position) {
        Toy toy = toys.get(position);

        if (toy != null)
            holder.bind(toy, listener, longlistener);
    }

    @Override
    public int getItemCount() {
        return (toys == null) ? 0 : toys.size();
    }

    public static class ToyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivToy;
        private TextView tvName;
        private TextView  tvPrice;

        public ToyViewHolder(@NonNull View itemView){
            super(itemView);

            ivToy = itemView.findViewById(R.id.ivToy);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }

        public void bind(Toy toy, OnItemClickListener listener, OnItemLongClickListener longlistener) {
            //ivToy.setImageBitmap(toy.getPicture());
            tvName.setText(toy.getName());
            tvPrice.setText(String.valueOf(toy.getPrice()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(toy);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    longlistener.onItemLongClicked(toy);
                    return true;
                }
            });
        }
    }
}
