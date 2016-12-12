package com.personal.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.model.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer> {

}
