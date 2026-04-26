package com.tokioschool.flighthello.helloworld.service.impl;

import com.tokioschool.flighthello.helloworld.dto.HiMessageResponseDTO;
import com.tokioschool.flighthello.helloworld.service.HelloWorldService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Component //No es punto de entrada, tiene función más concreta
public class HelloWorldServiceImpl implements HelloWorldService {

    private static final String DEFAULT_HI_PHRASE = "Hello world dude";
    private static final String HI_PHRASE = "Hello world %s";

    @Override
    public HiMessageResponseDTO getHiMessage(String name) {

        String message = Optional.ofNullable(StringUtils.trimToNull(name))
                .map(s -> HI_PHRASE.formatted(s))
                .orElse(DEFAULT_HI_PHRASE);
        // El Optional anterior sustituye al siguiente código:
        /*if (name == null || name.equals(""))
            return DEFAULT_HI_PHRASE;
        else
            return HI_PHRASE.formatted(name);*/

        return HiMessageResponseDTO.builder()
                .message(message)
                .build();
    }
}
