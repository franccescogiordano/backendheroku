package co.com.sofka.ServerSide.controllers;

import co.com.sofka.ServerSide.service.VendedorService;
import co.com.sofka.ServerSide.model.VendedorModel;

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
@RequestMapping("/vendedor")
public class VendedorController {
    
    @Autowired
    private VendedorService vendedorService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<VendedorModel> save(@RequestBody VendedorModel vendedor) {
        return this.vendedorService.save(vendedor);
    }

    @GetMapping(value = "")
    public Flux<VendedorModel> findAll() {
        return this.vendedorService.findAll();
    }
}
