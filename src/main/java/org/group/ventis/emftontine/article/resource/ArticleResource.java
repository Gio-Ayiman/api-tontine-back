package org.group.ventis.emftontine.article.resource;

import javax.annotation.security.RolesAllowed;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.group.ventis.emftontine.article.service.ArticleService;
import org.group.ventis.emftontine.dto.ArticleDto;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


import static javax.ws.rs.core.Response.Status.*;

@Path("/api/article/")
@Tag(name = "Article Resource", description = "APIs REST pour Article")
public class ArticleResource {

    @Inject
    ArticleService articleService;


    @GET
    @Path("list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "list",
            summary = "Recuperer la liste des articles",
            description = "Recuperer les aarticles de la base de donnee"
    )
    @APIResponses(
            value = {
              @APIResponse(
                    responseCode = "200",
                    description = "Operation reussie",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON)
              ),
              @APIResponse(
                    responseCode = "404",
                  description = "Article not found"
              )
            }
    )
    public Response list(){
        List<ArticleDto> articles = articleService.getAllArticles();

        if (articles != null)
            return Response.ok(articles).build();
        else
            return Response.status(NOT_FOUND).build();

    }

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "create",
            summary = "Creer un article",
            description = "Enregistrer un article dans la base de donnee"
    )
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Operation reussie",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Mauvaise requete"
                    )
            }
    )
//    @RolesAllowed("admin")
    public ArticleDto create(ArticleDto dto){
        ArticleDto a = articleService.create(dto);
        if(a != null)
            return a;
        else
            return null;

    }

    @GET
    @Path("search/{key}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "search",
            summary = "Recuperer un article de la liste",
            description = "Recuperer un article avec un  mot cle de de la base de donnee"
    )
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Operation reussie",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                    ),
                    @APIResponse(
                            responseCode = "404",
                            description = "Article not found"
                    )
            }
    )
    public List<ArticleDto> search(String key){
        List<ArticleDto> articles = articleService.findByKey(key);

        if (articles != null)
            return articles;
        else
            return null;

    }

    @GET
    @Path("get/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "get",
            summary = "Recuperer un article de la liste",
            description = "Recuperer un article de la base de donnee"
    )
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Operation reussie",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                    ),
                    @APIResponse(
                            responseCode = "404",
                            description = "Article not found"
                    )
            }
    )
    public ArticleDto getOne(long id){
        ArticleDto article = articleService.getArticle(id);

        if (article != null)
            return article;
        else
            return null;

    }

    @PUT
    @Path("update/{id}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "update",
            summary = "Modifier un article",
            description = "Modifier un article de la base de donnee"
    )
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Operation reussie",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Mauvaise requete"
                    )
            }
    )
    public ArticleDto update(long id, ArticleDto dto) throws Exceptions {
        ArticleDto a = articleService.update(id, dto);

        if (a != null )
            return a;
        else
            return null;

    }

    @DELETE
    @Path("delete/{id}")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "delete",
            summary = "Supprimer un article",
            description = "Supprimer un article de la base de donnee"
    )
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Operation reussie",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Mauvaise requete"
                    )
            }
    )
    public ArticleDto delete(long id){
        ArticleDto article = articleService.delete(id);

        if (article != null)
            return article;
        else
            return null;

    }
}
