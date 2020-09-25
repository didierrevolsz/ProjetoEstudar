

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<script type="text/javascript" language="JavaScript">

    function teste() {

        window.open("/TransportadoraControladora?acao=editar&id=5&email=gusta&nome=",
                "pop", "width=210, height=100");
    }
</script>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Cadastro</title>
        <!--CRIANDO STYLE  -->
        <style type="text/css">

        </style>


    </head>

    <body>
        <form name="cadastro" action="TransportadoraServelet" method="POST">

            <!--Email-->
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" value="<c:out value="${transportadora.email}" />" /></td>
            </tr><br><br>

            <!--Nome-->
            <tr>
                <td>Nome</td>
                <td>
                    <input type="text" name="nome" value="c:out value="${transportadora.nome}" />
                </td>
            </tr><br><br>

            <!--Empresa-->
            <tr>
                <td>Empresa</td>
                <td><input type="text" name="empresa" 
                           value="c:out value="${transportadora.empresa}" /></td>
            </tr><br><br>

            <!--Telefone-->
            <tr>
                <td>Telefone</td>
                <td><input type="text" name="telefone" 
                           value="c:out value="${transportadora.telefone}/>" /></td>
            </tr><br><br>

            <!--Celular-->
            <tr>
                <td>Celular</td>
                <td><input type="text" name="celular" 
                           value="c:out value="${transportadora.celular}/>" /></td>
            </tr><br><br>

            <!--Whatsapp-->
            <tr>
                <td>Whatsapp</td>
                <td><input type="text" name="whatsapp" 
                           value="c:out value="${transportadora.whatsapp}/>" /></td>
            </tr><br><br>

            <!--Modal-->
            <tr>
                <td>Modal</td>
                <td><select name="modal" id="modal_select">
                        <option value="">Selecione</option>
                        <option>Rodoviario(120)</option>
                        <option>Aereo(110)</option>
                        <option>Aquaviario(90)</option>
                    </select>
                
                </td>
            </tr><br><br>

            <!--CEP-->
            <tr>
                <td>CEP</td>
                <td><input type="text" name="cep"></td>
            </tr>

            <!--UF-->
            <tr>
                <td>Estado</td>
                <td><select name="uf" id="uf">
                        <option value="">Selecione</option>
                        <option value="AC">AC</option>
                        <option value="AL">AL</option>
                        <option value="AM">AM</option>
                        <option value="AP">AP</option>
                        <option value="BA">BA</option>
                        <option value="CE">CE</option>
                        <option value="DF">DF</option>
                        <option value="ES">ES</option>
                        <option value="GO">GO</option>
                        <option value="MA">MA</option>
                        <option value="MG">MG</option>
                        <option value="MS">MS</option>
                        <option value="MT">MT</option>
                        <option value="PA">PA</option>
                        <option value="PB">PB</option>
                        <option value="PE">PE</option>
                        <option value="PI">PI</option>
                        <option value="PR">PR</option>
                        <option value="RJ">RJ</option>
                        <option value="RN">RN</option>
                        <option value="RS">RS</option>
                        <option value="RO">RO</option>
                        <option value="RR">RR</option>
                        <option value="SC">SC</option>
                        <option value="SE">SE</option>
                        <option value="SP">SP</option>
                        <option value="TO">TO</option>
                    </select><br><br></td>
            </tr>

            <!--Cidade-->
            <tr>
                <td>Cidade</td>
                <td><input type="text" name="cidade"></td>
            </tr><br><br>

            <!--Bairro-->
            <tr>
                <td>Bairro</td>
                <td><input type="text" name="bairro"></td>
            </tr><br><br>

            <!--Rua/ Avenida-->
            <tr>
                <td>Rua / Avenida</td>
                <td><input type="text" name="rua"></td>
            </tr><br><br>

            <!--Numero-->
            <tr>
                <td>Numero</td>
                <td><input type="text" name="numero"></td>
            </tr><br><br>

            <!--Logo-->
            <tr>
                <td>Logo</td>
                <td><input type="file" name="image" /></br> </br>
                    <input type="submit" value="Enviar" name="envia" /></td>
            </tr><br><br>

            <!-- Form das condições de termos -->
            <form action="#" onsubmit="if (document.getElementById('agree').checked) {
                        return true;
                    } else {
                        alert('Informe que leu e concorda com os Termos e Condições e a Política de Privacidade');
                        return false;
                    }"><br><br>
                <input type="checkbox" name="checkbox" value="check" id="agree" /> Eu aceito os termos de serviço
                <br><br>

                <!-- Botão Enviar-->
                <input type="button" name="btCadastrar" value="Cadastrar-se agora!"  
                       onClick="javascript:teste();" />

            </form><br><br> <br><br>

        </form>

    </body>

</html>