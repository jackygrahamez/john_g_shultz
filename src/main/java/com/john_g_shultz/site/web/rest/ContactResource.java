package com.john_g_shultz.site.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.john_g_shultz.site.domain.Contact;
import com.john_g_shultz.site.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing Contact.
 */
@RestController
@RequestMapping("/app")
public class ContactResource {

    private final Logger log = LoggerFactory.getLogger(ContactResource.class);

    @Inject
    private ContactRepository contactRepository;

    /**
     * POST  /rest/contacts -> Create a new contact.
     */
    @RequestMapping(value = "/rest/contacts",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody Contact contact) {
        log.debug("REST request to save Contact : {}", contact);
        contactRepository.save(contact);
    }

    /**
     * GET  /rest/contacts -> get all the contacts.
     */
    @RequestMapping(value = "/rest/contacts",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<Contact> getAll() {
        log.debug("REST request to get all Contacts");
        return contactRepository.findAll();
    }

    /**
     * GET  /rest/contacts/:id -> get the "id" contact.
     */
    @RequestMapping(value = "/rest/contacts/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public Contact get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Contact : {}", id);
        Contact contact = contactRepository.findOne(id);
        if (contact == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return contact;
    }

    /**
     * DELETE  /rest/contacts/:id -> delete the "id" contact.
     */
    @RequestMapping(value = "/rest/contacts/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Contact : {}", id);
        contactRepository.delete(id);
    }
}
