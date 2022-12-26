package com.ilkiz.commentapp.controller;

import com.ilkiz.commentapp.repository.entity.Product;
import com.ilkiz.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/save")
    public ResponseEntity<Product> save(String name, Double price, String expiredDate){
        Product product = Product.builder()
                .name(name)
                .price(price)
                .expiredDate(LocalDate.parse(expiredDate))
                .build();
        return ResponseEntity.ok(productService.save(product));
    }
    @GetMapping("/findall")
    private ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/greaterthan")
    public ResponseEntity<Optional<List<Product>>> findAllOptionalByPriceGreaterThan(Double price){
        return ResponseEntity.ok(productService.findAllOptionalByPriceGreaterThan(price));
    }
    @GetMapping("/expireddatebefore")
    public ResponseEntity<Optional<List<Product>>> findAllOptionalByExpiredDateBefore(LocalDate date){
        return ResponseEntity.ok(productService.findAllOptionalByExpiredDateBefore(date));
    }
    @GetMapping("/expireddateafter")
    public ResponseEntity<Optional<List<Product>>> findAllOptionalByExpiredDateAfterOrExpiredDateIsNull(LocalDate date){
        return ResponseEntity.ok(productService.findAllOptionalByExpiredDateAfterOrExpiredDateIsNull(date));
    }
    @GetMapping("/productbyprice")
    public ResponseEntity<Optional<Object[]>> searchProductByPrice(){
        return ResponseEntity.ok(productService.searchProductByPrice());
    }
    @GetMapping("/countexpireddate")
    public ResponseEntity<Integer> countAllByExpiredDate(String date){
        return ResponseEntity.ok(productService.countAllByExpiredDate(LocalDate.parse(date)));
    }
    @GetMapping("/pricein")
    public ResponseEntity<Optional<List<Product>>> findAllOptionalByPriceIn (List<Double> prices){
        return ResponseEntity.ok(productService.findAllOptionalByPriceIn(prices));
    }
    @GetMapping("/namein")
    public ResponseEntity<Optional<List<Product>>> findAllOptionalByNameIn (List<String> names){
        return ResponseEntity.ok(productService.findAllOptionalByNameIn(names));
    }
    @GetMapping("/expireddatebetween")
    public List<Product> findAllOptionalByExpiredDateBetween(LocalDate now, LocalDate nextDate){
        return productService.findAllOptionalByExpiredDateBetween(now, nextDate);
    }
}
