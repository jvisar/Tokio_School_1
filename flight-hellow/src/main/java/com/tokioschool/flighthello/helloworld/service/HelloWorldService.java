package com.tokioschool.flighthello.helloworld.service;

import com.tokioschool.flighthello.helloworld.dto.HiMessageResponseDTO;

public interface HelloWorldService {

    HiMessageResponseDTO getHiMessage(String name);
}
