package com.gli.clic.repository;

import com.gli.clic.model.CreationVA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreationVARepository extends JpaRepository<CreationVA, Long> {
    CreationVA findByVirtualNumber(String virtualNumber);
}