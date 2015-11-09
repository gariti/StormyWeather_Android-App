package io.github.gariti.stormy.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.gariti.stormy.weather.Day;

import static io.github.gariti.stormy.R.*;

/**
 * Created by Garrett Carver on 11/8/2015.
 */
public class DayAdapter extends BaseAdapter {
    //using BaseAdapter rather than ArrayAdapter for educational purposes.
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
        return 0; //we aren't using this.  Keeping it just for educational purposes.  Used to tag items for easy reference
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            //brand new
            convertView = LayoutInflater.from(mContext).inflate(layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(id.dayNameLabel);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];

        holder.iconImageView.setImageResource(day.getIconID());
        holder.temperatureLabel.setText(day.getTemperatureMax() + "");
        if (position == 0) {
            holder.dayLabel.setText("Today");
        } else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }
        return convertView;
    }
    private static class ViewHolder {
        ImageView iconImageView; //public by default
        TextView temperatureLabel;
        TextView dayLabel;
    }
}

