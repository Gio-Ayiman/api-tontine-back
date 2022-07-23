package org.group.ventis.emftontine.typeArticle.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.group.ventis.emftontine.typeArticle.entity.TypeArticle;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TypeArticleRepository implements PanacheRepository<TypeArticle> {
}
