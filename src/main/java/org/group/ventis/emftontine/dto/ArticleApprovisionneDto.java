package org.group.ventis.emftontine.dto;

import java.util.ArrayList;
import java.util.List;

import org.group.ventis.emftontine.stock.entity.ArticleApprovisionne;

public class ArticleApprovisionneDto {

    public Long id;
    public int quantite;

    public ApprovisionnementDto appro;

    public ArticleDto article;

    public static ArticleApprovisionneDto fromEntity(ArticleApprovisionne articleApprovisionne){
        ArticleApprovisionneDto articleApprovisionneDto = new ArticleApprovisionneDto();

        if (articleApprovisionne == null) {
            return null;
        } else {
            articleApprovisionneDto.id = articleApprovisionne.id;
            articleApprovisionneDto.quantite = articleApprovisionneDto.quantite;
            articleApprovisionneDto.appro = ApprovisionnementDto.fromEntity(articleApprovisionne.approvisionnement);
            articleApprovisionneDto.article = ArticleDto.fromEntity(articleApprovisionne.article);

            return articleApprovisionneDto;
        }
    }

    public static ArticleApprovisionne toEntity(ArticleApprovisionneDto articleApprovisionneDto) {
        ArticleApprovisionne articleApprovisionne = new ArticleApprovisionne();

        if (articleApprovisionneDto == null) {
            return null;
        } else {
            articleApprovisionne.id = articleApprovisionneDto.id;
            articleApprovisionne.quantite = articleApprovisionneDto.quantite;
            articleApprovisionne.article = ArticleDto.toEntity(articleApprovisionneDto.article);
            articleApprovisionne.approvisionnement = ApprovisionnementDto.toEntity(articleApprovisionneDto.appro);

            return articleApprovisionne;
        }
    }

    public static List<ArticleApprovisionneDto> FromEntity(List<ArticleApprovisionne> articleApprovisionnes) {  
        List<ArticleApprovisionneDto> articleApprovisionneDtos = new ArrayList<>();
        
        if (articleApprovisionnes.size() < 1)
            return null;

        for (ArticleApprovisionne articleApprovisionne : articleApprovisionnes) {
            articleApprovisionneDtos.add(fromEntity(articleApprovisionne));
        }
        
        return articleApprovisionneDtos;
    }

    public static List<ArticleApprovisionne> toEntity(List<ArticleApprovisionneDto> articleApprovisionneDtos) {
        List<ArticleApprovisionne> articleApprovisionnes = new ArrayList<>();

        if ( articleApprovisionneDtos.size() < 1 )
            return null;
        
        for (ArticleApprovisionneDto articleApprovisionneDto : articleApprovisionneDtos) {
            articleApprovisionnes.add(toEntity(articleApprovisionneDto));
        }

        return null;
    }
}
