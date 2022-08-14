package org.group.ventis.emftontine.dto;


import org.group.ventis.emftontine.article.entity.ArticleAgence;

import java.util.List;

public class ArticleAgenceDto {

    public Long id;
    public double prix;

    public int quantite;

    public int seuil;

    public ArticleDto article;

    public AgenceDto agence;

    public List<ArticleAgenceApprovisionneDto> articleAgenceApprovisionnes;

    public static ArticleAgenceDto fromEntity(ArticleAgence articleAgence) {
        ArticleAgenceDto articleAgenceDto = new ArticleAgenceDto();

        if (articleAgence == null) {
            return null;
        } else {
            articleAgenceDto.id = articleAgence.id;
            articleAgenceDto.prix = articleAgence.prix;
            articleAgenceDto.quantite = articleAgence.quantite;
            articleAgenceDto.seuil = articleAgence.seuil;
            articleAgenceDto.article = ArticleDto.fromEntity(articleAgence.article);
            articleAgenceDto.agence = AgenceDto.fromEntity(articleAgence.agence);

            return articleAgenceDto;
        }
    }

    public static ArticleAgence toEntity(ArticleAgenceDto articleAgenceDto){
        ArticleAgence articleAgence = new ArticleAgence();

        if (articleAgenceDto == null) {
            return null;
        } else {
            articleAgence.id = articleAgenceDto.id;
            articleAgence.prix = articleAgenceDto.prix;
            articleAgence.quantite = articleAgenceDto.quantite;
            articleAgence.seuil = articleAgenceDto.seuil;
            articleAgence.article = ArticleDto.toEntity(articleAgenceDto.article);
            articleAgence.agence = AgenceDto.toEntity(articleAgenceDto.agence);

            return articleAgence;
        }
    }

}
