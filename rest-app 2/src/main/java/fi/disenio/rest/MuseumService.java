/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package fi.disenio.rest;

import fi.disenio.rest.model.Room;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;

import fi.disenio.rest.dao.RoomsRepository;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("museum")
@RequestScoped
public class MuseumService {

    @Context
    private UriInfo context;


    /**
     * Retrieves representation of an instance of fi.disenio.rest.LibraryService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        return "{msg: hi}";
    }

    /**
     * PUT method for updating or creating an instance of LibraryService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        System.out.println(content);
    }
    
    @GET
    @Path("/rooms")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Room> getSalas(){
        return RoomsRepository.getRooms();
    }
    
    @GET
    @Path("room/{id}")
    @Produces({MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML})
    public Room getSala(@PathParam("id") String sal){
        return RoomsRepository.getRoom(sal);
    }
    
    @GET
    @Path("room")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Room getSalaQry(@QueryParam("id") String sal){
        return RoomsRepository.getRoom(sal);
    }
    
    @POST
    @Path("addRoom")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String addRoom(
            @FormParam("sal") String sal,
            @FormParam("exp") String exp,
            @FormParam("tem") String tem,
            @FormParam("ubi") String ubi
    ){
        Room room = new Room(sal, exp, tem, ubi);
        RoomsRepository.addRoom(room);
        
        System.out.println("@room added: " + room);
        
        return "ok";
    }
    
    @POST
    @Path("addRoom")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addRoom2(Room room){
        RoomsRepository.addRoom(room);
        System.out.println("@room added: " + room);
        
        return "ok";
    }
}
