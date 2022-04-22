/*
Essa classe verifica se o cliente tem credito antes de solicitar o saque
*/
package mainPackage;
import java.util.HashMap;

public class TemCredito{
    private static double credito = 500.00;
    public static String sacar(double valor, HashMap <Double, Integer> map1) throws Exception{
        if(valor>credito){
            throw new Exception("Credito Insuficiente");
        }else if(valor%10 != 0){
            throw new Exception("Valor indisponível. Temos apenas notas de 10, 20, 50 e 100");
        }
        HashMap<Double, Integer> map = new HashMap<>();
        map.putAll(map1);
        return Cem.executar(valor, map, map1);
    }
}
