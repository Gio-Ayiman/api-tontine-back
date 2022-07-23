package org.group.ventis.emftontine.article.service;

import org.group.ventis.emftontine.agence.entity.Agence;
import org.group.ventis.emftontine.article.entity.Article;
import org.group.ventis.emftontine.article.repository.ArticleRespository;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ArticleService {

    @Inject
    ArticleRespository articleRespository;

    
    @Transactional
    public boolean create(Article article){
        if (articleRespository.isPersistent(article)){
            return false;
        }else {
            articleRespository.persist(article);
            return true;
        }
    }

    @Transactional
    public Article update(Long id, Article article) throws Exceptions {
        if (articleRespository.findById(id) != null) {
            Article a = articleRespository.findById(id);

            a.description = article.description;
            a.libelle = article.libelle;
            a.prix = article.prix;;

            return a;
        } else {
            throw new Exceptions();
        }
    }

    public List<Article> getAllArticles(){
        return articleRespository.listAll();
    }

    public Article getArticle(long id) {
        Article article = articleRespository.findById(id);
        if (article == null) {
            return null;
        } else {
            return article;
        }
    }

    public List<Article> findByKey(String key){
        List<Article> articles = articleRespository.findByKey(key);
        return articles;
    }

    @Transactional
    public void delete(long id){
        Article a = articleRespository.findById(id);
        a.delete();
    }
}
