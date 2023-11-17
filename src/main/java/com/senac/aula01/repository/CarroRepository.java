/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senac.aula01.repository;

import com.senac.aula01.model.Carro;
import com.senac.aula01.model.CarroNomeCor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fabiano.oss
 */
public interface CarroRepository extends JpaRepository<Carro, Long>{
    
    @Query("select new com.senac.aula01.model.CarroNomeCor(c.nome, c.cor) from Carro c order by c.nome")
    public List<CarroNomeCor> findCarroNomeCor();
    
}
