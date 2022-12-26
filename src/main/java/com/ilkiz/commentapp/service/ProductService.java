package com.ilkiz.commentapp.service;

import com.ilkiz.commentapp.repository.IProductRepository;
import com.ilkiz.commentapp.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<List<Product>> findAllOptionalByPriceGreaterThan(Double price){
        return productRepository.findAllOptionalByPriceGreaterThan(price);
    }

    public Optional<List<Product>> findAllOptionalByExpiredDateBefore(LocalDate date){
        return productRepository.findAllOptionalByExpiredDateBefore(date);
    }

    public Optional<List<Product>> findAllOptionalByExpiredDateAfterOrExpiredDateIsNull(LocalDate date){
        return productRepository.findAllOptionalByExpiredDateAfterOrExpiredDateIsNull(date);
    }

    public Optional<Object[]> searchProductByPrice(){
        return productRepository.searchProductByPrice();
    }

    public Integer countAllByExpiredDate(LocalDate date){
        return productRepository.countAllByExpiredDate(date);
    }

    public Optional<List<Product>> findAllOptionalByPriceIn (List<Double> prices){
        return productRepository.findAllOptionalByPriceIn(prices);
    }

    public Optional<List<Product>> findAllOptionalByNameIn (List<String> names){
        return productRepository.findAllOptionalByNameIn(names);
    }

    public List<Product> findAllOptionalByExpiredDateBetween(LocalDate now, LocalDate nextDate){
        now=LocalDate.now();
        nextDate=LocalDate.now().plusMonths(6);

        List<Product> productList = productRepository.findAllOptionalByExpiredDateBetween(now, nextDate).get();

        productList.forEach(x-> x.setPrice(x.getPrice()*0.9));
        return productRepository.saveAll(productList);
    }
}
