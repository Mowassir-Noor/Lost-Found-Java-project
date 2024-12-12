package com.gazi.lostFound.controller;
import com.gazi.lostFound.dto.ItemsDto;
//get  /items
//post /items
//delete /items
//update /items{id}

import ch.qos.logback.core.model.Model;
import com.gazi.lostFound.repositories.ItemsRepository;
import com.gazi.lostFound.services.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ItemsController {

    final private ItemsService itemsService;
    private final ItemsRepository itemsRepository;

    // creating a constructor and passing the data form Items service
    public ItemsController(ItemsService itemsService, ItemsRepository itemsRepository) {
        this.itemsService = itemsService;
        this.itemsRepository = itemsRepository;
    }


    @GetMapping(path = "/items/{id}")
    public ItemsDto getItemsById(@PathVariable("id") Long itemsId){
//        return new ItemsDto(1,"laptop","mowassir ka laptop","electronics", LocalDate.of(2024,3,16),true);
        return  itemsService.getItemsById(itemsId);
    }

    @GetMapping("/items")
    public List<ItemsDto> getAllItems(){
        return itemsService.getAllItems();
    }

    @PostMapping(path="/items")
    public ItemsDto addNewItem(@RequestBody ItemsDto itemsDto){
        return itemsService.addNewItem(itemsDto);

    }
    @DeleteMapping(path = "/items/{id}")
    public boolean deleteItem(@PathVariable("id") Long itemsId){
        return itemsService.deleteItem(itemsId);
    }

//    it's an unnecessary endpoint for trials
//    @DeleteMapping(path = "/items/all")
//    public boolean deleteAll(){
//        return itemsService.deleteAll();
//    }

    @PatchMapping(path="/items/{id}")
    public boolean updateItem(@PathVariable("id") Long itemId,@RequestBody ItemsDto itemsDto){
      return itemsService.updateItem(itemId,itemsDto);
    }



}
