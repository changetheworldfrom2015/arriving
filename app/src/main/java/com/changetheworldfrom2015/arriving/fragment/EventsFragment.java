package com.changetheworldfrom2015.arriving.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.changetheworldfrom2015.arriving.model.Event;
import com.changetheworldfrom2015.arriving.activity.EventDetailActivity;
import com.changetheworldfrom2015.arriving.adapter.EventListAdapter;
import com.changetheworldfrom2015.arriving.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;


public class EventsFragment extends Fragment {

    private EventListAdapter mainAdapter;
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.events, container, false);
        int listType = 0;
        // Initialize main ParseQueryAdapter
        mainAdapter=new EventListAdapter(getActivity().getApplicationContext(),listType);
        ParseQuery<Event> query = Event.createQuery();
        query.whereEqualTo("type", 0);
        query.findInBackground(new FindCallback<Event>() {
            public void done(List<Event> eventList, ParseException e) {
                if (e == null) {
                    mainAdapter.clear();
                    for (Event object : eventList) {
                        mainAdapter.add(object);
                    }
                } else {
                    Log.d("event", "Error: " + e.getMessage());
                }
            }
        });
        mListView = (ListView) view.findViewById(R.id.eventsListView);
        mListView.setAdapter(mainAdapter);
        mListView.setOnItemClickListener(new ListView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                 Event event = mainAdapter.getItem(position);
                                                 openEventDetailView(event);
                                             }
                                         }
            );
            return view;
        }

    public void openEventDetailView(Event event) {
        Intent intent = new Intent(getActivity(),EventDetailActivity.class);
        //intent.setData(event.getUri());
        startActivity(intent);
    }
}