package com.gapsi.gapsiecommerce.repository;

import com.gapsi.gapsiecommerce.model.Proveedores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores,Long> {
    List<Proveedores> findByNombre(String Nombre);
}
