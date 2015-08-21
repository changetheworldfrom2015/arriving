package com.changetheworldfrom2015.arriving;
import android.text.format.Time;
import java.text.DateFormat;
import com.parse.*;

/**
 * Created by Pengcheng Song on 8/18/2015.
 */

@ParseClassName("Event")
public class Event extends ParseObject{

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
        return "Apr 10";
    }
    public String getTime() {
        return "11:12";
    }
    public String getWeek() {
        return "WED";
    }
    public String getEventID() {
        return getString("EventID");
    }
}
