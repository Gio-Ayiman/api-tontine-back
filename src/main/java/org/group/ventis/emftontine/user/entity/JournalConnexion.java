package org.group.ventis.emftontine.user.entity;

import jdk.jshell.execution.Util;
import org.group.ventis.emftontine.user.enumerator.StatutConnexion;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JournalConnexion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public LocalDateTime date;

    public String IDSession;

    @OneToOne()
    public Utilisateur utilisateur;

    public String application;

    public StatutConnexion statutConnexion;

    public String adresseIP;

    public String emplacement;
}
