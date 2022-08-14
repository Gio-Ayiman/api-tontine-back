package org.group.ventis.emftontine.stock.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.group.ventis.emftontine.stock.entity.Approvisionnement;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApprovisionnementRepository implements PanacheRepository<Approvisionnement> {
}
