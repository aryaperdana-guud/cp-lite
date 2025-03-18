package com.gli.clic.repository;

import com.gli.clic.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreAccnRepository extends JpaRepository<Account, String> {
    Account findByAccnId(String accnId);
}
