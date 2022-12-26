package com.ilkiz.commentapp.repository;

import com.ilkiz.commentapp.repository.entity.Product;
import com.ilkiz.commentapp.repository.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductCommentRepository extends JpaRepository<ProductComment,Long> {

    Optional<List<ProductComment>> findAllOptionalByProductid(Long id);

    Optional<List<ProductComment>> findAllOptionalByProductidAndCommentDateBetween(Long id, LocalDate start, LocalDate finish);

    Optional<List<ProductComment>> findAllOptionalByUserid(Long id);

    Optional<List<ProductComment>> findAllOptionalByUseridAndCommentDateBetween(Long id, LocalDate start, LocalDate finish);

    Optional<List<ProductComment>> findAllOptionalByCommentContaining(String value);

    @Query("select pc from tbl_comment pc where length(pc.comment)>?1")
    Optional<List<ProductComment>> commentLength(int length);

}
