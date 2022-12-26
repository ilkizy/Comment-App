package com.ilkiz.commentapp.service;

import com.ilkiz.commentapp.repository.IProductCommentRepository;
import com.ilkiz.commentapp.repository.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCommentService {

    private final IProductCommentRepository productCommentRepository;
    public ProductComment save(ProductComment comment){
        return productCommentRepository.save(comment);
    }

    public List<ProductComment> findAll(){
        return productCommentRepository.findAll();
    }

    public Optional<List<ProductComment>> findAllOptionalByProductid(Long id){
        return productCommentRepository.findAllOptionalByProductid(id);
    }

    public Optional<List<ProductComment>> findAllOptionalByProductidAndCommentDateBetween(Long id, LocalDate start, LocalDate finish){
        return productCommentRepository.findAllOptionalByProductidAndCommentDateBetween(id,start,finish);
    }

    public Optional<List<ProductComment>> findAllOptionalByUserid(Long id){
        return productCommentRepository.findAllOptionalByUserid(id);
    }

    public Optional<List<ProductComment>> findAllOptionalByUseridAndCommentDateBetween(Long id, LocalDate start, LocalDate finish){
        return productCommentRepository.findAllOptionalByUseridAndCommentDateBetween(id,start,finish);
    }

    public Optional<List<ProductComment>> findAllOptionalByCommentContaining(String value){
        return productCommentRepository.findAllOptionalByCommentContaining(value);
    }

    public Optional<List<ProductComment>> commentLength(int length){
        return productCommentRepository.commentLength(length);
    }

    public List<ProductComment> findByList(){
        List<String > list = new ArrayList<>();
        list.add("çok güzel");
        list.add("iyi");

        List<ProductComment> productCommentList = productCommentRepository.findAll().stream().filter(x->{
            for (int i = 0; i < list.size(); i++){
                if (x.getComment().contains(list.get(i))){
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
        return productCommentList;
    }
}
