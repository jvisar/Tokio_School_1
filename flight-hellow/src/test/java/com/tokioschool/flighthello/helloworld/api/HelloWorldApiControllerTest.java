package com.tokioschool.flighthello.helloworld.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tokioschool.flighthello.helloworld.dto.HiMessageResponseDTO;
import com.tokioschool.flighthello.helloworld.service.HelloWorldService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloWorldApiController.class)
public class HelloWorldApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HelloWorldService helloWorldService;

    @Test
    void givenGetHiRequest_whenRequested_thenReponseIsOk() throws Exception{
        String hiMessage = "Hello World bla";

        Mockito.when(helloWorldService.getHiMessage("bla"))
                .thenReturn(new HiMessageResponseDTO(hiMessage));
        String response = mockMvc
                .perform(MockMvcRequestBuilders.get("/helloworld/api/hi?name=bla"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        HiMessageResponseDTO hiMessageResponseDTO = objectMapper.readValue(response, HiMessageResponseDTO.class);
        Assertions.assertEquals(hiMessage, hiMessageResponseDTO.getMessage());
    }
}
