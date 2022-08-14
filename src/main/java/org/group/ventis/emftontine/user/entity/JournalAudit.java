package org.group.ventis.emftontine.user.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JournalAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public LocalDateTime date;

    @OneToOne()
    public Utilisateur initiePar;

    public String adresseIp;

    public String description;

    public String category;

    public String activite;
}
