package org.group.ventis.emftontine.agence.service;
import org.group.ventis.emftontine.utils.Exceptions;
import org.group.ventis.emftontine.agence.entity.Agence;
import org.group.ventis.emftontine.agence.repository.AgenceRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class AgenceService{

    @Inject
    AgenceRepository agenceRepository;


    public Agence getOne(long id) {
        Agence agence = agenceRepository.findById(id);
        if (agence == null) {
            return null;
        } else {
            return agence;
        }
    }

    public List<Agence> getAll(){
        return agenceRepository.listAll();
    }

    public List<Agence> search(String name) {
        List<Agence> a = agenceRepository.find("name", name).list();
        return a;
    }

    @Transactional
    public boolean create(Agence agence){
        if(agenceRepository.isPersistent(agence)) {
            return false;
        } else {
            agenceRepository.persist(agence);
            return true;
        }
    }


    @Transactional
    public Agence update(long id, Agence agence) throws Exceptions {
        if (agenceRepository.findById(id) != null) {
            Agence a = agenceRepository.findById(id);

            a.codeAgence = agence.codeAgence;
            a.name = agence.name;
            a.RIBCompteDepot = agence.RIBCompteDepot;
            a.statut = agence.statut;
            return a;
        } else {
           throw new Exceptions();
        }
    }

    @Transactional
    public void delete(long id){
        Agence a = agenceRepository.findById(id);
        a.delete();
    }
}
