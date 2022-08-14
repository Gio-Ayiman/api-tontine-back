package org.group.ventis.emftontine.stock.entity;

import org.group.ventis.emftontine.BaseEntity;
import org.group.ventis.emftontine.article.entity.Article;

import javax.persistence.*;
import java.util.List;

@Entity
public class ArticleApprovisionne extends BaseEntity{

    @Column(nullable = true)
    public int quantite;

    @ManyToOne
    @JoinColumn(name = "APPROVISIONNEMENT_ID", referencedColumnName = "ID")
    public Approvisionnement approvisionnement;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ID")
    public Article article;

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
