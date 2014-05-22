package com.john_g_shultz.site.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.john_g_shultz.site.domain.Resume;
import com.john_g_shultz.site.repository.ResumeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing Resume.
 */
@RestController
@RequestMapping("/app")
public class ResumeResource {

    private final Logger log = LoggerFactory.getLogger(ResumeResource.class);

    @Inject
    private ResumeRepository resumeRepository;

    /**
     * POST  /rest/resumes -> Create a new resume.
     */
    @RequestMapping(value = "/rest/resumes",
            method = RequestMethod.POST,
            produces = "application/json")
    @Timed
    public void create(@RequestBody Resume resume) {
        log.debug("REST request to save Resume : {}", resume);
        resumeRepository.save(resume);
    }

    /**
     * GET  /rest/resumes -> get all the resumes.
     */
    @RequestMapping(value = "/rest/resumes",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public List<Resume> getAll() {
        log.debug("REST request to get all Resumes");
        return resumeRepository.findAll();
    }

    /**
     * GET  /rest/resumes/:id -> get the "id" resume.
     */
    @RequestMapping(value = "/rest/resumes/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @Timed
    public Resume get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get Resume : {}", id);
        Resume resume = resumeRepository.findOne(id);
        if (resume == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return resume;
    }

    /**
     * DELETE  /rest/resumes/:id -> delete the "id" resume.
     */
    @RequestMapping(value = "/rest/resumes/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @Timed
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to delete Resume : {}", id);
        resumeRepository.delete(id);
    }
}
