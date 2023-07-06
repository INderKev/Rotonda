package com.rolosdev.seminarioproject;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.rolosdev.seminarioproject.entity.Restaurante;
import com.rolosdev.seminarioproject.entity.Stock;
import com.rolosdev.seminarioproject.repository.IRestauranteRepository;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class RestauranteRepositoryTest{

    @Autowired
    private IRestauranteRepository restauranteRepository;

    @Test
    public void mostrarlistaingredientes(){
        Restaurante restaurante = restauranteRepository.findById(1).get();
        List<Stock> stocksRestaurante = restaurante.getStocks();
        Iterator<Stock> iterStocksRestaurante = stocksRestaurante.iterator();

        while(iterStocksRestaurante.hasNext()){
            Stock stock = iterStocksRestaurante.next();
            System.out.println(
                stock.getIdStock() + " " +
                stock.getIngrediente().getIdIngrediente() + " " +
                stock.getIngrediente().getNombre() + " " +
                stock.getCantidadStock()
            );
        }
    }

}
