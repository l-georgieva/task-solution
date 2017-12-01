package com.storeApp.controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.PathVariable;

import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import com.storeApp.entities.items.Item;
import com.storeApp.entities.items.Size;
import com.storeApp.entities.users.User;
import com.storeApp.models.bindingModels.ItemBindingModel;
import com.storeApp.models.bindingModels.ItemEditBindingModel;
import com.storeApp.models.viewModels.ItemEditViewModel;
import com.storeApp.models.viewModels.ItemViewModel;
import com.storeApp.services.ItemService;
import com.mvcFramework.annotations.parameters.RequestParam;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Stateless
@Controller
public class ItemController {

    @Inject
    private ItemService itemService;

    @GetMapping("/items")
    public String getItemsPage(Model model) {
        Set<ItemViewModel> itemViewModels = null;

        itemViewModels = this.itemService.findAll();

        model.addAttribute("itemViewModels", itemViewModels);
        return "/templates/items";
    }

    @GetMapping("/items/add-item")
    public String getAddItemPage() {
        return "/templates/add-item";
    }

    @PostMapping("/items/add")
    public String addItem(@ModelAttribute ItemBindingModel itemBindingModel, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");




        this.itemService.save(itemBindingModel);
        return "redirect:/items";
    }



    @GetMapping("/items/edit/{itemId}")
    public String getEditItemPage(@PathVariable("itemId") long itemId, Model model) {
        ItemEditViewModel itemEditViewModel = this.itemService.getItemById(itemId);
        model.addAttribute("item", itemEditViewModel);
        return "/templates/add-item";
    }


    @PostMapping("/items/edit/{itemId}")
    public String editItem(@PathVariable("itemId") long itemId, @ModelAttribute ItemEditBindingModel itemBindingModel) {
         itemBindingModel.setId(itemId);
        //model.addAttribute("item",itemEditBindingModel);
        itemService.update(itemBindingModel);
        return "redirect:/items";
    }

    @GetMapping("/items/delete/{itemId}")
    public String deleteItem(@PathVariable("itemId") long itemId) {
        this.itemService.deleteById(itemId);
        return "redirect:/items";
    }
}

