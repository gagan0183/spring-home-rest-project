package com.personal.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.model.VideotutorialDetail;

@Repository
public interface VideotutorialDetailRepository extends JpaRepository<VideotutorialDetail, Integer> {

}
