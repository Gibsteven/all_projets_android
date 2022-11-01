package com.example.smartcheckingapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        TextView name,Enter_type,state,Value_motif,id,Text_Hours_In,Text_Hours_Out;
        ImageView pp;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            Enter_type = itemView.findViewById(R.id.Enter_type);
            state = itemView.findViewById(R.id.state);
            Value_motif = itemView.findViewById(R.id.Value_motif);
            id = itemView.findViewById(R.id.id);
            Text_Hours_In = itemView.findViewById(R.id.Text_Hours_In);
            Text_Hours_Out = itemView.findViewById(R.id.Text_Hours_Out);
            pp = itemView.findViewById(R.id.pp);

        }

        void setDetails(Contact c)
        {
            name.setText(c.getName());
            Enter_type.setText(c.getEnter_type());
            state.setText(c.getState());
            Value_motif.setText(c.getValue_motif());
            id.setText(c.getId());
            Text_Hours_In.setText(c.getText_Hours_In());
            Text_Hours_Out.setText(c.getText_Hours_Out());
            pp.setImageResource(c.getPp());

        }

    }
}
