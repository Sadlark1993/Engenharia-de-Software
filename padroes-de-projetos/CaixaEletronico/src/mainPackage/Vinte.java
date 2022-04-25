//A execucao dessa classe eh similar a classe Cem. Veja os comentarios de la.
package mainPackage;

import java.util.HashMap;

public class Vinte {
    public static String executar(double valor, HashMap<Double, Integer> map,HashMap<Double, Integer> map1)throws Exception{
        int aux = (int) valor/20;
        if(map.get(20.00)>aux){
            map.put(20.00, map.get(20.00)-aux);
        }else{
            aux = map.get(20.00);
            map.put(20.00,0);
        }
        valor = valor - aux*20;
        
        if(valor==0){
            map1.putAll(map);
            return aux + " notas de R$20\n";
        }
        return aux + " notas de R$20, "+ Dez.executar(valor, map, map1);
    }
}
