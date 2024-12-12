package com.gazi.lostFound.entities;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "Items")
//@Data
//@AllArgsConstructor     we can use this inplace of creating all the thing(setter,getter,constructor) manually
//@NoArgsConstructor
public class ItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private LocalDate itemDate;
    private boolean found;

    public ItemsEntity(Long itemId, String itemName, String itemDescription, String itemCategory, LocalDate itemDate, boolean found) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemDate = itemDate;
        this.found = found;
    }
    public ItemsEntity() {}


    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public LocalDate getItemDate() {
        return itemDate;
    }

    public boolean isFound() {
        return found;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setItemDate(LocalDate itemDate) {
        this.itemDate = itemDate;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
}
