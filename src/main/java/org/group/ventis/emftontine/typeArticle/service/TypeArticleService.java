package org.group.ventis.emftontine.typeArticle.service;

import io.quarkus.logging.Log;
import org.group.ventis.emftontine.dto.ArticleDto;
import org.group.ventis.emftontine.dto.TypeArticleDto;
import org.group.ventis.emftontine.typeArticle.entity.TypeArticle;
import org.group.ventis.emftontine.typeArticle.repository.TypeArticleRepository;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TypeArticleService {

    @Inject
    TypeArticleRepository typeArticleRepository;

    @Transactional
    public TypeArticleDto create(TypeArticleDto typeArticle){
        TypeArticle t = TypeArticleDto.toEntity(typeArticle);
        if (typeArticleRepository.isPersistent(t)){
            return null;
        }else {
            TypeArticle typeArticle1 = TypeArticleDto.toEntity(typeArticle);
            typeArticleRepository.persist(typeArticle1);
            return TypeArticleDto.fromEntity(typeArticle1);
        }
    }

    @Transactional
    public TypeArticleDto update(Long id, TypeArticleDto typeArticle) {
        if (typeArticleRepository.findById(id) != null) {
            TypeArticleDto a = TypeArticleDto.fromEntity(typeArticleRepository.findById(id));
            a.description = typeArticle.description;
            a.libelle = typeArticle.libelle;

            Log.info("Modification du type article " + id);
            return a;
        } else {
            throw new Exceptions.NullEntityId(id);
        }
    }

    public List<TypeArticleDto> getAllTypesArticle(){
        Log.info("Recherche des types articles");
        return typeArticleRepository.listAll().stream().map(TypeArticleDto::fromEntity).collect(Collectors.toList());
    }

    public TypeArticleDto getTypeArticle(long id) {
        TypeArticleDto a = TypeArticleDto.fromEntity(typeArticleRepository.findById(id));
        if (a != null) {
            Log.info("Recherche du type article : " + id);
            return a;
        }
        else throw new Exceptions.NullEntityId(id);
    }

    public List<TypeArticleDto> findByLibelle(String libelle){
        List<TypeArticleDto> typeArticles = typeArticleRepository.find("libelle", libelle)
                .stream()
                .map(TypeArticleDto::fromEntity)
                .collect(Collectors.toList());

        if ( typeArticles != null ) {
            Log.info("Recherche du type article avec le libelle : " + libelle);
            return typeArticles;
        }
        else
            return null;
    }

    @Transactional
    public TypeArticleDto delete(long id) {
        TypeArticle a = typeArticleRepository.findById(id);

        if (typeArticleRepository.findById(id).isPersistent()) {
            a.delete();
            Log.info("Supression du type article : " + id);
            return TypeArticleDto.fromEntity(a);
        } else throw new Exceptions.NullEntityId(id);
    }
}

