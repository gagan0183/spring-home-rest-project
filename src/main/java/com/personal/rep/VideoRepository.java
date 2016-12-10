package com.personal.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

}
