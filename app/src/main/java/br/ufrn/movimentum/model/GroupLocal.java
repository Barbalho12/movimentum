package br.ufrn.movimentum.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupLocal implements Serializable {

    public class Coord implements Serializable{
        double lat;
        double lng;

        public Coord(double latitude, double longitude) {
            lat = latitude;
            lng = longitude;
        }
    }

    private String name;
    private List<Coord> coords;

    public GroupLocal(String name) {
        this.name = name;
    }

    public List<LatLng> getLatLng(){
        List<LatLng> latLng = new ArrayList<>();
        for (Coord c : coords){
            latLng.add(new LatLng(c.lat, c.lng));
        }
        return latLng;
    }



    public GroupLocal(String name, List<Coord> coords) {
        this.name = name;
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Coord> getCoords() {
        return coords;
    }

    public void setCoords(List<Coord> coords) {
        this.coords = coords;
    }

    public void  setLatLng(List<LatLng> latLng){
        coords = new ArrayList<>();
        for (LatLng l : latLng){
            coords.add(new Coord(l.latitude, l.longitude));
        }
    }
}
