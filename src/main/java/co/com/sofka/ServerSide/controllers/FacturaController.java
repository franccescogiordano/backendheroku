package co.com.sofka.ServerSide.controllers;
import co.com.sofka.ServerSide.service.FacturaService;
import co.com.sofka.ServerSide.model.FacturaModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import reactor.core.publisher.Flux;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<FacturaModel> save(@RequestBody FacturaModel cliente) {
        return this.facturaService.save(cliente);
    }

    @GetMapping(value = "")
    public Flux<FacturaModel> findAll() {
        return this.facturaService.findAll();
    }
}
