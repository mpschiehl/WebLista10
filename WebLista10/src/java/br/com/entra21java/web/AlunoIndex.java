/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Márcio Pedro Schiehl
 */
@ WebServlet (urlPatterns = "/aluno")
public class AlunoIndex extends HttpServlet{
    private PrintWriter out;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out = resp.getWriter();
        out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("	<title>Alunos</title>");
out.println("</head>");
out.println("<body>");
out.println(" teste ");
out.println("</body>");
out.println("</html>");
    }
    
}
