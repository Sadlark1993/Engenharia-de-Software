
package mainPackage;
import java.util.*;
public class Cem {
    public static String executar(double valor, HashMap<Double, Integer> map, HashMap<Double, Integer> map1)throws Exception{
        int aux = (int) valor/100; //divisao inteira pelo valor da nota
        if(map.get(100.00)>aux){//se tiver notas o suficiente:
            map.put(100.00, map.get(100.00)-aux); 
        }else{ // se não tiver notas o suficiente:
            aux = map.get(100.00);
            map.put(100.00,0);
        }
        valor = valor - aux*100;
        
        //se valor==0, ele finalisa o saque, senao, ele transfere a responsabilidade
        if(valor==0){
            map1.putAll(map);
            return aux + " notas de R$100\n";
        }
        return aux + " notas de  R$100, "+ Cinquenta.executar(valor, map, map1);
    }
}
