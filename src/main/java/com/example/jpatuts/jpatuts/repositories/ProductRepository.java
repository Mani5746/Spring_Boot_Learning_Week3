package com.example.jpatuts.jpatuts.repositories;

import com.example.jpatuts.jpatuts.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.jpatuts.jpatuts.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByTitle(String title);
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity>findByTitleAndPrice(String title, BigDecimal price);

  //  List<ProductEntity> findByTitleOrderByPrice(String laysChips);

    List<ProductEntity> findBy(Sort sortby);
}
