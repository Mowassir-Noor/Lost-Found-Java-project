package com.gazi.lostFound.repositories;

import com.gazi.lostFound.entities.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity,Long> {
   //Deals with all the sql code
    //I can add custom Sql Queries too

}
