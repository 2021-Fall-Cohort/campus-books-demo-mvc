package wcci.demo;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import wcci.demo.repos.CampusRepository;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CampusController.class)
public class CampusControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CampusRepository campusRepo;

    @MockBean
    private BookRepository bookRepo;

    @MockBean
    private AuthorRepository authorRepo;

    @Mock
    private Campus campusMock;

    @Test
    public void shouldWorkForShowCampuses() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("campuses"));
    }

    @Test
    public void shouldGetCampusInModel() throws Exception {
        Collection<Campus> tempCampuses = Arrays.asList(campusMock);
        when(campusRepo.findAll()).thenReturn(tempCampuses);
        mockMvc.perform(get("/")).andExpect(model().attribute("campuses", tempCampuses));
    }
}
