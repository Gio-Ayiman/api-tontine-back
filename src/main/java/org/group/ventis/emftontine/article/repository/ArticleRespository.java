package org.group.ventis.emftontine.article.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.group.ventis.emftontine.article.entity.Article;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ArticleRespository implements PanacheRepository<Article> {
    public List<Article> findByKey(String key) {
        return find("libelle", key).list();
    }
}
