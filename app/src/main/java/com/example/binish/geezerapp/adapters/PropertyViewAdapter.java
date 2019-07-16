package com.example.binish.geezerapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.binish.geezerapp.R;
import com.example.binish.geezerapp.models.Property;

import java.util.List;

public class PropertyViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Property> properties;

    public PropertyViewAdapter(Context context, List<Property> properties) {
        this.context = context;
        this.properties = properties;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.design_properties, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Property property = properties.get(position);
        holder.name.setText(property.getName());
        holder.full_address.setText(property.getFull_address());
        holder.type.setText(property.getType());
        holder.price.setText("$" + String.valueOf(property.getMonthly_rental()) + " / month");
        holder.bedrooms.setText(String.valueOf(property.getNum_bedrooms()) + " bedrooms");
        holder.bathrooms.setText(String.valueOf(property.getNum_bathrooms()) + " bathrooms");
        holder.sqft.setText(String.valueOf(property.getSize_sqft()) + " sq. ft.");
        if (property.getLease_terms().size() > 0)
            holder.months.setText(property.getLease_terms().get(0));
        holder.furnished.setText(property.getFurnishing());
        holder.closestMRT.setText("Parking: " + property.getParking());
        holder.year_built.setText("Year Built: " + String.valueOf(property.getYear_built()));
        holder.facilities.setText("Special: " + property.getSpecial());

        if (property.getWishlisted())
            holder.wishList.setImageResource(R.drawable.ic_shopping_cart_dark_24dp);
        Glide.with(context)
                .load(property.getImages().get(0))
                .centerCrop()
                .into(holder.property_image);
    }

    @Override
    public int getItemCount() {
        return properties.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    TextView name, full_address, type, price;
    ImageView property_image, wishList;
    TextView bedrooms, bathrooms, sqft, months;
    TextView furnished, closestMRT, facilities, year_built;
    LinearLayout detailsLayout;
    CardView propertyCardView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        full_address = itemView.findViewById(R.id.full_address);
        property_image = itemView.findViewById(R.id.property_image);
        type = itemView.findViewById(R.id.type);
        price = itemView.findViewById(R.id.price);
        wishList = itemView.findViewById(R.id.wishList);

        bedrooms = itemView.findViewById(R.id.bedrooms);
        bathrooms = itemView.findViewById(R.id.bathrooms);
        sqft = itemView.findViewById(R.id.sqft);
        months = itemView.findViewById(R.id.months);

        furnished = itemView.findViewById(R.id.furnished);
        closestMRT = itemView.findViewById(R.id.closestMRT);
        facilities = itemView.findViewById(R.id.facilities);
        year_built = itemView.findViewById(R.id.year_built);

        detailsLayout = itemView.findViewById(R.id.detailsLayout);
        propertyCardView = itemView.findViewById(R.id.propertyCardView);
    }

}
