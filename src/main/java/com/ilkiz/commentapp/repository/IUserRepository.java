package com.ilkiz.commentapp.repository;

import com.ilkiz.commentapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findAllByOrderByNameAsc();

    Optional<List<User>> findAllOptionalByNameContainingIgnoreCase(String name);

    Optional<List<User>> findAllOptionalByEmailContainingIgnoreCase(String email);

    Optional<List<User>> findAllOptionalByEmailEndingWith(String email);

    Optional<User> findOptionalByEmailAndPassword (String email, String password);

    @Query("select u from User u where length(u.password) >?1")
    Optional<List<User>> controlPassword(int password);
}
