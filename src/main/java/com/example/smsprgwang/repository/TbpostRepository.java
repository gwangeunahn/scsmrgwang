package com.example.smsprgwang.repository;

import com.example.smsprgwang.domain.Tbpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbpostRepository extends JpaRepository<Tbpost, String> {
}
