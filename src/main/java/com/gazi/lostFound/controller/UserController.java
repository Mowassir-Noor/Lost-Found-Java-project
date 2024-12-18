package com.gazi.lostFound.controller;


import com.gazi.lostFound.dto.ItemsDto;
import com.gazi.lostFound.repositories.ItemsRepository;
import com.gazi.lostFound.services.ItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    final private ItemsService itemsService;
    final private ItemsRepository itemsRepository;

    // creating a constructor and passing the data form Items service
    public UserController(ItemsService itemsService, ItemsRepository itemsRepository) {
        this.itemsService = itemsService;
        this.itemsRepository = itemsRepository;
    }


    @GetMapping(path = "/items/{id}")
    public ResponseEntity<ItemsDto> getItemsById(@PathVariable("id") Long itemsId){
        ItemsDto itemsDto = itemsService.getItemsById(itemsId);
        return ResponseEntity.ok(itemsDto);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemsDto>> getAllItems(){
        List<ItemsDto> itemsList = itemsService.getAllItems();
        return ResponseEntity.ok(itemsList);
    }

}
