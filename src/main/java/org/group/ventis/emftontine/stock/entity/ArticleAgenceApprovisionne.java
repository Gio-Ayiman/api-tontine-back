package org.group.ventis.emftontine.stock.entity;

import org.group.ventis.emftontine.BaseEntity;

import javax.persistence.Entity;


@Entity
public class ArticleAgenceApprovisionne extends BaseEntity {
    public int quantite;

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
