package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import mainPackage.Cem;
import mainPackage.Cinquenta;
import mainPackage.Dez;
import mainPackage.TemCredito;

public class DinheiroTest {
  String valor;
  HashMap<Double, Integer> map, map2;
  @Test
  public void testarCinquentaExato() throws Exception{
    map = new HashMap<>();
    map2 = new HashMap<>();
    map.put(50.00, 10);
    map2.putAll(map);

    valor = Cinquenta.executar(200, map2, map);

    //verifica a quantidade entregue de notas
    assertEquals(4 + " notas de R$50\n", valor);

    //verifica a quantidade extraida de notas
    int quant = map.get(50.00);  
    assertEquals(6,quant);
  }

  //este nao eh teste de unidade, pois dispara metodos de varias classes.
  @Test
  public void testarSistema() throws Exception{
    map = new HashMap<>();
    map2 = new HashMap<>();
    map.put(100.00,10);
    map.put(50.00, 10);
    map.put(20.00, 10);
    map.put(10.00,10);
    map2.putAll(map);

    int dez, vinte, cinquenta, cem;

    valor = Cem.executar(200, map2, map);

    dez = 10 - map.get(10.00);
    vinte = 10 - map.get(20.00);
    cinquenta = 10 - map.get(50.00);
    cem = 10 - map.get(100.00);

    if(map.get(10.00)<10){
      assertEquals(cem + " notas de R$100, "+cinquenta+" notas de R$50, "+vinte+" notas de R$20, "+dez+" notas de R$10.\n", valor);
    }else if(map.get(20.00)<10){
      assertEquals(cem + " notas de R$100, "+cinquenta+" notas de R$50, "+vinte+" notas de R$20\n", valor);
    }else if(map.get(50.00)<10){
      assertEquals(cem + " notas de R$100, "+cinquenta+" notas de R$50\n", valor);
    }else{
      assertEquals(cem + " notas de R$100\n", valor);
    }

  }

  @Test
  public void valorInconsistente(){
    map = new HashMap<>();
    map.put(100.00,10);
    map.put(50.00, 10);
    map.put(20.00, 10);
    map.put(10.00,10);

    boolean flag = false;

    try{
      TemCredito.sacar(25.12, map);
    }catch(Exception e){
      flag = true;
    }
    assertTrue(flag);
  }

  @Test
  public void notasFaltando(){
    map = new HashMap<>();
    map.put(10.00,10);
    boolean flag = false;
    try{
      Dez.executar(110.00, map, map);
    }catch(Exception e){
      flag = true;
    }
    assertTrue(flag);
  }
  
}
