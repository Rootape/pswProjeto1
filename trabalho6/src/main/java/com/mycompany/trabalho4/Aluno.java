/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho4;

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
    String nome;
    Double frequencia;
    Double p1;
    Double trab;
    Double proj;
    Double pf;
    
    public Aluno(String nome, Double frequencia, Double p1, Double trab, Double proj, Double pf){
        this.nome=nome;
        this.frequencia = frequencia;
        this.p1 = p1;
        this.pf=pf;
        this.proj=proj;
        this.trab=trab;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }

    public Double getP1() {
        return p1;
    }

    public void setP1(Double p1) {
        this.p1 = p1;
    }

    public Double getTrab() {
        return trab;
    }

    public void setTrab(Double trab) {
        this.trab = trab;
    }

    public Double getProj() {
        return proj;
    }

    public void setProj(Double proj) {
        this.proj = proj;
    }

    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
    }
    
    public String situacao(){
                
        String situaçao;
        double M1 = 0.7 * ((p1 + trab)/2)+proj * 0.3;
        System.out.println(M1);
        
        if(frequencia >= 75){
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
                if(((pf + M1)/2) >= 50){
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
