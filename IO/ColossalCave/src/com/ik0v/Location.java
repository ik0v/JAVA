package com.ik0v;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new LinkedHashMap<String, Integer>();
        this.exits.put("Q", 0);
    }

    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits);
    }

    public String containsExit(String direction) {
        if(direction.toLowerCase().contains("west")) return "W";
        if(direction.toLowerCase().contains("south")) return "S";
        if(direction.toLowerCase().contains("east")) return "E";
        if(direction.toLowerCase().contains("north")) return "N";
        if(direction.toLowerCase().contains("quit")) return "Q";
        return null;

    }
}
