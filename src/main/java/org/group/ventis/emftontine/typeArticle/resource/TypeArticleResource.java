package org.group.ventis.emftontine.typeArticle.resource;

import org.group.ventis.emftontine.article.entity.Article;
import org.group.ventis.emftontine.typeArticle.entity.TypeArticle;
import org.group.ventis.emftontine.typeArticle.service.TypeArticleService;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api/typeArticle/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeArticleResource {

    @Inject
    TypeArticleService typeArticleService;

    @GET
    @Path("list")
    public List<TypeArticle> list(){
        return typeArticleService.getAllTypesArticle();
    }

    @POST
    @Path("create")
    public Response create(TypeArticle typeArticle){
        typeArticleService.create(typeArticle);
        return Response.ok().build();
    }

    @GET
    @Path("search/{libelle}")
    public List<TypeArticle> search(String libelle){
        return typeArticleService.findByLibelle(libelle);
    }

    @PUT
    @Path("update/{id}")
    public TypeArticle update(long id, TypeArticle typeArticle) throws Exceptions {
        return typeArticleService.update(id, typeArticle);
    }

    @DELETE
    @Path("delete/{id}")
    public Response delete(long id){
        typeArticleService.delete(id);
        return Response.ok().build();
    }
}
