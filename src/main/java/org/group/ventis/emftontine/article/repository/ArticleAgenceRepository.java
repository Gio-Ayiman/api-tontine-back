package org.group.ventis.emftontine.article.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.group.ventis.emftontine.article.entity.ArticleAgence;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArticleAgenceRepository implements PanacheRepository<ArticleAgence> {
}
