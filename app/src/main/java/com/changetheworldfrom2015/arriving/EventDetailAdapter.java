package com.changetheworldfrom2015.arriving;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by qiucenzhang on 7/19/15.
 */
public class EventDetailAdapter extends ParseQueryAdapter<ParseObject> {
    public EventDetailAdapter(Context context) {
        // Use the QueryFactory to construct a PQA that will only show
        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("Todo");
                return query;
            }
        });
    }

    // Customize the layout by overriding getItemView
    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if (v == null) {
            v = View.inflate(getContext(), R.layout.event_detail, null);
        }

        super.getItemView(object, v, parent);

        // Add the title view
        TextView eventDetailView = (TextView) v.findViewById(R.id.event_detail_text);

        eventDetailView.setText(object.getString("title") + " "
                + object.getString("address_City") + " "
                + object.getString("address_State"));

        return v;
    }
}
