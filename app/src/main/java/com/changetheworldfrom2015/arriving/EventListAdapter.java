package com.changetheworldfrom2015.arriving;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.Date;

/**
 * Created by fengjingyu on 8/18/2015.
 */
public class EventListAdapter extends ParseQueryAdapter<Event> {

        public EventListAdapter(Context context) {
            // Use the QueryFactory to construct a PQA that will only show
            super(context, new ParseQueryAdapter.QueryFactory<Event>() {
                public ParseQuery create() {
                    ParseQuery query = new ParseQuery("Event");
                    return query;
                }
            });
        }

        // Customize the layout by overriding getItemView
/*       @Override
        public View getItemView(Event object, View v, ViewGroup parent) {
            ViewHolder holder;
            if (v == null) {
                v = View.inflate(getContext(),R.layout.event_list,null);
                // Cache view components into the view holder
                holder = new ViewHolder();
                holder.eventLayout = (LinearLayout) v.findViewById(R.id.event_item);
                holder.timeView = (TextView) v.findViewById(R.id.time);
                holder.titleView = (TextView) v.findViewById(R.id.title);
                holder.dateView = (TextView) v.findViewById(R.id.date);
                holder.weekView = (TextView) v.findViewById(R.id.week);
                // Tag for lookup later
                v.setTag(holder);
            } else {
                holder = (ViewHolder) v.getTag();
            }
           super.getItemView(object,v,parent);
                // Add the title view
                TextView eventDateView = holder.dateView;
                eventDateView.setText(object.getDate());
                TextView eventTitleView = holder.titleView;
                eventTitleView.setText(object.getTitle());
                TextView eventWeekView = holder.weekView;
                eventWeekView.setText(object.getWeek());
                TextView eventTimeView = holder.timeView;
                eventTimeView.setText(object.getTime());
            return v;
        }*/

        private static class ViewHolder {
            LinearLayout eventLayout;
            TextView timeView;
            TextView titleView;
            TextView dateView;
            TextView weekView;
        }
    }