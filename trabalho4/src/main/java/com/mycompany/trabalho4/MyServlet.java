/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.trabalho4.Aluno;

/**
 *
 * @author João Paulo
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    
    public static boolean isNumeric(String str){  
        try {  
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe){  
        return false;  
        }  
        return true;  
    }
    
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        if(req.getParameter("lista") == null){
            List notas = new ArrayList();
            req.setAttribute("lista", notas);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getServletContext().getAttribute("lista") == null){
            List notas = new ArrayList();
            req.getServletContext().setAttribute("lista", notas);
        }
        
        boolean isValid = true;
        
        if(req.getParameter("nome").equals("")){
            System.out.println("Entrei no nome");
            req.setAttribute("msgNome", "  O nome é obrigatorio!");
            isValid = false;
        }
        
        if(!isNumeric(req.getParameter("freq")) || req.getParameter("freq").equals("")){
            req.setAttribute("msgFreq", "  Frequencia é obrigatorio e numerico");
            isValid = false;
        }
        if(!isNumeric(req.getParameter("p1")) || req.getParameter("p1").equals("")){
            req.setAttribute("msgP1", "  P1 é obrigatorio e numerico");
            isValid = false;
        }
        if(!isNumeric(req.getParameter("trab")) || req.getParameter("trab").equals("")){
            req.setAttribute("msgTrab", "  Trabalhos é obrigatorio e numerico");
            isValid = false;
        }
        if(!isNumeric(req.getParameter("proj")) || req.getParameter("proj").equals("")){
            req.setAttribute("msgProj", "  Projeto é obrigatorio e numerico");
            isValid = false;
        }
        if(!isNumeric(req.getParameter("pf")) || req.getParameter("pf").equals("")){
            req.setAttribute("msgPf", "  PF é obrigatorio e numerico");
            isValid = false;
        }
        
        if(isValid){
            String nome = req.getParameter("nome");
            String freq = req.getParameter("freq");
            String p1 = req.getParameter("p1");
            String trab = req.getParameter("trab");
            String proj = req.getParameter("proj");
            String pf = req.getParameter("pf");
            String a = situacao(Double.parseDouble(freq), Double.parseDouble(p1), Double.parseDouble(trab)
            , Double.parseDouble(proj), Double.parseDouble(pf));
        
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
        else{
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
