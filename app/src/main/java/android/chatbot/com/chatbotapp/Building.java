package android.chatbot.com.chatbotapp;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by razva on 2017-12-02.
 */

public class Building {
    private String name;
    private String address;
    private LatLng coords;

    public Building(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Building(String name, String address, LatLng coords) {
        this.name = name;
        this.address = address;
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LatLng getCoords() {
        return coords;
    }

    public void setCoords(LatLng coords) {
        this.coords = coords;
    }
}
