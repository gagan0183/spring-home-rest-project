package com.personal.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.model.CertificationDetail;

@Repository
public interface CertificationDetailRepository extends JpaRepository<CertificationDetail, Integer> {

}
