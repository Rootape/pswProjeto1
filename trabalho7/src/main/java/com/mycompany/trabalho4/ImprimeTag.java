/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho4;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author João Paulo
 */
public class ImprimeTag extends SimpleTagSupport{
    
    private List<Aluno> lista;
    
    @Override
    public void doTag() throws JspException, IOException{
        String selectHtml = "";
        for(Aluno a : lista){
            selectHtml += "<tr>\n" +
"                        <td>" + a.getNome() +"</td>\n" +
"                        <td>" + a.getFrequencia() +"</td>\n" +
"                        <td>" + a.getP1() +"</td>\n" +
"                        <td>" + a.getTrab() +"</td>\n" +
"                        <td>" + a.getProj() +"</td>\n" +
"                        <td>" + a.getPf() +"</td>\n" +
"                        <td>" + a.situacao() +"</td>\n" +
"                    </tr>";
        }
        getJspContext().getOut().print(selectHtml);
    }

    public List<Aluno> getLista() {
        return lista;
    }

    public void setLista(List<Aluno> lista) {
        this.lista = lista;
    }
    
    
}
