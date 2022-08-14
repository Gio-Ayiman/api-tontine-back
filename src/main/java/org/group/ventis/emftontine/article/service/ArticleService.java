package org.group.ventis.emftontine.article.service;

import io.quarkus.logging.Log;
import org.group.ventis.emftontine.article.entity.Article;
import org.group.ventis.emftontine.article.repository.ArticleRespository;
import org.group.ventis.emftontine.dto.ArticleDto;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ArticleService {

    @Inject
    ArticleRespository articleRespository;

    
    @Transactional
    public ArticleDto create(ArticleDto article){
        if (articleRespository.isPersistent(ArticleDto.toEntity(article))){
            return null;
        }else {
            Article a = ArticleDto.toEntity(article);
            articleRespository.persist(a);
            // Log.info("Enregistrement de l'article : " + articleRespository.findById(article.id).id);
            return ArticleDto.fromEntity(a);
        }
    }

    @Transactional
    public ArticleDto update(Long id, ArticleDto article) {
        if (articleRespository.findById(id) != null) {
            ArticleDto a = ArticleDto.fromEntity(articleRespository.findById(id));

            a.description = article.description;
            a.libelle = article.libelle;
            a.prix = article.prix;;

            Log.info("Modification de l'article : " + id);

            return a;
        } else {
            throw new Exceptions.NullEntityId(id);
        }
    }

    public List<ArticleDto> getAllArticles(){
        Log.info("Recuperation de tous les articles");
        return articleRespository.listAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    public ArticleDto getArticle(long id) {
        Article article = articleRespository.findById(id);
        if (article == null) {
            throw new Exceptions.NullEntityId(id);
        } else {
            Log.info("Recuperation de tous les articles");
            return ArticleDto.fromEntity(article);
        }
    }

    public List<ArticleDto> findByKey(String key){
        List<Article> articles = articleRespository.findByKey(key);

        if (articles != null) {
            Log.info("Recuperation de l'article avec la cle: " + key);
            return articles.stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Transactional
    public ArticleDto delete(long id){
        Article a = articleRespository.findById(id);

        if (articleRespository.findById(id).isPersistent()) {
            a.delete();
            Log.info("Supression de l'article : " + id);
            return ArticleDto.fromEntity(a);
        } else throw new Exceptions.NullEntityId(id);
    }


}
