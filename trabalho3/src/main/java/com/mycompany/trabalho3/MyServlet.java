/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Paulo
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    
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
            out.println("<title>Servlet MyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        if(req.getServletContext().getAttribute("lista") == null){
            //System.out.println("kkk criei lista");
            List notas = new ArrayList();
            req.getServletContext().setAttribute("lista", notas);
            int iter = 0;
            req.getServletContext().setAttribute("iter", iter);
        }
        
        String nome = req.getParameter("nome");
        Double freq = Double.parseDouble(req.getParameter("freq"));
        Double p1 = Double.parseDouble(req.getParameter("p1"));
        Double trab = Double.parseDouble(req.getParameter("trab"));
        Double proj = Double.parseDouble(req.getParameter("proj"));
        Double pf = Double.parseDouble(req.getParameter("pf"));
        
        String a = situacao(freq, p1, trab, proj, pf);
        
        List notas = (List)(req.getServletContext().getAttribute("lista"));
        
        notas.add(nome);
        notas.add(freq);
        notas.add(p1);
        notas.add(trab);
        notas.add(proj);
        notas.add(pf);
        notas.add(a);
        
        req.getServletContext().setAttribute("lista", notas);
        
        System.out.println((List)(req.getServletContext().getAttribute("lista")));
        
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
