package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ContactHolder> {

    Context context;
    ArrayList<Contact> dataSet;

    public CardAdapter(Context context, ArrayList<Contact> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false);
        return new ContactHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {

        Contact cn = dataSet.get(position);
        holder.setDetails(cn);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    class ContactHolder extends RecyclerView.ViewHolder{
        TextView nom,numero;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            nom= itemView.findViewById(R.id.nom);
            numero= itemView.findViewById(R.id.num);

        }

        void setDetails(Contact c)
        {
            nom.setText(c.getNom());
            numero.setText("numero :"+c.getNum());
        }

    }
}
