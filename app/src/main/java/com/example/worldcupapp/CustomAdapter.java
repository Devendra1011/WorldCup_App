package com.example.worldcupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CountryModelClass> {
    private ArrayList<CountryModelClass> countryArrayList;
    Context context;

    public CustomAdapter(ArrayList<CountryModelClass> countryArrayList, Context context) {
        super(context, R.layout.list_item_layout,countryArrayList);
        this.countryArrayList = countryArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

         // Get the data item for this position
        CountryModelClass dataModel = getItem(position);


        // Check if an existing view being reused, otherwise inflate the view
        ViewHolder viewHolder;

        final View result;
        if (convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_layout,parent,false);

            viewHolder.tvCountry = (TextView) convertView.findViewById(R.id.tv_country);
            viewHolder.tvWinCount = (TextView) convertView.findViewById(R.id.tv_li_win_count);
            viewHolder.ivFlag = (ImageView) convertView.findViewById(R.id.iv_li_country);


            result = convertView;
            convertView.setTag(viewHolder);

        }else{
        viewHolder = (ViewHolder) convertView.getTag();
        result = convertView;


        }
        // Get the dat from the model class
        viewHolder.tvCountry.setText(dataModel.getCountry_name());
        viewHolder.tvWinCount.setText(dataModel.getWin_count());
        viewHolder.ivFlag.setImageResource(dataModel.getImg_flag());

        return convertView;




    }
    private static class ViewHolder{
        TextView tvCountry,tvWinCount;
        ImageView ivFlag;
    }
}
