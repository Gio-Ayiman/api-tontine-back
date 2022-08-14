package org.group.ventis.emftontine.typeArticle.resource;

import javax.annotation.security.RolesAllowed;

import org.group.ventis.emftontine.dto.TypeArticleDto;
import org.group.ventis.emftontine.typeArticle.service.TypeArticleService;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Path("/api/typeArticle/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeArticleResource {

    @Inject
    TypeArticleService typeArticleService;

    @GET
    @Path("list")
    public List<TypeArticleDto> list(){
        List<TypeArticleDto> typeArticles = typeArticleService.getAllTypesArticle();

        if ( typeArticles.size() > 0 )
            return typeArticles;
        else
            return null;

    }

    @POST
    @Path("create")
//    @RolesAllowed("admin")
    public TypeArticleDto create(TypeArticleDto typeArticle){
        System.out.println("Create");
        TypeArticleDto t =  typeArticleService.create(typeArticle);

        if ( t != null )
            return t;
        else
            return null;
    }

    @GET
    @Path("get/{id}")
    public TypeArticleDto get(long id){
        TypeArticleDto t = typeArticleService.getTypeArticle(id);

        if ( t != null)
            return t;
        else
            return null;
    }

    @GET
    @Path("search/{libelle}")
    public List<TypeArticleDto> search(String libelle){
        List<TypeArticleDto> t = typeArticleService.findByLibelle(libelle);

        if ( t != null )
            return t;
        else
            return null;
    }

    @PUT
    @Path("update/{id}")
    @RolesAllowed("admin")
    public TypeArticleDto update(long id, TypeArticleDto typeArticle) throws Exceptions {

        TypeArticleDto t = typeArticleService.update(id, typeArticle);

        if ( t != null )
            return t;
        else
            return null;
    }

    @DELETE
    @Path("delete/{id}")
    @RolesAllowed("admin")
    public TypeArticleDto delete(long id){
        TypeArticleDto t = typeArticleService.delete(id);

        if ( t != null )
            return t;
        else
            return null;
    }
}
