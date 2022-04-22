/*
-> A proposta desse programa eh implementar o modelo de design de projeto Template 
Method, por meio de um algoritmo que simula um irrigador automatico programavel.
 */

package mainPackage;

import javax.swing.JOptionPane;


public class Irrigador {

    public static void main(String[] args) {
        int aux = 0;
        boolean irrigar;
        
        IrrigarPlanta hortaMelancia1 = new IrrigarMelancia();
        String sMelancia1;
        
        IrrigarPlanta hortaTomate1 = new IrrigarTomate();
        String sTomate1;
        
        IrrigarPlanta pomarUva1 = new IrrigarUva();
        String sUva1;
        
    
        
        while(aux==0){
            
            
            irrigar = hortaMelancia1.ligarSolenoide();
            if(irrigar){
                sMelancia1 = "Melancia 01: ligado\n";
            }else{
                sMelancia1 = "Melancia 01: desligado\n";
            }
            
            irrigar = hortaTomate1.ligarSolenoide();
            if(irrigar){
                sTomate1 = "Tomate 01: ligado\n";
            }else{
                sTomate1 = "Tomate 01: desligado\n";
            }
            
            irrigar = pomarUva1.ligarSolenoide();
            if(irrigar){
                sUva1 = "Uva 01: ligado\n";
            }else{
                sUva1 = "Uva 01: desligado\n";
            }
            
            aux = JOptionPane.showConfirmDialog(null, sMelancia1+sTomate1+sUva1+"\nClique em \"sim\" para verificar"
                + " qual solenoide está ligado.");
        }
    }
    
}
