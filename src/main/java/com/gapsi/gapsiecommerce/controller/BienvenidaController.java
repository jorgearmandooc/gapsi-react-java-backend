package com.gapsi.gapsiecommerce.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("bievenida")
public class BienvenidaController {

    @GetMapping
    public Map<String, String> getBievenida(){
        HashMap<String, String> map = new HashMap<>();
        map.put("bienvenida", "Bienvenido Candidato 01");
        map.put("version", "0.0.1");
        map.put("img", "https://picsum.photos/200/200");
        return map;
    }
}
