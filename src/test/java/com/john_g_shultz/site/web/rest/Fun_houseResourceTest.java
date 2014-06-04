package com.john_g_shultz.site.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.john_g_shultz.site.Application;
import com.john_g_shultz.site.domain.Fun_house;
import com.john_g_shultz.site.repository.Fun_houseRepository;


/**
 * Test class for the Fun_houseResource REST controller.
 *
 * @see Fun_houseResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class })
@ActiveProfiles("dev")
public class Fun_houseResourceTest {
	
    private static final Long DEFAULT_ID = new Long(1L);

    private static final LocalDate DEFAULT_SAMPLE_DATE_ATTR = new LocalDate(0L);

    private static final LocalDate UPD_SAMPLE_DATE_ATTR = new LocalDate();

    private static final String DEFAULT_SAMPLE_TEXT_ATTR = "sampleTextAttribute";

    private static final String UPD_SAMPLE_TEXT_ATTR = "sampleTextAttributeUpt";

    @Inject
    private Fun_houseRepository fun_houseRepository;

    private MockMvc restFun_houseMockMvc;
    
    private Fun_house fun_house;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Fun_houseResource fun_houseResource = new Fun_houseResource();
        ReflectionTestUtils.setField(fun_houseResource, "fun_houseRepository", fun_houseRepository);

        this.restFun_houseMockMvc = MockMvcBuilders.standaloneSetup(fun_houseResource).build();

        fun_house = new Fun_house();
        fun_house.setId(DEFAULT_ID);
    	fun_house.setSampleDateAttribute(DEFAULT_SAMPLE_DATE_ATTR);
    	fun_house.setSampleTextAttribute(DEFAULT_SAMPLE_TEXT_ATTR);
    }

    @Test
    public void testCRUDFun_house() throws Exception {

    	// Create Fun_house
    	restFun_houseMockMvc.perform(post("/app/rest/fun_houses")
    			.contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(fun_house)))
                .andExpect(status().isOk());

    	// Read Fun_house
    	restFun_houseMockMvc.perform(get("/app/rest/fun_houses/{id}", DEFAULT_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(DEFAULT_ID.intValue()))
    			.andExpect(jsonPath("$.sampleDateAttribute").value(DEFAULT_SAMPLE_DATE_ATTR.toString()))
    			.andExpect(jsonPath("$.sampleTextAttribute").value(DEFAULT_SAMPLE_TEXT_ATTR));

    	// Update Fun_house
    	fun_house.setSampleDateAttribute(UPD_SAMPLE_DATE_ATTR);
    	fun_house.setSampleTextAttribute(UPD_SAMPLE_TEXT_ATTR);
  
    	restFun_houseMockMvc.perform(post("/app/rest/fun_houses")
    			.contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(fun_house)))
                .andExpect(status().isOk());

    	// Read updated Fun_house
    	restFun_houseMockMvc.perform(get("/app/rest/fun_houses/{id}", DEFAULT_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(DEFAULT_ID.intValue()))
    			.andExpect(jsonPath("$.sampleDateAttribute").value(UPD_SAMPLE_DATE_ATTR.toString()))
    			.andExpect(jsonPath("$.sampleTextAttribute").value(UPD_SAMPLE_TEXT_ATTR));

    	// Delete Fun_house
    	restFun_houseMockMvc.perform(delete("/app/rest/fun_houses/{id}", DEFAULT_ID)
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

    	// Read nonexisting Fun_house
    	restFun_houseMockMvc.perform(get("/app/rest/fun_houses/{id}", DEFAULT_ID)
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());

    }
}
