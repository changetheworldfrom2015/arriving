package com.changetheworldfrom2015.arriving.model;
import java.util.Date;

import com.parse.*;

import java.text.*;
/**
 * Created by Pengcheng Song on 8/18/2015.
 */
@ParseClassName("Event")
public class Event extends ParseObject{

    public Event()
    {
        super();
    }
    public String getTitle() {
        return getString("title");
    }
    public String getAddress() {
        return getString("address");
    }
    public String getCity() {
        return getString("city");
    }
    public String getZipcode() {
        return getString("zipcode");
    }
    public String getState() {
        return getString("state");
    }
    public String getDate() {
        Date date;
        date = getDate("date");
        String formatedDate = new SimpleDateFormat("MMM dd").format(date);
        return formatedDate;
    }
    public String getTime() {
        Date date;
        date = getDate("date");
        String formatedDate = new SimpleDateFormat("HH:mm").format(date);
        return formatedDate;
    }
    public String getWeek() {
        return "WED";
    }
    public String getEventID() {
        return getString("EventID");
    }

    public static ParseQuery<Event> createQuery() {
        ParseQuery<Event> query = new ParseQuery<Event>(Event.class);
        query.setCachePolicy(ParseQuery.CachePolicy.CACHE_THEN_NETWORK);
        return query;
    }
}

