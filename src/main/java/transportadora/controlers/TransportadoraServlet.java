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

@WebServlet(name = "TransportadoraServlet", urlPatterns = {"/TransportadoraServlet"})
public class TransportadoraServlet extends HttpServlet {

 
    private static String INSERT_OR_EDIT = "transportadoraJSP";

    //LISTAR O USUARIO E FAZER O UPDATE E DELETE
    private static String LIST_USER = "listaTransportadoraJSP";

    private TransportadoraDAO dao;

    public TransportadoraServlet() {
        super();
        dao = new TransportadoraDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("acao");

        if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id_transportadora"));
            dao.excluir(id);
            forward = LIST_USER;
            request.setAttribute("transportadora_tb", dao.Listartodos());
        } else if (action.equalsIgnoreCase("editar")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id_transportadora"));
            Transportadora transportadora = dao.getTransportadoraById(id);
            request.setAttribute("transportadoraJSP", transportadora);
        } else if (action.equalsIgnoreCase("listaTransportadoraJSP")) {
            forward = LIST_USER;
            request.setAttribute("transportadora_tb", dao.Listartodos());
        } else if (action.equalsIgnoreCase("INSERT_OR_EDIT")) {
            
            forward = LIST_USER;
            request.setAttribute("transportadora_tb", dao.Listartodos());
        } else {
            forward = INSERT_OR_EDIT;
        }

        //Função de rediricionamento, no entanto, preciso codificar as JSP. Pos isso remover os comentarios
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /// METODO doPost
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Transportadora transportadora = new Transportadora();

   
        
        transportadora.setEmail(request.getParameter("email"));
        transportadora.setNome(request.getParameter("nome"));
        transportadora.setEmpresa(request.getParameter("empresa"));
        transportadora.setTelefone(request.getParameter("telefone"));
        transportadora.setCelular(request.getParameter("celular"));
        transportadora.setWhatsapp(request.getParameter("whatsapp"));
        transportadora.setModal(request.getParameter("modal"));
        transportadora.setCep(request.getParameter("cep"));
        transportadora.setUf(request.getParameter("uf"));
        transportadora.setCidade(request.getParameter("cidade"));
        transportadora.setBairro(request.getParameter("bairro"));
        transportadora.setRua(request.getParameter("rua"));
        transportadora.setNumero(request.getParameter("numero"));
        // CONVERTER LOGO 
        //transportadora.setLogo(request.getParameter("logo_transportadora"));
        
         
        String id = request.getParameter("id_transportadora");
        // Se ID for nulo ou vazio
        if(id == null || id.isEmpty()){
        dao.inserir(transportadora);
        } else {
        transportadora.setId(Integer.parseInt(id));
        dao.alterar(transportadora);
        
        //Função de rediricionamento, no entanto, preciso codificar as JSP. Pos isso remover os comentarios
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("transportadora_tb", dao.Listartodos());
        view.forward(request, response);
        
        }
           
    }
    
    protected void doTransportadora(){
     Transportadora transportadora = new Transportadora();

   
        
        transportadora.setEmail(request.getParameter("email"));
        transportadora.setNome(request.getParameter("nome"));
        transportadora.setEmpresa(request.getParameter("empresa"));
        transportadora.setTelefone(request.getParameter("telefone"));
        transportadora.setCelular(request.getParameter("celular"));
        transportadora.setWhatsapp(request.getParameter("whatsapp"));
        transportadora.setModal(request.getParameter("modal"));
        transportadora.setCep(request.getParameter("cep"));
        transportadora.setUf(request.getParameter("uf"));
        transportadora.setCidade(request.getParameter("cidade"));
        transportadora.setBairro(request.getParameter("bairro"));
        transportadora.setRua(request.getParameter("rua"));
        transportadora.setNumero(request.getParameter("numero"));
        // CONVERTER LOGO 
        //transportadora.setLogo(request.getParameter("logo_transportadora"));
        
         
        String id = request.getParameter("id_transportadora");
        // Se ID for nulo ou vazio
        if(id == null || id.isEmpty()){
        dao.inserir(transportadora);
        } else {
        transportadora.setId(Integer.parseInt(id));
        dao.alterar(transportadora);
        
        //Função de rediricionamento, no entanto, preciso codificar as JSP. Pos isso remover os comentarios
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("transportadora_tb", dao.Listartodos());
        view.forward(request, response);
        
        }
    }
}
    

