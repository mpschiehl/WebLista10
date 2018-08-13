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
@WebServlet (urlPatterns = "/aluno/cadastro")
public class AlunoCadastro extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter out = resp.getWriter(); 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("	<title>Alunos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(" <label for='campo-nome'>Nome</label>");
        out.println(" <br></br>");
        out.println(" <input type='text' id='campo-nome' name='nome'>");
        out.println(" <br></br>");
        out.println("<label for='campo-nota1'>1 nota</label>");
        out.println(" <br></br>");
        out.println(" <input type='text' id='campo-nota1' name='nota1'>");
        out.println("<br></br>");
        out.println("<label for='campo-nota2'>2 Nota</label>");
        out.println(" <br></br>");
        out.println(" <input type='text' id='campo-nota2' name='nota2'>");
        out.println(" <br></br>");
        out.println("<label for='campo-nota3'>3 Nota</label>");
        out.println(" <br></br>");
        out.println(" <input type='text' id='campo-nota3' name='nota3'>");
        out.println("  <input class='btn btn-success' type='submit' value='Cadastrar'>");
        out.println("  ");
        out.println("</body>");
        out.println("</html>");
    }
           
    
}
