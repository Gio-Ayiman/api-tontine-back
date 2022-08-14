package org.group.ventis.emftontine.stock.entity;

import org.group.ventis.emftontine.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Approvisionnement extends BaseEntity {

    public LocalDateTime dateAppro;

    public String etat;

    @OneToMany(mappedBy = "approvisionnement")
    public List<ArticleApprovisionne> articleApprovisionnes;

    @OneToMany(mappedBy = "approvisionnement")
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
