package org.group.ventis.emftontine.article.entity;

import org.group.ventis.emftontine.BaseEntity;
import org.group.ventis.emftontine.typeArticle.entity.TypeArticle;

import javax.persistence.*;

@Entity
public class Article extends BaseEntity {

    public String description;

    public String libelle;

    public double prix;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "TYPE_ARTICLE")
//    public TypeArticle typeArticle;

    @Override
    public BaseEntity clone() {
        return null;
    }

    @Override
    public void initData() {

    }

    @Override
    public void validateData() {

    }
}


