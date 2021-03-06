package com.okta.developer.demo.repository;

import com.okta.developer.demo.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BorrowSportsEquipmentRepository extends JpaRepository<BorrowSportsEquipment, Long>{

}
