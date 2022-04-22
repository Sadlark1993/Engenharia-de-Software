/*Dicionario:
*1: humidade do solo;
*2: pausado;
*/
package mainPackage;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;


public abstract class IrrigarPlanta {
    public boolean coletarExternos(){
        File arquivo = new File("dadosExternos.txt");
        HashMap<Integer, Integer> map = new HashMap<>();
        String aux, linha[];
        try{
            Scanner myReader = new Scanner(arquivo);
            while(myReader.hasNext()){
                aux = myReader.nextLine();
                linha = aux.split(";");
                map.put(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]));
            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado: "+e.getMessage());
        }
        
        if(map.get(1)<60 && map.get(2)==1){
            return true;
        }
        return false;
    }
    
    public abstract boolean ligarSolenoide();
    
}
