package org.group.ventis.emftontine.agence.entity;

import org.group.ventis.emftontine.BaseEntity;
import org.group.ventis.emftontine.article.entity.ArticleAgence;
import org.group.ventis.emftontine.dto.AgenceDto;
import org.group.ventis.emftontine.dto.ArticleAgenceDto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Agence extends BaseEntity {


    @Column(name = "code_agence")
    public String codeAgence;

    public String name;

    public String RIBCompteDepot;

    public boolean statut;

    @OneToMany()
    public List<ArticleAgence> articleAgences;

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
