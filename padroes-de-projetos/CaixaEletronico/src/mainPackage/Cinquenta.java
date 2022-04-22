//A execucao dessa classe eh similar a classe Cem. Veja os comentarios de la.
package mainPackage;
import java.util.HashMap;

public class Cinquenta {
    public static String executar(double valor, HashMap<Double, Integer> map,HashMap<Double, Integer> map1)throws Exception{
        int aux = (int) valor/50;
        if(map.get(50.00)>aux){
            map.put(50.00, map.get(50.00)-aux);
        }else{
            aux = map.get(50.00);
            map.put(50.00,0);
        }
        valor = valor - aux*50;
        
        if(valor==0){
            map1.putAll(map);
            return aux + " notas de R$50\n";
        }
        return aux + " notas de  R$50, "+ Vinte.executar(valor, map, map1);
    }
}
