package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAp extends BaseAdapter {
    Context context;
    ArrayList<Weather> arrayList;

    public CustomAp(Context context, ArrayList<Weather> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.dong_listview,null);
        Weather weather = arrayList.get(i);
        TextView txtDay = (TextView) convertView.findViewById(R.id.tvdate);
        TextView txtStt = (TextView) convertView.findViewById(R.id.tvTrangthai);
        TextView txtMax = (TextView)convertView.findViewById(R.id.tvMax);
        TextView txtMin = (TextView) convertView.findViewById(R.id.tvHum );
        ImageView imageViewStt = (ImageView) convertView.findViewById(R.id.imvtrangthai);

        txtDay.setText(weather.day);
        txtStt.setText(weather.Status);
        txtMax.setText(weather.Max  +"°C");
        txtMin.setText(weather.Hum+"%");

        Picasso.with(context).load("http://openweathermap.org/img/w/"+weather.Image+".png").into(imageViewStt);
        return convertView;
    }
}
