package org.group.ventis.emftontine.agence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.group.ventis.emftontine.agence.entity.Agence;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public  class AgenceRepository implements PanacheRepository<Agence> {

}
