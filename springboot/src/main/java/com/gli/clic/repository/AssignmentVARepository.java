package com.gli.clic.repository;

import com.gli.clic.model.AssignmentVA;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssignmentVARepository extends JpaRepository<AssignmentVA, Long> {
    List<AssignmentVA> findByAsgnVirtualNumber(String virtualNumber);
}