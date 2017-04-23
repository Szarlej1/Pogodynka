package com.kokodylapolana.pogodynka.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kokodylapolana.pogodynka.R;
import com.kokodylapolana.pogodynka.weather.Day;

/**
 * Created by Marcin B on 2017-04-18.
 */

public class DayAdapter extends BaseAdapter {
    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }


    @Override
    public int getCount() {

        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; // We aren't going to use this. Tag items for easy reference.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // brand new
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLable = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLable);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLable.setText(day.getTemperatureMax()+ "");

        if(position == 0) {
            holder.dayLabel.setText("dzisiaj");
        } else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }




        return convertView;
    }

    private static class ViewHolder {
        ImageView iconImageView; //public by default
        TextView temperatureLable;
        TextView dayLabel;
    }

}
