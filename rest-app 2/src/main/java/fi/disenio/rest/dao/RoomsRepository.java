/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.disenio.rest.dao;

import java.util.*;
import fi.disenio.rest.model.Room;

public class RoomsRepository {
    
    private  static List<Room> ROOMS = new ArrayList<>();
    
    static{
        ROOMS.add(new Room("SALA A", "Reflexiones sobre el ser.", "Permanente", "Piso 1 a la izquierda"));
        ROOMS.add(new Room("SALA B", "El laberinto", "Permanente", "Planta baja a la izquierda"));
        ROOMS.add(new Room("SALA C", "Transición en el tiempo", "Permanente", "Piso 1 a la izquierda"));
        ROOMS.add(new Room("SALA D", "Terra Rumoris", "Temporal", "Planta baja a la izquierda"));
        ROOMS.add(new Room("SALA E", "El campo mi manto", "Temporal", "Piso 1 a la derecha"));
    }
    
    public static List<Room> getRooms(){
        return ROOMS;
    }
    
    
    public static Room getRoom(String sal){
        return ROOMS.stream().filter(room -> room.getSal().equals(sal))
                .findFirst().orElse(null);
    }
    
    public static void addRoom(Room room){
        ROOMS.add(room);
    }
    
}
