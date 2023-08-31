/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dann-dev
 */
public class Room {

    private int id_room;
    private String room_number;
    private String room_type;
    private int capacity;
    private double price_per_night;
    private String image_url;


    
    /**
     * Constructor encargado de traer las habitaciones de la base de datos, actualizar 
     * @param id_room
     * @param room_number
     * @param room_type
     * @param capacity
     * @param price_per_night 
     * @param image_url 
     */

    public Room(int id_room, String room_number, String room_type, int capacity, double price_per_night, String image_url) {
        this.id_room = id_room;
        this.room_number = room_number;
        this.room_type = room_type;
        this.capacity = capacity;
        this.price_per_night = price_per_night;
        this.image_url = image_url;
    }
    /**
     * Segundo constructor encargado de agregar una habitacion
     * @param room_number
     * @param room_type
     * @param capacity
     * @param price_per_night 
     * @param image_url 
     */
    public Room(String room_number, String room_type, int capacity, double price_per_night, String image_url) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.capacity = capacity;
        this.price_per_night = price_per_night;
        this.image_url = image_url;
    }
    
       
    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(double price_per_night) {
        this.price_per_night = price_per_night;
    }
        public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id_room=" + id_room + ", room_number=" + room_number + ", room_type=" + room_type + ", capacity=" + capacity + ", price_per_night=" + price_per_night + '}';
    }

}
