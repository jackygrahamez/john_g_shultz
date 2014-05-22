package com.john_g_shultz.site.repository;

import com.john_g_shultz.site.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Contact entity.
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
