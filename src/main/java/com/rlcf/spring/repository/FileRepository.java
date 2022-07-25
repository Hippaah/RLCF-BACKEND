package com.rlcf.spring.repository;

import com.rlcf.spring.models.FileExploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileExploi, Long> {
}
