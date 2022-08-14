package org.group.ventis.emftontine.stock.entity;

import org.group.ventis.emftontine.BaseEntity;
import org.group.ventis.emftontine.article.entity.ArticleAgence;
import org.group.ventis.emftontine.dto.ArticleAgenceApprovisionneDto;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ArticleAgenceApprovisionne extends BaseEntity {
    public int quantite;

    @ManyToOne
    @JoinColumn(name = "APPRO_ID",  referencedColumnName = "ID")
    public Approvisionnement approvisionnement;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_AGENCE_ID", referencedColumnName = "ID")
    public ArticleAgence articleAgence;


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
