package org.group.ventis.emftontine.agence.service;
import io.quarkus.logging.Log;

import org.group.ventis.emftontine.article.entity.ArticleAgence;
import org.group.ventis.emftontine.article.service.ArticleAgenceService;
import org.group.ventis.emftontine.dto.AgenceDto;
import org.group.ventis.emftontine.utils.Exceptions;
import org.group.ventis.emftontine.agence.entity.Agence;
import org.group.ventis.emftontine.agence.repository.AgenceRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AgenceService{

    @Inject
    AgenceRepository agenceRepository;

    @Inject
    ArticleAgenceService articleAgenceService;


    public AgenceDto getOne(long id) {
        AgenceDto agence = AgenceDto.fromEntity(agenceRepository.findById(id));

        if (agence == null) {
            throw new Exceptions.NullEntityId(id);
        } else {
            Log.info("Recuperation de l'agence : " + agenceRepository.findById(id).id);
            return agence;
        }
    }

    public List<AgenceDto> getAll(){
        Log.info("Recuperation de toutes les agences");
        return agenceRepository.listAll()
                .stream()
                .map(AgenceDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<AgenceDto> search(String name) {
        List<Agence> a = agenceRepository.find("name", name).list();

        if (a != null ) {
            Log.info("Recherche de l'agence " + name);
            return a.stream().map(AgenceDto::fromEntity).collect(Collectors.toList());
        } else return null;
    }

    @Transactional
    public AgenceDto create(AgenceDto agence){
        if(agenceRepository.isPersistent(AgenceDto.toEntity(agence))) {
            return null;
        } else {
            Agence a = AgenceDto.toEntity(agence);
            agenceRepository.persist(a);
            Log.info("Enregistrement de l'agence " + agenceRepository.findById(agence.id).id);
            return AgenceDto.fromEntity(a);
        }
    }


    @Transactional
    public AgenceDto update(long id, AgenceDto agence) {
        if (agenceRepository.findById(id) != null) {
            AgenceDto a = AgenceDto.fromEntity(agenceRepository.findById(id));

            a.codeAgence = agence.codeAgence;
            a.name = agence.name;
            a.RIBCompteDepot = agence.RIBCompteDepot;
            a.statut = agence.statut;

            Log.info("Modification de l'agence : " + id);
            return a;
        } else {
           throw new Exceptions.NullEntityId(id);
        }
    }

    @Transactional
    public AgenceDto delete(long id){
        AgenceDto a = AgenceDto.fromEntity(agenceRepository.findById(id));

        if ( agenceRepository.findById(id).isPersistent() ) {
            agenceRepository.delete(AgenceDto.toEntity(a));
            Log.info("Supression de l'agence : " + id);
            return a;
        } else {
            throw new Exceptions.NullEntityId(id);
        }

    }

    @Transactional
    public void setArticle(long id, AgenceDto agence) {

        ArticleAgence a =  articleAgenceService.get(id);

        if ( a != null ){
            Log.info("Ajout de l'article : " + a.id);
            Agence agence1 = AgenceDto.toEntity(agence);
            agence1.articleAgences.add(a);
        }
    }
}
