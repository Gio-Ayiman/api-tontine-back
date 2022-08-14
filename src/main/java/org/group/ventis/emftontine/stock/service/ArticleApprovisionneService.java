package org.group.ventis.emftontine.stock.service;

import io.quarkus.logging.Log;
import org.group.ventis.emftontine.agence.entity.Agence;
import org.group.ventis.emftontine.agence.repository.AgenceRepository;
import org.group.ventis.emftontine.article.entity.Article;
import org.group.ventis.emftontine.dto.ArticleAgenceApprovisionneDto;
import org.group.ventis.emftontine.dto.ArticleApprovisionneDto;
import org.group.ventis.emftontine.stock.entity.Approvisionnement;
import org.group.ventis.emftontine.stock.entity.ArticleApprovisionne;
import org.group.ventis.emftontine.stock.repository.ArticleApprovisionneRepository;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ArticleApprovisionneService {

    @Inject
    public ArticleApprovisionneRepository articleApprovisionneRepository;

    @Transactional
    public ArticleApprovisionneDto save(ArticleApprovisionneDto a) {
//        System.out.println("PERSISTENCE");
        ArticleApprovisionne articleApprovisionne = ArticleApprovisionneDto.toEntity(a);

        if (articleApprovisionneRepository.isPersistent(articleApprovisionne)){
//            System.out.println("FAILED");
            return a;}
        else{
            articleApprovisionneRepository.persist(articleApprovisionne);
//            System.out.println("OK");
            return ArticleApprovisionneDto.fromEntity(articleApprovisionne);
        }
    }

    public void delete(ArticleApprovisionneDto articleApprovisionne){
        articleApprovisionneRepository.delete(ArticleApprovisionneDto.toEntity(articleApprovisionne));
    }

    public List<ArticleApprovisionneDto> getAll() {
        return articleApprovisionneRepository.listAll()
                .stream()
                .map(ArticleApprovisionneDto::fromEntity)
                .collect(Collectors.toList());
    }

    public ArticleApprovisionneDto getOne(long id) {
        ArticleApprovisionneDto a = ArticleApprovisionneDto.fromEntity(articleApprovisionneRepository.findById(id));

        if (a == null) {
            throw new Exceptions.NullEntityId(id);
        } else {
            Log.info("Recuperation de l'article approvisionne : " + articleApprovisionneRepository.findById(id).id);
            return a;
        }
    }
}
