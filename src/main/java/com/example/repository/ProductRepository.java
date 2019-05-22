package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Category;
import com.example.models.Manufacturer;
import com.example.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Product save(Product p);

    //@Query(value="select p from Product p where p.productID=:id")
    Optional<Product> findById(Long id);

    //@Query(value="select p from Product p where p.category=:catId")
    List<Product> findByCategory(Category cat);

    //@Query(value="select p from Product p where p.category=:catId and p.manufacturer=:manId")
    List<Product> findByCategoryAndManufacturer(Category cat, Manufacturer man);

    //@Modifying
    @Query(value="select sum(p.price) from Product p where p.category=:cat")
    Double calcPrice(@Param("cat") Category cat);

}
