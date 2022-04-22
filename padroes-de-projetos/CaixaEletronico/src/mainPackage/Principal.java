/*
-> A proposta desse programa eh implementar o modelo de design de projeto Chain of 
Responsability, por meio de um algoritmo que simula um saque em um caixa eletronico.
 */
package mainPackage;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) throws Exception {
        boolean verbose = false; //debug
        File tabela = new File("tabela.txt");
        HashMap<Double, Integer> map = new HashMap<>();
        String aux, linha[];
        
        //popula o dicionario map com os valores do arquivo.
        try{
            Scanner leitor = new Scanner(tabela);
            while(leitor.hasNext()){
                aux = leitor.nextLine();
                linha = aux.split(",");
                map.put(Double.parseDouble(linha[0].trim()), 
                        Integer.parseInt(linha[1].trim()));
            }
            leitor.close();
            
        }catch(FileNotFoundException e){
            System.out.println("Erro na leitura do arquivo. " +
                    e.getMessage());
        }
        
        //para debug
        if(verbose){
            System.out.println(map.get(100.00));
        }
        
        //coleta o valor a ser sacado
        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor de saque,"
                + "usando \".\" como separador decimal: ", "Saque", 
                JOptionPane.INFORMATION_MESSAGE));
        
        //Inicia a execucao do saque e imprime o resultado
        String resultado = TemCredito.sacar(valor, map);
        System.out.println(resultado);
        
        if(verbose){ //debug
            System.out.println(map.toString());
        }
        
        //atualiza dados no arquivo
        try{
            aux = "";
            FileWriter myWriter = new FileWriter("tabela.txt");
            for(Map.Entry<Double, Integer> e : map.entrySet()){
                aux += e.getKey()+","+e.getValue()+"\n";
            }
            myWriter.write(aux);
            myWriter.close();
        }catch(IOException e){
            System.out.println("Erro ao escrever no arquivo: "+e.getMessage());
        }
    }
    
}
