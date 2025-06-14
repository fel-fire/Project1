package com.felfire.project.repository;

import com.felfire.project.entity.Transfer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepo extends CrudRepository<Transfer, Integer> {

    @Query(value = "SELECT * FROM transfer WHERE transfer_owner = ?1 LIMIT 30", nativeQuery = true)
    Iterable<Transfer> findAllByOwner(Integer owner);
}
