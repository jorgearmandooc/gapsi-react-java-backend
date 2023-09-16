package com.gapsi.gapsiecommerce;

import com.gapsi.gapsiecommerce.model.Proveedores;
import com.gapsi.gapsiecommerce.repository.ProveedoresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProveedoresService {
    @Autowired
    private ProveedoresRepository proveedoresRepository;

    public Proveedores create(Proveedores proveedor){
        return proveedoresRepository.save(proveedor);
    }

    public Proveedores getById(Long idProveedor){
        Optional<Proveedores> proveedor = proveedoresRepository.findById(idProveedor);
        return proveedor.get();
    }

    public List<Proveedores> getAll(){
        return proveedoresRepository.findAll();
    }

    public Page<Proveedores> getAllWithPagination(Integer offset, Integer pageSize){
        return proveedoresRepository.findAll( PageRequest.of(offset, pageSize));
    }

    public List<Proveedores> getByNombre(String nombre) {
       return proveedoresRepository.findByNombre(nombre);
    }

    public void delete(Long idProveedor){
        proveedoresRepository.deleteById(idProveedor);
    }

}
