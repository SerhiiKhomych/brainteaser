package com.rhcloud.controllers;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Created by Sergey on 24.05.2015.
 */
@Named("event")
@ApplicationScoped
public class Event {
    private String time;
    private String date;
    private MapModel map;

    @PostConstruct
    public void init() {
        time = "16:30";
        date = "30.05.2015";
        map = new DefaultMapModel();

        //Shared coordinates
        LatLng coord = new LatLng(50.450717, 30.529723);
        //Basic marker
        map.addOverlay(new Marker(coord, "Stadium"));
    }

    public MapModel getMap() {
        return map;
    }

    public void setMap(MapModel map) {
        this.map = map;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
