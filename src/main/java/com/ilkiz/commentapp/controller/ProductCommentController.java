package com.ilkiz.commentapp.controller;

import com.ilkiz.commentapp.repository.entity.ProductComment;
import com.ilkiz.commentapp.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    @GetMapping("/save")
    public ResponseEntity<ProductComment> save(String comment, String commentDate, Long productid, Long userid){
        ProductComment productComment = ProductComment.builder()
                .comment(comment)
                .commentDate(LocalDate.parse(commentDate))
                .productid(productid)
                .userid(userid)
                .build();
        return ResponseEntity.ok(productCommentService.save(productComment));
    }
    @GetMapping("/findall")
    public ResponseEntity<List<ProductComment>> findAll(){
        return ResponseEntity.ok(productCommentService.findAll());
    }
    @GetMapping("/findbyproduct")
    public ResponseEntity<List<ProductComment>> findAllOptionalByProductid(Long id){
        return ResponseEntity.ok(productCommentService.findAllOptionalByProductid(id).get());
    }
    @GetMapping("/findbyproductanddate")
    public ResponseEntity<List<ProductComment>> findAllOptionalByProductidAndCommentDateBetween(Long id, String  start, String finish){
        return ResponseEntity.ok(productCommentService.findAllOptionalByProductidAndCommentDateBetween(id,LocalDate.parse(start),LocalDate.parse(finish)).get());
    }
    @GetMapping("/findbyuser")
    public ResponseEntity<List<ProductComment>> findAllOptionalByUserid(Long id){
        return ResponseEntity.ok(productCommentService.findAllOptionalByUserid(id).get());
    }
    @GetMapping("/findbyuseranddate")
    public ResponseEntity<List<ProductComment>> findAllOptionalByUseridAndCommentDateBetween(Long id, String  start, String finish){
        return ResponseEntity.ok(productCommentService.findAllOptionalByUseridAndCommentDateBetween(id,LocalDate.parse(start),LocalDate.parse(finish)).get());
    }
    @GetMapping("/comment")
    public ResponseEntity<List<ProductComment>> findAllOptionalByCommentContaining(String value){
        return ResponseEntity.ok(productCommentService.findAllOptionalByCommentContaining(value).get());
    }
    @GetMapping("/commentlength")
    public ResponseEntity<List<ProductComment>> commentLength(int length){
        return ResponseEntity.ok(productCommentService.commentLength(length).get());
    }
    @GetMapping("/findbylist")
    public ResponseEntity<List<ProductComment>> findByList(){
        return ResponseEntity.ok(productCommentService.findByList());
    }
}
