package com.changetheworldfrom2015.arriving.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.changetheworldfrom2015.arriving.R;
import com.changetheworldfrom2015.arriving.model.Event;

/**
 * Created by fengjingyu on 8/18/2015.
 */
public class EventListAdapter extends ArrayAdapter<Event> {
    private LayoutInflater mInflater;
    private static final int mResource = R.layout.event_list;
    //listType 0:All Event, 1:Host Event, 2:Nearby Event
    private int listType;
    public EventListAdapter(Context context,int type) {
            // Use the QueryFactory to construct a PQA that will only show
                super(context,mResource);
                listType = type;
                mInflater = (LayoutInflater) getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
}

        // Customize the layout by overriding getItemView
      @Override
        public View getView(int position, View v, ViewGroup parent) {
            ViewHolder holder;
            View view;
            final Event object = getItem(position);
            if (v == null) {
                view = mInflater.inflate(mResource, parent, false);
                // Cache view components into the view holder
                holder = new ViewHolder();
                holder.timeView = (TextView) view.findViewById(R.id.time);
                holder.titleView = (TextView) view.findViewById(R.id.title);
                holder.dateView = (TextView) view.findViewById(R.id.date);
                holder.weekView = (TextView) view.findViewById(R.id.week);
                // Tag for lookup later
                view.setTag(holder);
            } else {
                view=v;
                holder = (ViewHolder) view.getTag();
            }
                // Add the title view
                TextView eventDateView = holder.dateView;
                eventDateView.setText(object.getDate());
                TextView eventTitleView = holder.titleView;
                eventTitleView.setText(object.getTitle());
                TextView eventWeekView = holder.weekView;
                eventWeekView.setText(object.getWeek());
                TextView eventTimeView = holder.timeView;
                eventTimeView.setText(object.getTime());
            return view;
        }

        private static class ViewHolder {
            LinearLayout eventLayout;
            TextView timeView;
            TextView titleView;
            TextView dateView;
            TextView weekView;
        }
    }