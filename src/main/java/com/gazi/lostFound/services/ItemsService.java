package com.gazi.lostFound.services;


import com.gazi.lostFound.dto.ItemsDto;
import com.gazi.lostFound.entities.ItemsEntity;
import com.gazi.lostFound.repositories.ItemsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemsService {

    //     initializing the itemsrepository and model mapper
    private final ItemsRepository itemsRepository;
    private final ModelMapper modelMapper;
    private final ResourceUrlProvider mvcResourceUrlProvider;


    //    initializing both the classes because of the final keyword
    public ItemsService(ItemsRepository itemsRepository, ModelMapper modelMapper, ResourceUrlProvider mvcResourceUrlProvider) {
        this.itemsRepository = itemsRepository;
        this.modelMapper = modelMapper;
        this.mvcResourceUrlProvider = mvcResourceUrlProvider;
    }


    public ItemsDto getItemsById(Long id) {

        ItemsEntity itemsEntity = itemsRepository.getById(id);

        // we can do this to convert the data of itemsEntity to ItemsDto or we can use model mapping
        // return new ItemsDto(itemsEntity.getItemId(),itemsEntity.getItemName(),itemsEntity.getItemDescription(),itemsEntity.getItemCategory(),itemsEntity.getItemDate(),itemsEntity.isFound());

        return modelMapper.map(itemsEntity, ItemsDto.class);
    }

    public ItemsDto addNewItem(ItemsDto itemsDto) {
        ItemsEntity itemsEntity = modelMapper.map(itemsDto, ItemsEntity.class);
        // saving itemsEntity to the dataBase
        return modelMapper.map(itemsRepository.save(itemsEntity), ItemsDto.class);
    }


    public List<ItemsDto> getAllItems() {
        return itemsRepository.findAll().stream().map(itemsEntity -> modelMapper.map(itemsEntity, ItemsDto.class)).collect(Collectors.toList());
    }

    public boolean deleteItem(Long itemsId) {

        if (itemsRepository.existsById(itemsId)) {
            itemsRepository.deleteById(itemsId);
            return true;

        } else return false;


    }

    public boolean updateItem(Long itemId, ItemsDto itemsDto) {
       if (itemsRepository.existsById(itemId)) {
            ItemsEntity existingData = itemsRepository.findById(itemId).get();
           if (itemsDto.getItemName() != null) {
               existingData.setItemName(itemsDto.getItemName());
           }
           if ((itemsDto.getItemCategory() != null)) {
               existingData.setItemCategory(itemsDto.getItemCategory());
           }
           if (itemsDto.getItemDescription()!=null) {
               existingData.setItemDescription(itemsDto.getItemDescription());
           }
           if (itemsDto.getItemDate()!=null){
               existingData.setItemDate(itemsDto.getItemDate());

           }



                existingData.setFound(itemsDto.isFound());


            itemsRepository.save(existingData);
            return true;

        }
        else{
            return false;
        }



    }
    //    public boolean deleteAll() {
//        itemsRepository.deleteAll();
//        return true;
//    }
}


