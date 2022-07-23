package org.group.ventis.emftontine.user.entity;

import java.time.LocalDateTime;

public class JournalAudit {
    public Long id;

    public LocalDateTime date;

    public Utilisateur initiePar;

    public String adresseIp;

    public String description;

    public String category;

    public String activite;
}
