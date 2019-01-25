package com.okta.developer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.okta.developer.demo.entity.Major;

@RepositoryRestResource
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
public interface MajorReporitory extends JpaRepository<Major,Long> {
    Major findByMajorname(String major_name);
}
