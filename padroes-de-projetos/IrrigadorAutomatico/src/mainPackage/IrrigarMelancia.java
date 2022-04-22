
package mainPackage;

import java.time.LocalTime;


public class IrrigarMelancia extends IrrigarPlanta {
    
    @Override
    public boolean ligarSolenoide(){
        
        LocalTime agora = LocalTime.now();
        System.out.println("agora: "+agora);
        
        LocalTime time1 = LocalTime.parse("06:00:00");
        LocalTime time2 = LocalTime.parse("08:00:00");
        LocalTime time3 = LocalTime.parse("14:00:00");
        LocalTime time4 = LocalTime.parse("16:00:00");
        
        int maior = agora.compareTo(time1);
        int menor = agora.compareTo(time2);
        
        int maior2 = agora.compareTo(time3);
        int menor2 = agora.compareTo(time4);
        
        boolean dados = coletarExternos();
        
        if(dados){
            if((maior>0 && menor<0)||(maior2>0 && menor2<0)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
