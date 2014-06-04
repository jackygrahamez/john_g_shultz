package com.john_g_shultz.site.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.john_g_shultz.site.domain.Fun_house;
import com.john_g_shultz.site.repository.Fun_houseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing Fun_house.
 */
@RestController
@RequestMapping("/app")
public class Fun_houseResource {

    private final Logger log = LoggerFactory.getLogger(Fun_houseResource.class);

    @Inject
    private Fun_houseRepository fun_houseRepository;

    /**
     * POST  /rest/fun_houses -> Create a new fun_house.
     */
    @RequestMapping(value = "/rest/fun_houses",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody Fun_house fun_house) {
        log.debug("REST request to save Fun_house : {}", fun_house);
        fun_houseRepository.save(fun_house);
    }

    /**
     * GET  /rest/fun_houses -> get all the fun_houses.
     */
    @RequestMapping(value = "/rest/fun_houses",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<Fun_house> getAll() {
        log.debug("REST request to get all Fun_houses");
        return fun_houseRepository.findAll();
    }

    /**
     * GET  /rest/fun_houses/:id -> get the "id" fun_house.
     */
    @RequestMapping(value = "/rest/fun_houses/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public Fun_house get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Fun_house : {}", id);
        Fun_house fun_house = fun_houseRepository.findOne(id);
        if (fun_house == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return fun_house;
    }

    /**
     * DELETE  /rest/fun_houses/:id -> delete the "id" fun_house.
     */
    @RequestMapping(value = "/rest/fun_houses/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Fun_house : {}", id);
        fun_houseRepository.delete(id);
    }
}
