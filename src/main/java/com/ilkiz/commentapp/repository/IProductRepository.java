package com.ilkiz.commentapp.repository;

import com.ilkiz.commentapp.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {


    Optional<List<Product>> findAllOptionalByPriceGreaterThan(Double price);

    Optional<List<Product>> findAllOptionalByExpiredDateBefore(LocalDate date);

    Optional<List<Product>> findAllOptionalByExpiredDateAfterOrExpiredDateIsNull(LocalDate date);

    @Query("select p.price,count(p.price) from tbl_product p group by p.price")
    Optional<Object[]> searchProductByPrice();

    Integer countAllByExpiredDate(LocalDate date);

    Optional<List<Product>> findAllOptionalByPriceIn (List<Double> prices);

    Optional<List<Product>> findAllOptionalByNameIn (List<String> names);

    Optional<List<Product>> findAllOptionalByExpiredDateBetween(LocalDate now, LocalDate nextDate);

}
