package org.group.ventis.emftontine.agence.resource;

import javax.annotation.security.RolesAllowed;

import org.group.ventis.emftontine.agence.entity.Agence;
import org.group.ventis.emftontine.agence.service.AgenceService;
import org.group.ventis.emftontine.dto.AgenceDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api/agence/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgenceResource {
    @Inject
    AgenceService agenceService;

    @Path("get/{id}")
    @GET
    public AgenceDto getOne(long id) {
        Agence a = AgenceDto.toEntity(agenceService.getOne(id));

        if (a != null)
            return AgenceDto.fromEntity(a);
        else
            return null;

    }

    @Path("list")
    @GET
    public List<AgenceDto> getAll() {
        List<AgenceDto> agences = agenceService.getAll();

        if(agences != null)
            return agences;
        else
            return null;

    }

    @Path("search/{name}")
    @GET
    public List<AgenceDto> search(String name) {
        List<AgenceDto> agences = agenceService.search(name);

        if ( agences.size() > 0)
            return agences;
        else
            return null;

    }

    @POST
    @Path("create")
    @RolesAllowed("admin")
    public AgenceDto create(AgenceDto agence){
        Agence a = AgenceDto.toEntity(agenceService.create(agence));

        if ( a != null )
            return AgenceDto.fromEntity(a);
        else
            return null;

    }

    @PUT
    @Path("update/{id}")
    @RolesAllowed("admin")
    public AgenceDto update(long id, AgenceDto agence) {
        Agence a = AgenceDto.toEntity(agenceService.update(id, agence));

        if (a !=null)
            return AgenceDto.fromEntity(a);
        else
            return null;

    }

    @DELETE
    @Path("delete/{id}")
    @RolesAllowed("admin")
    public AgenceDto delete(long id){
        Agence a = AgenceDto.toEntity(agenceService.delete(id));

        if (a != null)
            return AgenceDto.fromEntity(a);
        else
            return null;
    }

    @PUT
    @Path("add-article/{id}")
//    @RolesAllowed("admin")
    public void addArticle(long id, AgenceDto agence) {
        agenceService.setArticle(id, agence);
    }
}
