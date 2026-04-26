package com.tokioschool.flighthello.helloworld.mvc;

import com.tokioschool.flighthello.helloworld.service.HelloWorldService;
import com.tokioschool.flighthello.helloworld.dto.HiMessageResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller//->La respuesta que va a dar debe ser del tipo model and view (formato HTML)
@RequiredArgsConstructor
public class HelloWorldMvcController {

    private final HelloWorldService helloWorldService;

    @GetMapping("/helloworld")
    public ModelAndView getHi(@RequestParam(name="name", required=false) String name){

        HiMessageResponseDTO hiMessageResponseDTO = helloWorldService.getHiMessage(name);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("helloworld/index");
        modelAndView.addObject("message", hiMessageResponseDTO.getMessage());
        return modelAndView;

    }
}
