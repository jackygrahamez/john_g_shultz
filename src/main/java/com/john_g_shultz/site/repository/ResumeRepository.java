package com.john_g_shultz.site.repository;

import com.john_g_shultz.site.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Resume entity.
 */
public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
