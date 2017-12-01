package com.storeApp.repositoryImpl;

import com.storeApp.entities.items.Item;

import com.storeApp.entities.items.Size;
import com.storeApp.models.bindingModels.ItemBindingModel;
import com.storeApp.repositories.ItemRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class ItemRepositoryImpl implements ItemRepository{

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public Set<Item> findAll() {
        Query query = this.entityManager.createQuery("SELECT i FROM Item AS i");
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Item findById(long id) {



    Query query = this.entityManager.createQuery("SELECT i FROM Item AS i WHERE i.id = :id");
        query.setParameter("id", id);
        List<Item> items = query.getResultList();
        Item item = null;
        if(items.size() > 0){
            item = items.stream().findFirst().get();
        }

      //  return itemViewModel;
        return item;
    }

    @Override
    public void deleteById(long id) {
        Query query = this.entityManager.createQuery("DELETE FROM Item AS i WHERE i.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Set<Item> findAllBySizeAndName(String size, String name) {
        Query query = this.entityManager.createQuery("SELECT i FROM Item AS i " +
                "WHERE i.size = :size " +
                "AND i.name LIKE :name");
        query.setParameter("name", "%" + name + "%");
        query.setParameter("size", Size.valueOf(size));
        return new HashSet<>(query.getResultList());
    }

    @Override
    public void save(Item item) {
        this.entityManager.persist(item);

    }

    @Override
    public void update(Item item) {
        this.entityManager.merge(item);
    }

    @Override
    public void create(Item item) {this.entityManager.merge(item);}


    }



