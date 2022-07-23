package org.group.ventis.emftontine.typeArticle.entity;

import org.group.ventis.emftontine.BaseEntity;

import javax.persistence.Entity;

@Entity
public class TypeArticle extends BaseEntity {

    public String libelle;

    public String description;

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
