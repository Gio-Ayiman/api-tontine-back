package org.group.ventis.emftontine.dto;

import org.group.ventis.emftontine.stock.entity.ArticleAgenceApprovisionne;


public class ArticleAgenceApprovisionneDto {

    public Long id;
    public int quantite;

    public ApprovisionnementDto approvisionnement;

    public ArticleAgenceDto articleAgence;

    public static ArticleAgenceApprovisionneDto fromEntity(ArticleAgenceApprovisionne articleAgenceApprovisionne){
        ArticleAgenceApprovisionneDto articleAgenceApprovisionneDto = new ArticleAgenceApprovisionneDto();

        if ( articleAgenceApprovisionne == null) {
            return null;
        } else {
            articleAgenceApprovisionneDto.id = articleAgenceApprovisionne.id;
            articleAgenceApprovisionneDto.quantite = articleAgenceApprovisionne.quantite;
            articleAgenceApprovisionneDto.approvisionnement = ApprovisionnementDto.fromEntity(articleAgenceApprovisionne.approvisionnement);
            return articleAgenceApprovisionneDto;
        }
    }

    public static ArticleAgenceApprovisionne toEntity(ArticleAgenceApprovisionneDto articleAgenceApprovisionneDto) {
        ArticleAgenceApprovisionne articleAgenceApprovisionne = new ArticleAgenceApprovisionne();

        if (articleAgenceApprovisionneDto == null ) {
            return null;
        } else {
            articleAgenceApprovisionne.id = articleAgenceApprovisionneDto.id;
            articleAgenceApprovisionne.quantite = articleAgenceApprovisionneDto.quantite;
            articleAgenceApprovisionne.approvisionnement = ApprovisionnementDto.toEntity(articleAgenceApprovisionneDto.approvisionnement);
            return articleAgenceApprovisionne;
        }
    }

}
