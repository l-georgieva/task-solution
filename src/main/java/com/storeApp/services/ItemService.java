package com.storeApp.services;

import com.storeApp.models.bindingModels.ItemBindingModel;
import com.storeApp.models.bindingModels.ItemEditBindingModel;
import com.storeApp.models.viewModels.ItemEditViewModel;
import com.storeApp.models.viewModels.ItemViewModel;

import java.util.Set;

public interface ItemService {





    Set<ItemViewModel> findAll();


    Set<ItemViewModel> searchItems(String size, String name);

    ItemViewModel findById(long id);

    void deleteById(long id);
    void create(ItemBindingModel itemBindingModel);

    void save(ItemBindingModel itemBindingModel);

    void update(ItemEditBindingModel itemBindingModel);

    ItemEditViewModel getItemById(long id);


}
