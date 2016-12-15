package com.personal.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.model.Videotutorial;

@Repository
public interface VideotutorialRepository extends JpaRepository<Videotutorial, Integer> {

}
