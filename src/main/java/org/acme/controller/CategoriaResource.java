package org.acme.controller;

import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;
import org.acme.model.Categoria;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Transactional
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        //System.out.println("Excluindo " + id);
        Categoria.deleteById(id);
    }

    @GET
    @Path("{id}")
    public Categoria getById(@PathParam("id") long id) {
        return Categoria.findById(id);
    }

    @Transactional
    @POST
    public void insert(Categoria categoria) {
        EntityManager em = Categoria.getEntityManager();
        em.persist(categoria);
    }

    @GET
    public List<Categoria> getAll(){
        return Categoria.listAll();
    }

    @Transactional
    @Path("/{id}")
    @PUT
    public void update(@PathParam("id") Long id,Categoria categoria){
        try {
            var em = JpaOperations.INSTANCE.getEntityManager();
            em.merge(categoria);
        } catch (Exception e) {
            throw new WebApplicationException("Registro alterado por outro usuario");
        }
    }
}