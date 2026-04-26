package com.tokioschool.flighthello.helloworld.api;

import com.tokioschool.flighthello.helloworld.dto.HiMessageResponseDTO;
import com.tokioschool.flighthello.helloworld.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//->La respuesta que va a dar debe ser serializable (cadena de texto) en formato Json
@RequestMapping("/helloworld/api/hi")//-> Endpoint por el que va a responder este controlador
                // -> aquí lo definimos a nivel de clase, también puede hacerse a nivel de método
@RequiredArgsConstructor// -> para la inyección de dependencias del servicio
public class HelloWorldApiController {

    private final HelloWorldService helloWorldService;

    @GetMapping // -> indica que es el método que se ejecutará para dar respuesta
                // a la llamada al endpoint que gestiona el controlador
    public ResponseEntity<HiMessageResponseDTO>getHi(
            @RequestParam(value = "name", required = false) String name)
    {
        HiMessageResponseDTO hiMessageResponseDTO = helloWorldService.getHiMessage(name);

        return ResponseEntity.ok(hiMessageResponseDTO);
    }
}
