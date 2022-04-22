//A execucao dessa classe eh similar a classe Cem. Veja os comentarios de la.
package mainPackage;

import java.util.HashMap;

public class Dez {
    public static String executar(double valor, HashMap<Double, Integer> map, HashMap<Double, Integer> map1) throws Exception{
        int aux = (int) valor/10;
        if(map.get(10.00)>aux){
            map.put(10.00, map.get(10.00)-aux);
        }else{
            aux = map.get(10.00);
            map.put(10.00,0);
        }
        valor = valor - aux*10;
        if(valor != 0){
            throw new Exception("Erro. Notas insuficientes. Faltou "+valor+"\n");
        }
        map1.putAll(map);
        return aux + " notas de  R$10.\n";
    }
}
