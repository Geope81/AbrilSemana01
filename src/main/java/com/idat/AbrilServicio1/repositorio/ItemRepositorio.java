package com.idat.AbrilServicio1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.idat.AbrilServicio1.modelo.Items;

@Repository
public interface ItemRepositorio extends JpaRepository<Items, Integer>{

}
