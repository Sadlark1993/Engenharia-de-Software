
package mainPackage;

import java.time.LocalTime;


public class IrrigarUva extends IrrigarPlanta{
    @Override
    public boolean ligarSolenoide(){
        
        LocalTime agora = LocalTime.now();
        System.out.println("agora: "+agora);
        
        LocalTime time1 = LocalTime.parse("10:00:00");
        LocalTime time2 = LocalTime.parse("16:00:00");

        
        int maior = agora.compareTo(time1);
        int menor = agora.compareTo(time2);

        
        boolean dados = coletarExternos();
        
        if(dados){
            if((maior>0 && menor<0)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
