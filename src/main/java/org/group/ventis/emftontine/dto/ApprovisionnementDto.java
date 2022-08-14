package org.group.ventis.emftontine.dto;

import org.group.ventis.emftontine.stock.entity.Approvisionnement;

import java.time.LocalDateTime;
import java.util.List;

public class ApprovisionnementDto {

    public Long id;
    public String etat;
    public LocalDateTime dateAppro;

    public List<ArticleApprovisionneDto> items;

    public static ApprovisionnementDto fromEntity(Approvisionnement approvisionnement){
        ApprovisionnementDto approvisionnementDto = new ApprovisionnementDto();


        if (approvisionnement == null) {
            return null;
        } else {
            approvisionnementDto.id = approvisionnement.id;
            approvisionnementDto.dateAppro = approvisionnement.dateAppro;
            approvisionnementDto.etat = approvisionnement.etat;

            return approvisionnementDto;
        }


    }

    public static Approvisionnement toEntity(ApprovisionnementDto approvisionnementDto) {
        Approvisionnement approvisionnement = new Approvisionnement();

        if (approvisionnementDto == null) {
            return null;
        } else {
            approvisionnement.etat = approvisionnementDto.etat;
            approvisionnement.dateAppro = approvisionnementDto.dateAppro;

            return approvisionnement;
        }
    }
}
