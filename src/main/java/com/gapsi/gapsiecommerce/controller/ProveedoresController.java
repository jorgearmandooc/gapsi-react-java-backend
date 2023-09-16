package com.gapsi.gapsiecommerce.controller;

import com.gapsi.gapsiecommerce.ProveedoresService;
import com.gapsi.gapsiecommerce.model.Proveedores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    @PostMapping
    public ResponseEntity<Proveedores> create(@RequestBody Proveedores proveedor){

        // VALIDAMOS SI YA EXISTE UN PROVEEDOR CON EL MISMO NOMBRE
        List<Proveedores> proveedorExists = proveedoresService.getByNombre(proveedor.getNombre());

        if(proveedorExists.size() > 0) {
            return new ResponseEntity<Proveedores>(null, null,HttpStatus.BAD_REQUEST);
        }
        
        // CREAMOS EL PROVEEDOR
        return new ResponseEntity<Proveedores>(proveedoresService.create(proveedor), null, HttpStatus.CREATED);

    }

    @GetMapping
    public Page<Proveedores> getAllWithPagination(@RequestParam(name="offset", defaultValue="0") String offset, @RequestParam(name="pageSize", defaultValue="20") String pageSize){
        return proveedoresService.getAllWithPagination( Integer.parseInt(offset), Integer.parseInt(pageSize) );
    }

    @GetMapping("{idProveedor}")
    public Proveedores getById(@PathVariable("idProveedor") Long idProveedor){
        return proveedoresService.getById(idProveedor);
    }

    @DeleteMapping("{idProveedor}")
    public void deleteById(@PathVariable("idProveedor") Long idProveedor){
         proveedoresService.delete(idProveedor);
    }

}