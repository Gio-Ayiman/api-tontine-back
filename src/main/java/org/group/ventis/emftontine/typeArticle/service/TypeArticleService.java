package org.group.ventis.emftontine.typeArticle.service;

import org.group.ventis.emftontine.article.entity.Article;
import org.group.ventis.emftontine.typeArticle.entity.TypeArticle;
import org.group.ventis.emftontine.typeArticle.repository.TypeArticleRepository;
import org.group.ventis.emftontine.utils.Exceptions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TypeArticleService {

    @Inject
    TypeArticleRepository typeArticleRepository;

    @Transactional
    public boolean create(TypeArticle typeArticle){
        if (typeArticleRepository.isPersistent(typeArticle)){
            return false;
        }else {
            typeArticleRepository.persist(typeArticle);
            return true;
        }
    }

    @Transactional
    public TypeArticle update(Long id, TypeArticle typeArticle) throws Exceptions {
        if (typeArticleRepository.findById(id) != null) {
            TypeArticle a = typeArticleRepository.findById(id);

            a.description = typeArticle.description;
            a.libelle = typeArticle.libelle;

            return a;
        } else {
            throw new Exceptions();
        }
    }

    public List<TypeArticle> getAllTypesArticle(){
        return typeArticleRepository.listAll();
    }

    public TypeArticle getTypeArticle(long id) {
        TypeArticle a = typeArticleRepository.findById(id);
        if (a == null) {
            return null;
        } else {
            return a;
        }
    }

    public List<TypeArticle> findByLibelle(String libelle){
        List<TypeArticle> typeArticles = typeArticleRepository.find("libelle", libelle).list();
        return typeArticles;
    }

    @Transactional
    public void delete(long id){
        TypeArticle a = typeArticleRepository.findById(id);
        a.delete();
    }
}

