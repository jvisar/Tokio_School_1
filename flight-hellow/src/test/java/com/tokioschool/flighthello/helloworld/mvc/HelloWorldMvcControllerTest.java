package com.tokioschool.flighthello.helloworld.mvc;

import com.tokioschool.flighthello.helloworld.dto.HiMessageResponseDTO;
import com.tokioschool.flighthello.helloworld.service.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloWorldMvcController.class)
public class HelloWorldMvcControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWorldService helloWorldService;

@Test
    void givenGetHiRequest_whenRequested_thenReponseIsOk() throws Exception{
        String hiMessage = "Hello World bla";

        Mockito.when(helloWorldService.getHiMessage("bla"))
                .thenReturn(new HiMessageResponseDTO(hiMessage));
        String response = mockMvc
                .perform(MockMvcRequestBuilders.get("/helloworld?name=bla"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("helloworld/index"))
                .andExpect(MockMvcResultMatchers.model().attribute("message", hiMessage))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }
}
