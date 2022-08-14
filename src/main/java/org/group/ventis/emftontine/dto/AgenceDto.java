package org.group.ventis.emftontine.dto;

import org.group.ventis.emftontine.agence.entity.Agence;

import java.util.List;

public class AgenceDto {

    public Long id;
    public String codeAgence;

    public String name;

    public String RIBCompteDepot;

    public boolean statut;

    public List<ArticleAgenceDto> articleAgences;

    public static AgenceDto fromEntity(Agence agence){
        AgenceDto agenceDto = new AgenceDto();

        if (agence == null) {
            return null;
        } else {
            agenceDto.id = agence.id;
            agenceDto.codeAgence = agence.codeAgence;
            agenceDto.name = agence.name;
            agenceDto.RIBCompteDepot = agence.RIBCompteDepot;
            agenceDto.statut = agence.statut;

            return agenceDto;
        }
    }

    public static Agence toEntity(AgenceDto agenceDto) {
        Agence agence = new Agence();

        if (agenceDto == null) {
            return null;
        } else {
            agence.id = agenceDto.id;
            agence.codeAgence = agenceDto.codeAgence;
            agence.name = agenceDto.name;
            agence.RIBCompteDepot = agenceDto.RIBCompteDepot;
            agence.statut = agenceDto.statut;

            return agence;
        }
    }

}
