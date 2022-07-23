import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        /* FAZENDO UMA CONEXÃO HTTP E BUSCANDO O TOP 250 FILMES
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        */

        /*  API DE IMAGENS DA NASA
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        */

        /* API DE IMAGENS DE LINGUAGENS
        String url = "https://joaogosmani-linguagens-api.herokuapp.com/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB(); 
        */

        String url = "https://joaogosmani-linguagens-api.herokuapp.com/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB(); 

        ClienteHttp http = new ClienteHttp();
        String json = http.buscarDados(url);
        
        // EXIBINDO E MANIPULANDO OS DADOS
        List<Conteudo> conteudos = extrator.extrairConteudos(json);

        GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();

        for (int i = 0; i < 10; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo().replace(":", "-")  + ".png";
            
            geradorDeFigurinhas.criarFigurinha(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
