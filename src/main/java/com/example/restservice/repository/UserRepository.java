package com.example.restservice.repository;

import com.example.restservice.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    List<UserEntity> findByStatus(Boolean status);

    UserEntity findByUserIdAndStatus(Long userId, Boolean status);

    @Query("select user from UserEntity user " +
            "where user.userId = :userId " +
            "and user.status = :status")
    UserEntity findUserByUserId(@Param(value = "userId") Long userId, @Param(value = "status") Boolean status);

    UserEntity findByUsernameAndPassword(String username, String password);
}

