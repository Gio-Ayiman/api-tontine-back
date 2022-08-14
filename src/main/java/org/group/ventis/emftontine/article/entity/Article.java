package org.group.ventis.emftontine.article.entity;

import org.group.ventis.emftontine.stock.entity.ArticleApprovisionne;
import org.group.ventis.emftontine.typeArticle.entity.TypeArticle;
import org.group.ventis.emftontine.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article extends BaseEntity {

     public String description;

    public String libelle;

    public double prix;

    public int quantiteDisponible;

    @OneToOne(mappedBy = "article")
    public ArticleAgence articleAgence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ARTICLE")
    public TypeArticle typeArticle;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    public List<ArticleApprovisionne> articleApprovisionne;

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


