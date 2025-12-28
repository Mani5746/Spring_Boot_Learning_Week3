package com.example.jpatuts.jpatuts.repositories;

import com.example.jpatuts.jpatuts.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long>{
}
