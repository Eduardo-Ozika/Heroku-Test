package org.acme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Produto extends AbastractEntity{
    @Version
    @Column(columnDefinition ="int default 0")
    public Long version = 0L;
    public  String nome;
    @Column(unique = true,nullable = false)
    @NotBlank
    public String descricao;
    @ManyToOne
    public Categoria categoria;

    public void setNome(String nome) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.nome=nome.trim().toUpperCase();
    }
}
