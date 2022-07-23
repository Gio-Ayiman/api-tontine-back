package org.group.ventis.emftontine.user.entity;

import jdk.jshell.execution.Util;
import org.group.ventis.emftontine.user.enumerator.StatutConnexion;

import java.time.LocalDateTime;

public class JournalConnexion {

    public Long id;

    public LocalDateTime date;

    public String IDSession;

    public Utilisateur utilisateur;

    public String application;

    public StatutConnexion statutConnexion;

    public String adresseIP;

    public String emplacement;
}
