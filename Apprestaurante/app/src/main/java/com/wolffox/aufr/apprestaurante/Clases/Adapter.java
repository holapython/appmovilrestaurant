package com.wolffox.aufr.apprestaurante.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wolffox.aufr.apprestaurante.R;

/**
 * Created by Aufer on 24/07/2016.
 */

public class Adapter extends ArrayAdapter<String>{

    int[] imgs = {};
    String[] namesFood = {};
    String[] descriptionsFood = {};
    String[] pricesFood = {};
    Context c;
    LayoutInflater inflater;

    public Adapter(Context context, String[] namesFood, String[] descriptionsFood, String[] pricesFood, int[] imgs){
        super(context, R.layout.model, namesFood );

        this.c = context;
        this.namesFood = namesFood;
        this.descriptionsFood = descriptionsFood;
        this.pricesFood = pricesFood;
        this.imgs = imgs;
    }

    public class ViewHolder
    {
        TextView nameFood;
        TextView descriptionFood;
        TextView priceFood;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null)
        {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model, null);
        }

        final ViewHolder holder = new ViewHolder();

        //Initialize our views
        holder.nameFood = (TextView) convertView.findViewById(R.id.nameFood);
        holder.descriptionFood = (TextView) convertView.findViewById(R.id.descriptionFood);
        holder.priceFood = (TextView) convertView.findViewById(R.id.priceFood);
        holder.img = (ImageView) convertView.findViewById(R.id.imageView);

        // Assign data
        holder.img.setImageResource(imgs[position]);
        holder.nameFood.setText(namesFood[position]);
        holder.descriptionFood.setText(descriptionsFood[position]);
        holder.priceFood.setText("S/"+pricesFood[position]);

        //return super.getView(position, convertView, parent);
        return convertView;
    }
}
