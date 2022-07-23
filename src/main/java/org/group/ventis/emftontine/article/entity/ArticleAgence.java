package org.group.ventis.emftontine.article.entity;


import org.group.ventis.emftontine.BaseEntity;

import javax.persistence.Entity;

@Entity
public class ArticleAgence  extends BaseEntity {
    public int quantite;

    public double prix;

    public int seuil;

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
