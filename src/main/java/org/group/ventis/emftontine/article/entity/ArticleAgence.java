package org.group.ventis.emftontine.article.entity;


import org.group.ventis.emftontine.BaseEntity;
import org.group.ventis.emftontine.agence.entity.Agence;
import org.group.ventis.emftontine.dto.ArticleAgenceDto;
import org.group.ventis.emftontine.stock.entity.ArticleAgenceApprovisionne;

import javax.persistence.*;
import java.util.List;

@Entity
public class ArticleAgence  extends BaseEntity {

    public double prix;

    public int quantite;

    public int seuil;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "ID")
    public Article article;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    public Agence agence;

    @OneToMany(mappedBy = "articleAgence")
    public List<ArticleAgenceApprovisionne> articleAgenceApprovisionnes;

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
