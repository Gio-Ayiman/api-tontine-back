package org.group.ventis.emftontine.stock.service;

import io.quarkus.logging.Log;
import org.group.ventis.emftontine.dto.ArticleApprovisionneDto;
import org.group.ventis.emftontine.stock.entity.Approvisionnement;
import org.group.ventis.emftontine.dto.ApprovisionnementDto;
import org.group.ventis.emftontine.stock.entity.ArticleApprovisionne;
import org.group.ventis.emftontine.stock.repository.ApprovisionnementRepository;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ApprovisionnementService {

    @Inject
    ApprovisionnementRepository approvisionnementRepository;

    @Inject
    ArticleApprovisionneService articleApprovisionneService;

    @Transactional
    public ApprovisionnementDto create(ApprovisionnementDto approvisionnementDto){

        Approvisionnement a = ApprovisionnementDto.toEntity(approvisionnementDto);

        if (approvisionnementRepository.isPersistent(a)){
            return null;
        }else {
            for ( ArticleApprovisionneDto articleApprovisionne : approvisionnementDto.items) {
                articleApprovisionneService.save(articleApprovisionne);
          }
            approvisionnementRepository.persist(a);

            Log.info("Enregistrement de l'approvisionnement : " + approvisionnementRepository.findById(a.id).id);
            return ApprovisionnementDto.fromEntity(a);
        }
    }

    @Transactional
    public ApprovisionnementDto update(Long id, ApprovisionnementDto approvisionnement) {
        if (approvisionnementRepository.findById(id) != null) {
            Approvisionnement a = approvisionnementRepository.findById(id);

            a.etat = approvisionnement.etat;
//            a.articleApprovisionnes = ApprovisionnementDto.toEntity(approvisionnement.items);

            Log.info("Modification de l'approvisionnement : " + id);

            return ApprovisionnementDto.fromEntity(a);
        } else {
            throw new Exceptions.NullEntityId(id);
        }
    }

    public List<ApprovisionnementDto> getAllApprovisionnement(){
        Log.info("Recuperation de tous les approvisionnement");
        return approvisionnementRepository.listAll().stream().map(ApprovisionnementDto::fromEntity).collect(Collectors.toList());
    }

    public ApprovisionnementDto getApprovisionnement(long id) {
        Approvisionnement a = approvisionnementRepository.findById(id);
        if (a == null) {
            throw new Exceptions.NullEntityId(id);
        } else {
            Log.info("Recuperation de l'approvisionnement");
            return ApprovisionnementDto.fromEntity(a);
        }
    }


    @Transactional
    public ApprovisionnementDto delete(long id){
        Approvisionnement a = approvisionnementRepository.findById(id);

        if (approvisionnementRepository.findById(id).isPersistent()) {
            a.delete();
            Log.info("Supression de l'approvisionnement : " + id);
            return ApprovisionnementDto.fromEntity(a);
        } else throw new Exceptions.NullEntityId(id);
    }
}
