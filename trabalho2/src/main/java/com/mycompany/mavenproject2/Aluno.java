/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

/**Classe que representa um aluno em uma disciplina
 *
 * @author João Paulo
 * @version 1.0
 */
public class Aluno {

    /**Método que informa a situção do aluno na disciplina 
     * 
     * @param Frequencia
     * @param P1
     * @param Trabalho
     * @param ProjetosEmAula
     * @param PF
     * @return String - Situação do aluno (Aprovado ou Reprovado)
     */
    
    public String situacao(double Frequencia, double P1, double Trabalho, double ProjetosEmAula, double PF){
                
        String situaçao;
        double M1 = 0.7 * ((P1 + Trabalho)/2)+ProjetosEmAula * 0.3;
        System.out.println(M1);
        
        if(Frequencia >= 75){
            System.out.println("Tem frequencia");
            if(M1 >= 70){ 
                System.out.println("Aprovado direto");
                situaçao = "Aprovado";
            }
            else if (M1 < 30){ 
                System.out.println("Reprovado direto");
                situaçao = "Reprovado";
            }
            else{
                if(((PF + M1)/2) >= 50){
                    System.out.println("Aprovado na PF");
                    situaçao = "Aprovado";
                }
                else{
                    System.out.println("Reprovado na PF");
                    situaçao = "Reprovado";
                }
            }
        }else{
            System.out.println("Reprovado por presença");
            situaçao = "Reprovado";
        }
        
        return situaçao;
    }
    
}
