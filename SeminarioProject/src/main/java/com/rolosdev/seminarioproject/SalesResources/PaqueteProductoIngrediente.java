package com.rolosdev.seminarioproject.SalesResources;

import com.rolosdev.seminarioproject.entity.Ingrediente;
import com.rolosdev.seminarioproject.entity.ProductoIngrediente;

public class PaqueteProductoIngrediente {

    public ProductoIngrediente productoIngrediente;
    public Ingrediente ingrediente;

    public ProductoIngrediente getProductoIngrediente() {
        return productoIngrediente;
    }

    public void setProductoIngrediente(ProductoIngrediente productoIngrediente) {
        this.productoIngrediente = productoIngrediente;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}
