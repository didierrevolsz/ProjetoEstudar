
package transportadora.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import transportadora.dao.TransportadoraDAO;
import transportadora.models.Transportadora;


@WebServlet(name = "TransportadoraControllador", urlPatterns = {"/TransportadoraControllador"})
public class TransportadoraControllador extends HttpServlet {

// minha variavel dao sera responsaveis por trazer meus metodos de assinatura da classe TransportadoraDAO    
// inserir, alerar, excluir, Listartodos, ListatodosDescricao, getTransportadoraById 
private TransportadoraDAO dao;
    
    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;

}   

protected void doTransportadora(){
Transportadora transportadora = new Transportadora();

}

}
