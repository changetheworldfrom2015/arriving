package com.changetheworldfrom2015.arriving;

import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;


public class EventsFragment extends Fragment implements  ListView.OnItemClickListener {

    private EventListAdapter mainAdapter;
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize main ParseQueryAdapter
        mainAdapter=new EventListAdapter(getActivity().getApplicationContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.events, container, false);
        mListView = (ListView) view.findViewById(R.id.EventslistView);
        mListView.setAdapter(mainAdapter);
        mainAdapter.loadObjects();
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}