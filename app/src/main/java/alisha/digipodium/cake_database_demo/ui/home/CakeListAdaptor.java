package alisha.digipodium.cake_database_demo.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

import alisha.digipodium.cake_database_demo.Cake;
import alisha.digipodium.cake_database_demo.R;

public class CakeListAdaptor extends RecyclerView.Adapter<CakeListAdaptor.Holder>{

    private LayoutInflater inflater;
    private Context c;
    private List<Cake> cakes;
    private int layout;

    public CakeListAdaptor(Context c,int layout){
        this.c=c;
        this.layout=layout;
        inflater=LayoutInflater.from(c);
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(layout,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (cakes != null) {
            Cake cake = cakes.get(position);
            holder.tvName.setText(cake.getName());
        }else {
            holder.tvName.setText("No Cakes Available");
        }
    }

    @Override
    public int getItemCount() {
        if (cakes != null){
            return cakes.size();
        }
        return 0;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        CardView card;
        TextView tvName;

        public Holder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
