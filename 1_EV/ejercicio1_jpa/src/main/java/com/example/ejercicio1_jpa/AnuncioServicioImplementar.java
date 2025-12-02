package com.example.ejercicio1_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnuncioServicioImplementar implements AnuncioServicio{

    @Autowired
    private AnuncioRepository repositorio;

    @Override
    public List<Anuncio> listarAnuncio() {
        return repositorio.findAll();
    }

    @Override
    public Anuncio guardarAnuncio(Anuncio anuncio) {
        return repositorio.save(anuncio);
    }

    @Override
    public Anuncio obtenerAnuncio(Integer id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Anuncio actualizarAnuncio(Anuncio anuncio) {
        return repositorio.save(anuncio);
    }

    @Override
    public void borrarAnuncio(Integer id) {
        repositorio.deleteById(id);
    }

}
