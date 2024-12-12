package com.gazi.lostFound.repositories;

import com.gazi.lostFound.entities.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity,Long> {
    //JpaRepository has created methods in the interface and implementd the methods in JpaRepository with all
    //the sql code
}
