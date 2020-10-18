package k.example.bottomsheet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import k.example.bottomsheet.R;
import k.example.bottomsheet.model.Rating_item;

public class Rating_adapter extends RecyclerView.Adapter<Rating_adapter.MyViewHolder>{

    List<Rating_item> mdata;
    private Context ctx;

    public Rating_adapter(List<Rating_item> mdata, Context ctx) {
        this.mdata = mdata;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rating,parent,false);

        return new Rating_adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.dics.setText(mdata.get(position).getDes());
        holder.date.setText(mdata.get(position).getDate());
        holder.ratingBar.setRating(mdata.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        RatingBar ratingBar;
        TextView dics,date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ratingBar=itemView.findViewById(R.id.item_rating);
            dics=itemView.findViewById(R.id.item_dics);
            date=itemView.findViewById(R.id.item_date);
            ratingBar=itemView.findViewById(R.id.item_rating);
        }
    }
}
