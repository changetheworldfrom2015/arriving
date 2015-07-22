package com.changetheworldfrom2015.arriving;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;


public class EventsFragment extends Fragment  implements  AbsListView.OnItemClickListener {

    private ParseQueryAdapter<ParseObject> mainAdapter;
    private AbsListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize main ParseQueryAdapter
        mainAdapter=new
                ParseQueryAdapter<ParseObject>(getActivity().getApplicationContext(),
                "Event");
        mainAdapter.setTextKey("title");
        mainAdapter.setImageKey("photo");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.events, container, false);
        mListView = (AbsListView) view.findViewById(R.id.EventslistView);
        mListView.setAdapter(mainAdapter);
        mainAdapter.loadObjects();
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}