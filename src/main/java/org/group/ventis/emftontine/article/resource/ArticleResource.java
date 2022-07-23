package org.group.ventis.emftontine.article.resource;


import org.group.ventis.emftontine.article.entity.Article;
import org.group.ventis.emftontine.article.service.ArticleService;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api/article/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArticleResource {

    @Inject
    ArticleService articleService;

    @GET
    @Path("list")
    public List<Article> list(){
        return articleService.getAllArticles();
    }

    @POST
    @Path("create")
    public Response create(Article article){
        articleService.create(article);
        return Response.ok().build();
    }

    @GET
    @Path("search/{key}")
    public List<Article> search(String key){
        return articleService.findByKey(key);
    }

    @PUT
    @Path("update/{id}")
    public Article update(long id, Article article) throws Exceptions {
        return articleService.update(id, article);
    }

    @DELETE
    @Path("delete/{id}")
    public Response delete(long id){
        articleService.delete(id);
        return Response.ok().build();
    }
}
