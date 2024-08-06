/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fi.disenio.library.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fi.disenio.rest.model.Visita;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VisitaClient {
    
    private WebTarget webTarget;
    private final String URL_BASE = "http://localhost:8080/rest-app%202/services/museum";
    private Client client;
    
    public VisitaClient(){
        client = ClientBuilder.newClient();
        webTarget = client.target(URL_BASE);
    }
    
    public List<Visita> getSalas(){
        String data = client
                .target(URL_BASE)
                .path("rooms")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        Gson gson = new Gson();
        Type roomList = new TypeToken<ArrayList<Visita>>(){}.getType();
        return gson.fromJson(data, roomList);
    } 
    
    public Visita getSala(String sal){
        return client
                .target(URL_BASE)
                .path("room")
                .path(sal)
                .request(MediaType.APPLICATION_JSON)
                .get(Visita.class);
    }
    
    public String addRoom(Visita room){
       
    return client
            .target(URL_BASE)
            .path("addRoom")
            .request(MediaType.APPLICATION_JSON)
            .accept(MediaType.TEXT_PLAIN)
            .post(Entity.json(room))
            .readEntity(String.class);


    }
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        VisitaClient lc = new VisitaClient();
        //List<Book> books = lc.getLibros();
        
        //System.out.println(books);
        
        Visita newRoom = new Visita("PRUEBA","PRUEBA","PRUEBA","PRUEBA");
        
        String response = lc.addRoom(newRoom);
        System.out.println(response);
        
        
    }
}
