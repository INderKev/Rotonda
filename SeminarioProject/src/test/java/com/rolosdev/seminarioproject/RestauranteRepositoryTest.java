package com.rolosdev.seminarioproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.rolosdev.seminarioproject.entity.Restaurante;
import com.rolosdev.seminarioproject.entity.Stock;
import com.rolosdev.seminarioproject.repository.IRestauranteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RestauranteRepositoryTest{

@Autowired
private IRestauranteRepository restauranteRepository;
@Autowired
private TestEntityManager entityManager;
@Test
public void mostrarlistaingredientes(){
    Restaurante hola=restauranteRepository.findById(1).get();
    List<Stock> stack=hola.getStocks();
    Iterator<Stock> a=stack.iterator();
    while(a.hasNext()){
        Stock b=a.next();
    System.out.println(b.getIdStock()+" "+b.getIdIngrediente()+" "+b.getIngrediente().getNombre()+" "+b.getCantidadStock());
    }
    
}

}