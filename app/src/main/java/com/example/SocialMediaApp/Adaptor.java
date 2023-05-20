package com.example.SocialMediaApp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.viewHolder> {

    private ArrayList<PhotoPost> photoPosts;

    public Adaptor(ArrayList<PhotoPost> photoPosts) {
        this.photoPosts = photoPosts;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);


        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.name.setText(photoPosts.get(position).getName());
        holder.typeOf.setText(photoPosts.get(position).getTypeOf());
        holder.logo.setImageResource(photoPosts.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return photoPosts.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView name,typeOf;
        ImageView logo;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            typeOf=itemView.findViewById(R.id.description);
            logo=itemView.findViewById(R.id.photo);
        }
    }



}
