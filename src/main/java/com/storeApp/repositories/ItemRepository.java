package com.storeApp.repositories;

import com.storeApp.entities.items.Item;
import com.storeApp.models.bindingModels.ItemBindingModel;

import java.util.Set;

public interface ItemRepository {




    Set<Item> findAll();



    Item findById(long id);

    void deleteById(long id);

    Set<Item> findAllBySizeAndName(String size, String name);

    void save(Item item);

    void update(Item item);

    void create(Item item);
}
