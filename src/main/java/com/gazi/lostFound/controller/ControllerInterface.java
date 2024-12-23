package com.gazi.lostFound.controller;

import com.gazi.lostFound.dto.ItemsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ControllerInterface {
    public ResponseEntity<List<ItemsDto>> getAllItems();
    public ResponseEntity<ItemsDto> getItemsById(@PathVariable("id") Long itemsId);


}
