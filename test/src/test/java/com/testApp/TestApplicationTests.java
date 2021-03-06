package com.testApp;

import com.projectA.TestServiceA;
import com.projectB.TestServiceB;
import com.testApp.controller.TestRestApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Mock
    private TestServiceA testServiceA;

    @Mock
    private TestServiceB testServiceB;

    @InjectMocks
    private TestRestApp testRestApp;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(testRestApp).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMessageA() throws Exception {
        when(testServiceA.getMessageFromServiceA()).thenReturn("Message A");
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(testRestApp).build();

        mockMvc.perform(get("/get-message-a"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMessageB() throws Exception {
        when(testServiceB.getMessageFromServiceB()).thenReturn("Message B");
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(testRestApp).build();

        mockMvc.perform(get("/get-message-b"))
                .andExpect(status().isOk());
    }
}
