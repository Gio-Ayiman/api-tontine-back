package org.group.ventis.emftontine.dto;


import org.group.ventis.emftontine.article.entity.Article;

import java.util.List;

public class ArticleDto {

    public Long id;

    public String description;

    public String libelle;

    public double prix;

    public int quantiteDisponible;

    public ArticleAgenceDto articleAgence;

    public TypeArticleDto typeArticle;

    public List<ArticleApprovisionneDto> articleApprovisionne;

    public static ArticleDto fromEntity(Article article) {
        ArticleDto articleDto = new ArticleDto();

        if (article ==null) {
            return null;
        } else {
            articleDto.id = article.id;
            articleDto.libelle = article.libelle;
            articleDto.description = article.description;
            articleDto.prix = article.prix;
            articleDto.quantiteDisponible = article.quantiteDisponible;
            articleDto.articleAgence = ArticleAgenceDto.fromEntity(article.articleAgence);
            articleDto.typeArticle = TypeArticleDto.fromEntity(article.typeArticle);
            // articleDto.articleApprovisionne = ArticleApprovisionneDto.FromEntity(article.articleApprovisionne);

            return articleDto;
        }
    }

    public static Article toEntity(ArticleDto articleDto) {
        Article article = new Article();

        if (articleDto == null) {
            return null;
        } else {
            article.id = articleDto.id;
            article.libelle = articleDto.libelle;
            article.description = articleDto.description;
            article.prix = articleDto.prix;
            article.quantiteDisponible = articleDto.quantiteDisponible;
            article.articleAgence = ArticleAgenceDto.toEntity(articleDto.articleAgence);
            article.typeArticle = TypeArticleDto.toEntity(articleDto.typeArticle);
            // article.articleApprovisionne = ArticleApprovisionneDto.toEntity(articleDto.articleApprovisionne);

            return article;
        }
    }

    

}



