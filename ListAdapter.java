package com.example.ratingplaces.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.ratingplaces.R;
import com.example.ratingplaces.model.HPlaces;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    public static final String PREF_FILE = "com.ratingplaces.prefrences";
    ArrayList<HPlaces> datalist;
    Context context;

    public ListAdapter(ArrayList<HPlaces> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if(convertView == null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        }
        ImageView imageView= rowView.findViewById(R.id.itemImageView);
        TextView titleText = rowView.findViewById(R.id.itemTitleTextView);
        TextView ratingText = rowView.findViewById(R.id.itemDesTextView);
        Button itemButton = rowView.findViewById(R.id.itemButton);
        imageView.setImageResource(datalist.get(position).getImageReference());
        titleText.setText(datalist.get(position).gethPlaceName());
        ratingText.setText(String.format("%s : %d",context.getString(R.string.rating),datalist.get(position).getRate()));

       // final HPlaces currentPlace = datalist.get(position);

        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  currentPlace.setRate(currentPlace.getRate() + 1);
                datalist.get(position).setRate(datalist.get(position).getRate() + 1);
                ratingText.setText(String.format("%s : %d",context.getString(R.string.rating),datalist.get(position).getRate()));
                Toast.makeText(context, "The number of the item is : " + position, Toast.LENGTH_SHORT).show();
              //  SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE,Context.MODE_PRIVATE);
               // sharedPreferences.edit().putInt(currentPlace.gethPlaceName(),currentPlace.getRate()).apply();
            }
        });


        return rowView;

    }


}
