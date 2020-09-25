package transportadora.dao;

import transportadora.models.Transportadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class TransportadoraDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Transportadora> lista = new ArrayList<Transportadora>();

//getConnection    
    public TransportadoraDAO() {
        conn = new ConnectionFactory().getConnection();
    }

// Criando a assinatura do metodo inserir
    public void inserir(Transportadora transportadora) throws FileNotFoundException {
        String sql = "INSERT INTO transportadora_tb (email_transportadora, nome_transportadora, empresa_transportadora, telefone_transportadora, "
                + "celular_transportadora , whatsapp_transportadora, modal_transportadora, cep, uf, cidade, bairro, rua, numero, logo_transportadora)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, transportadora.getEmail());
            stmt.setString(2, transportadora.getNome());
            stmt.setString(3, transportadora.getEmpresa());
            stmt.setString(4, transportadora.getTelefone());
            stmt.setString(5, transportadora.getCelular());
            stmt.setString(6, transportadora.getWhatsapp());
            stmt.setString(7, transportadora.getModal());
            // Dispensei boa pratica de programaçaõ pos irei pesquisar como consumir API Correios
            stmt.setString(8, transportadora.getCep());
            stmt.setString(9, transportadora.getUf());
            stmt.setString(10, transportadora.getCidade());
            stmt.setString(11, transportadora.getBairro());
            stmt.setString(12, transportadora.getRua());
            stmt.setString(13, transportadora.getNumero());
            FileInputStream fis = new FileInputStream(transportadora.getLogo());
            stmt.setBinaryStream(14, fis, (int) transportadora.getLogo().length());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao inserir dados na tabela Transportadora" + erro);
        }

    }

    // Assinatura do metodo ALTERAR
    public void alterar(Transportadora transportadora) throws FileNotFoundException {

        String sql = "UPDATE transportadora_tb SET "
                + "email_transportadora = ?, nome_transportadora = ?, empresa_transportadora = ?,"
                + "telefone_transportadora = ? , celular_tansportadora = ?, whatsapp_transportadora = ?, modal_transportadpra = ?"
                + "cep =?, uf = ?, cidade =?, bairro =/, rua = ?, numero= ?, logo_transportadora = ? "
                + "WHERE id_transportadora = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, transportadora.getEmail());
            stmt.setString(2, transportadora.getNome());
            stmt.setString(3, transportadora.getEmpresa());
            stmt.setString(4, transportadora.getTelefone());
            stmt.setString(5, transportadora.getCelular());
            stmt.setString(6, transportadora.getWhatsapp());
            stmt.setString(7, transportadora.getModal());
            // Dispensei boa pratica de programaçaõ pos irei pesquisar como consumir API Correios
            stmt.setString(8, transportadora.getCep());
            stmt.setString(9, transportadora.getUf());
            stmt.setString(10, transportadora.getCidade());
            stmt.setString(11, transportadora.getBairro());
            stmt.setString(12, transportadora.getRua());
            stmt.setString(13, transportadora.getNumero());

            // IMAGEM
            FileInputStream fis = new FileInputStream(transportadora.getLogo());
            stmt.setBinaryStream(14, fis, (int) transportadora.getLogo().length());

            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao alterar dados na tabela Transportadora" + erro);
        }
    }

    // Asinatura do metodo DELETAR
    public void excluir(int valor) {
        String sql = "DELETE FROM transportadora_tb "
                + "WHERE id_transportadora =" + valor;

        try {
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao deletar dados na tabela transportadora");
        }
    }
