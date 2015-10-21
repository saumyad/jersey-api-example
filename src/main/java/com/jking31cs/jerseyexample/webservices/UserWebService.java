package com.jking31cs.jerseyexample.webservices;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jking31cs.jerseyexample.objects.User;
import com.jking31cs.jerseyexample.stores.UserStore;

/**
 * This web service handles all the different http calls from a client to create, read, update, and delete TodoLists.
 * This is done using Jersey/JAX-RS (Java Application Rest Service API).
 */
@Path("api/user")
public class UserWebService {

    private final UserStore ustore;

    @Inject
    public UserWebService(UserStore ustore) {
        this.ustore = ustore;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return ustore.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User get(@PathParam("id") Long id) {
        return ustore.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(User user) {
        return ustore.save(user);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(@PathParam("id") Long id, User user) {
        return ustore.save(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User delete(@PathParam("id") Long id) throws Exception {
        try {
            User user = ustore.get(id);
            return ustore.delete(user);
        }
        catch (Exception e){
            throw e;
        }
        
    }
}
