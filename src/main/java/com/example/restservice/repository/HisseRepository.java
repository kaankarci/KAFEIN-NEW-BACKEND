package com.example.restservice.repository;

import com.example.restservice.model.entity.HisseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HisseRepository extends JpaRepository<HisseEntity, Long> {
    List<HisseEntity> findByStatus(Boolean status);

    HisseEntity findByHisseIdAndStatus(Long hisseId, Boolean status);
}
