package com.example.binish.geezerapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.binish.geezerapp.R;
import com.example.binish.geezerapp.models.Property;

import java.util.List;

public class PropertyViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Property> properties;
    public PropertyViewAdapter(Context context, List<Property> properties){
        this.context = context;
        this.properties = properties;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.design_properties,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Property property = properties.get(position);
        holder.name.setText(property.getName());
        holder.full_address.setText(property.getFull_address());
        holder.type.setText(property.getType());
    }

    @Override
    public int getItemCount() {
        return properties.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    TextView name,full_address,type;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        full_address = itemView.findViewById(R.id.full_address);
        type = itemView.findViewById(R.id.type);
    }

}
