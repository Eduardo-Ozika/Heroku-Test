package org.acme.controller;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.MethodProperties;
import org.acme.model.Produto;

public interface ProdutoResouce extends PanacheEntityResource<Produto, Long> {
    @Override
    @MethodProperties(exposed = false)
    boolean delete(Long id);
}
