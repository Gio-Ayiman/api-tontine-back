package org.group.ventis.emftontine.user.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String nom;

    public String prenom;

    public Date dateNaissance;

    public String telephone;

    public String email;

    public String motDePasse;

    public String photo;

    @OneToOne()
    public JournalConnexion journalConnexion;
}
