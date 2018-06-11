/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Paulo
 */
@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
    
    ArrayList lista = new ArrayList<>();
    
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        double freq = Double.parseDouble(req.getParameter("freq"));
        double p1 = Double.parseDouble(req.getParameter("p1"));
        double trab = Double.parseDouble(req.getParameter("trab"));
        double proj = Double.parseDouble(req.getParameter("proj"));
        double pf = Double.parseDouble(req.getParameter("pf"));
        
        lista.add(freq);
        lista.add(p1);
        lista.add(trab);
        lista.add(proj);
        lista.add(pf);
        lista.add(situacao(freq, p1, trab, proj, pf));
        
        String a = "notas";
        
        resp.getWriter().print("<table id=" + a + "><tr><td>Frequencia</td><td>P1</td><td>Trabs</td><td>Projs</td><td>PF</td><td>Situacao</td></tr>");
        for(int i = 0; i<=lista.size()-6; i+=6){
            resp.getWriter().print("<tr>");
            for(int j = i; j<i+6; j++){
                resp.getWriter().print("<td>" + lista.get(j) + "</td>");
            }
            resp.getWriter().print("</tr>");
            //resp.getWriter().print("<tr><td>"+ lista.get(i) +"</td><td>" + lista.get(i+1) +"</td></tr>");
            
        }
        resp.getWriter().print("</table>");
        
        req.getRequestDispatcher("index.html").include(req, resp);
        /*
        if(login.equals("Rotape")){
            if(senha.equals("senha")){
                req.getRequestDispatcher("login.html").include(req, resp);
            }
        }
        */
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
