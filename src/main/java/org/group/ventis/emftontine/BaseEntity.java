package org.group.ventis.emftontine;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
@MappedSuperclass
public abstract class BaseEntity extends PanacheEntity {


    @Column(name = "CREE_PAR")
    public String createdBy;

    @Column(name = "MODIFIE_PAR")
    public String updatedBy;

    @CreationTimestamp
    @Column(name = "DATE_CREATION")
    public Instant creationTime;

    @UpdateTimestamp
    @Column(name = "DATE_DERNIERE_MODIFICATION")
    public Instant updateTime;

    @Column(name = "DATE_VALEUR")
    public Instant valueDate;

    public abstract BaseEntity clone();

    public abstract void initData();

    public abstract void validateData();

}