// Assinatura do metodo ADICIONAR
// lISTAGEM 

    public ArrayList<Transportadora> Listartodos() throws FileNotFoundException {
        String sql = "SELECT * "
                + "FROM transportadora_tb";

        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Transportadora transportadora = new Transportadora();

                transportadora.setId(rs.getInt("id_transportadora"));
                transportadora.setEmail(rs.getString("email_transportadora"));
                transportadora.setNome(rs.getString("nome_transportadora"));
                transportadora.setEmpresa(rs.getString("empresa_transportadora"));
                transportadora.setTelefone(rs.getString("telefone_transportadora"));
                transportadora.setCelular(rs.getString("celular_transportadora"));
                transportadora.setWhatsapp(rs.getString("whatsapp_transportado"));
                transportadora.setModal(rs.getString("modal_transportadora"));
                transportadora.setCep(rs.getString("cep"));
                transportadora.setUf(rs.getString("uf"));
                transportadora.setCidade(rs.getString("cidade"));
                transportadora.setBairro(rs.getString("bairro"));
                transportadora.setRua(rs.getString("rua"));
                transportadora.setNumero(rs.getString("numero"));

                //Imagem - estudar como adicionar
                //transportadora.setLogo(rs.getBinaryStream("logo_transportadora"));
                lista.add(transportadora);
            }

        } catch (SQLException erro) {
            throw new RuntimeException("Erro na listagem de transportadora" + erro);
        }
        return lista;
    }

    // FILTRO 
    public ArrayList<Transportadora> ListatodosDescricao(String valor) {
        String sql = "SELECT * FROM transportadora_tb"
                + "WHERE nome_transportadora LIKE '%" + valor + "%', "
                + "uf LIKE '%" + valor + "%',"
                + "cidade LIKE '%" + valor + "%',"
                + "modal LIKE '%" + valor + "%'";

        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Transportadora transportadora = new Transportadora();

                transportadora.setId(rs.getInt("id_transportadora"));
                transportadora.setEmail(rs.getString("email_transportadora"));
                transportadora.setNome(rs.getString("nome_transportadora"));
                transportadora.setEmpresa(rs.getString("empresa_transportadora"));
                transportadora.setTelefone(rs.getString("telefone_transportadora"));
                transportadora.setCelular(rs.getString("celular_transportadora"));
                transportadora.setWhatsapp(rs.getString("whatsapp_transportado"));
                transportadora.setModal(rs.getString("modal_transportadora"));
                transportadora.setCep(rs.getString("cep"));
                transportadora.setUf(rs.getString("uf"));
                transportadora.setCidade(rs.getString("cidade"));
                transportadora.setBairro(rs.getString("bairro"));
                transportadora.setRua(rs.getString("rua"));
                transportadora.setNumero(rs.getString("numero"));

                //Imagem - estudar como adicionar
                //transportadora.setLogo(rs.getBinaryStream("logo_transportadora"));
                lista.add(transportadora);
            }

        } catch (SQLException erro) {
            throw new RuntimeException("Erro na descrição da listagem de transportadora" + erro);
        }

        return lista;
    }

    
    
    
    //Pegar pelo ID
    public Transportadora getTransportadoraById(int id) {

            Transportadora transportadora = new Transportadora();
            String sql = "select * from transportadora_tb where id_transportadora=?";

            try {
                st = conn.createStatement();
                rs = st.executeQuery(sql);

                while (rs.next()) {
           

                    transportadora.setId(rs.getInt("id_transportadora"));
                    transportadora.setEmail(rs.getString("email_transportadora"));
                    transportadora.setNome(rs.getString("nome_transportadora"));
                    transportadora.setEmpresa(rs.getString("empresa_transportadora"));
                    transportadora.setTelefone(rs.getString("telefone_transportadora"));
                    transportadora.setCelular(rs.getString("celular_transportadora"));
                    transportadora.setWhatsapp(rs.getString("whatsapp_transportado"));
                    transportadora.setModal(rs.getString("modal_transportadora"));
                    transportadora.setCep(rs.getString("cep"));
                    transportadora.setUf(rs.getString("uf"));
                    transportadora.setCidade(rs.getString("cidade"));
                    transportadora.setBairro(rs.getString("bairro"));
                    transportadora.setRua(rs.getString("rua"));
                    transportadora.setNumero(rs.getString("numero"));

                }

            } catch (SQLException erro) {
                throw new RuntimeException("Erro na descrição da listagem de transportadora" + erro);
            }

            return transportadora;
        }

    }

