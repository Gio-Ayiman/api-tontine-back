package org.group.ventis.emftontine.article.service;

import io.quarkus.logging.Log;
import org.group.ventis.emftontine.article.entity.ArticleAgence;
import org.group.ventis.emftontine.article.repository.ArticleAgenceRepository;
import org.group.ventis.emftontine.dto.ArticleAgenceDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ArticleAgenceService {

    @Inject
    ArticleAgenceRepository articleAgenceRepository;

    @Transactional
    public ArticleAgence save(ArticleAgenceDto articleAgence) {
        if(articleAgenceRepository.isPersistent(ArticleAgenceDto.toEntity(articleAgence))){
            return null;
        } else {
            articleAgenceRepository.persist(ArticleAgenceDto.toEntity(articleAgence));
            Log.info("Enregistrement de l'article agence " + articleAgenceRepository.findById(articleAgence.id).id);
            return ArticleAgenceDto.toEntity(articleAgence);
        }
    }

    public ArticleAgence get(long id) {
        if (articleAgenceRepository.findById(id).isPersistent())
            return articleAgenceRepository.findById(id);
        else
            return null;
    }
}
