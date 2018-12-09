package com.example.test.db_project.Custom_Dataset;

public class staff_room_data {
    String room;
    String clean;
    String amenity;
    String avail;

    public staff_room_data(String room, String clean, String amenity, String avail){
        this.room = room;
        this.clean = clean;
        this.amenity = amenity;
        this.avail = avail;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }
}
