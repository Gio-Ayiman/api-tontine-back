package org.group.ventis.emftontine.dto;

import java.util.ArrayList;
import java.util.List;

import org.group.ventis.emftontine.typeArticle.entity.TypeArticle;



public class TypeArticleDto {

    public Long id;

    public String libelle;

    public String description;


    public static TypeArticleDto fromEntity(TypeArticle typeArticle) {
        TypeArticleDto typeArticleDto = new TypeArticleDto();

        if (typeArticle == null) {
            return null;
        } else {
            typeArticleDto.id = typeArticle.id;
            typeArticleDto.libelle = typeArticle.libelle;
            typeArticleDto.description = typeArticle.description;
            return typeArticleDto;
        }
    }

    public static TypeArticle toEntity(TypeArticleDto typeArticleDto) {
        TypeArticle typeArticle = new TypeArticle();

        if (typeArticleDto == null) {
            return null;
        } else {
            typeArticle.id = typeArticleDto.id;
            typeArticle.description = typeArticleDto.description;
            typeArticle.libelle = typeArticleDto.libelle;

            return typeArticle;
        }
    }

    public static List<TypeArticleDto> fromEntity(List<TypeArticle> typeArticles) {
        List<TypeArticleDto> typeArticleDtos = new ArrayList<>();

        for (TypeArticle typeArticle : typeArticles) {
            typeArticleDtos.add(fromEntity(typeArticle));
        }

        return typeArticleDtos;    
    }

    public static List<TypeArticle> toEntity(List<TypeArticleDto> typeArticleDtos) {
        List<TypeArticle> typeArticles = new ArrayList<>();

        for (TypeArticleDto typeArticle : typeArticleDtos) {
            typeArticles.add(toEntity(typeArticle));
        }
        return typeArticles;
    }
}
