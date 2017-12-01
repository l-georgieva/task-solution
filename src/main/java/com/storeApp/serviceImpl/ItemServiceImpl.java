package com.storeApp.serviceImpl;

import com.storeApp.entities.items.Item;


import com.storeApp.models.bindingModels.ItemBindingModel;
import com.storeApp.models.bindingModels.ItemEditBindingModel;
import com.storeApp.models.viewModels.ItemEditViewModel;
import com.storeApp.models.viewModels.ItemViewModel;
import com.storeApp.repositories.ItemRepository;
import com.storeApp.services.ItemService;
import com.storeApp.utils.parser.interfaces.ModelParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@Stateless
public class ItemServiceImpl implements ItemService {
    @Inject
    private ItemRepository itemRepository;

    @Inject
    private ModelParser modelParser;
   // private ItemEditViewModel itemEditViewModel;


    @Override
    public Set<ItemViewModel> findAll() {
        Set<Item> items = this.itemRepository.findAll();
        Set<ItemViewModel> itemViewModels = new HashSet<>();
        for (Item item : items) {
            ItemViewModel itemViewModel = this.modelParser.convert(item, ItemViewModel.class);
            itemViewModels.add(itemViewModel);
        }

        return itemViewModels;
    }

    @Override
    public Set<ItemViewModel> searchItems(String size, String name) {
        Set<Item> items = this.itemRepository.findAllBySizeAndName(size, name);
        Set<ItemViewModel> itemViewModels = new HashSet<>();
        for (Item item : items) {
            ItemViewModel itemViewModel = this.modelParser.convert(item, ItemViewModel.class);
            itemViewModels.add(itemViewModel);
        }

        return itemViewModels;
    }

    @Override
    public ItemViewModel findById(long id) {
        Item item = this.itemRepository.findById(id);
        ItemViewModel itemViewModel = this.modelParser.convert(item, ItemViewModel.class);
        return itemViewModel;
    }


    @Override
    public void deleteById(long id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public void create(ItemBindingModel itemBindingModel) {
        Item item = this.modelParser.convert(itemBindingModel,Item.class);
        item.setType(String.valueOf(itemBindingModel.getType().toString()));
        item.setName(String.valueOf(itemBindingModel.getName().toString()));
        item.setQuantity(Integer.valueOf(itemBindingModel.getQuantity()));
        item.setSinglePrice(Double.valueOf(itemBindingModel.getSinglePrice()));
        //User user = this.userRepository.findByUsername(username);
        this.itemRepository.create(item);
    }




    @Override
    public void save(ItemBindingModel itemBindingModel) {
        Item item = this.modelParser.convert(itemBindingModel, Item.class);
      //  item.setSize(Size.valueOf(itemBindingModel.getSize().toUpperCase()));

        this.itemRepository.save(item);

    }

    @Override
    public void update(ItemEditBindingModel itemEditBindingModel) {
        Item item = this.modelParser.convert(itemEditBindingModel, Item.class);
        item.setType(String.valueOf(itemEditBindingModel.getType().toString()));
        item.setName(String.valueOf(itemEditBindingModel.getName().toString()));
        item.setQuantity(Integer.valueOf(itemEditBindingModel.getQuantity()));
        item.setSinglePrice(Double.valueOf(itemEditBindingModel.getSinglePrice()));

        this.itemRepository.update(item);


    }

    @Override
    public ItemEditViewModel getItemById(long id) {
        Item item = this.itemRepository.findById(id);
        ItemEditViewModel itemEditViewModel = this.modelParser.convert(item,ItemEditViewModel.class);
        itemEditViewModel.setName(item.getName().toString());
        itemEditViewModel.setType(item.getType().toString());
        itemEditViewModel.setQuantity(item.getQuantity());
        itemEditViewModel.setSinglePrice(item.getSinglePrice());
        return itemEditViewModel;
    }


}






