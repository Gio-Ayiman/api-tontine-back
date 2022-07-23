package org.group.ventis.emftontine.agence.resource;


import org.group.ventis.emftontine.agence.entity.Agence;
import org.group.ventis.emftontine.agence.service.AgenceService;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/agence/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgenceResource {
    @Inject
    AgenceService agenceService;

    @Path("get/{id}")
    @GET
    public Response getOne(long id) {
        Agence a = agenceService.getOne(id);

        if (a != null) {
            return Response.ok(a).build();
        } else {
            return null;
        }
    }

    @Path("list")
    @GET
    public Response getAll() {
        List<Agence> agences = agenceService.getAll();
        return Response.ok(agences).build();
    }

    @Path("search/{name}")
    @GET
    public Response search(String name) {
        List<Agence> agences = agenceService.search(name);
        return Response.ok(agences).build();
    }

    @POST
    @Path("create")
    public boolean create(Agence agence){
        boolean ok = agenceService.create(agence);
        return ok;
    }

    @PUT
    @Path("/update/{id}")
    public Response update(long id, Agence agence) throws Exceptions {
        Agence a = agenceService.update(id, agence);
        return Response.ok(a).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(long id){
        agenceService.delete(id);
        return Response.ok().build();
    }
}
