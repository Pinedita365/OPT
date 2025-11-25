package com.example.ejercicio1_jpa;

import java.util.List;

public interface AnuncioServicio {
    public List<Anuncio> listarAnuncio();

    public Anuncio guardarAnuncio(Anuncio anuncio);

    public Anuncio obtenerAnuncio(Integer id);

    public Anuncio actualizarAnuncio(Anuncio anuncio);

    public void borrarAnuncio(Integer id);
}
