package com.tokioschool.flighthello.helloworld.service.impl;

import com.tokioschool.flighthello.helloworld.dto.HiMessageResponseDTO;
import com.tokioschool.flighthello.helloworld.service.HelloWorldService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloWorldServiceImplTest {

    private final HelloWorldService helloWorldService = new HelloWorldServiceImpl() ;

    @Test
    //@ParameterizedTest //Para parametrizar el test de modo que testee varias cosas
    void givenNullName_whenGetHiMessage_thenReturnOk() {
        HiMessageResponseDTO response = helloWorldService.getHiMessage(null);
        Assertions.assertEquals("Hello world dude", response.getMessage());

    }
    @Test
    void givenEmptyName_whenGetHiMessage_thenReturnOk() {
        HiMessageResponseDTO response = helloWorldService.getHiMessage("");
        Assertions.assertEquals("Hello world dude", response.getMessage());

    }
    @Test
    void givenEmptyNoTrimmedName_whenGetHiMessage_thenReturnOk() {
        HiMessageResponseDTO response = helloWorldService.getHiMessage(" ");
        Assertions.assertEquals("Hello world dude", response.getMessage());

    }
    @Test
    void givenName_whenGetHiMessage_thenReturnOk() {
        HiMessageResponseDTO response = helloWorldService.getHiMessage("bla");
        Assertions.assertEquals("Hello world bla", response.getMessage());

    }

}