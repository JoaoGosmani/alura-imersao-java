import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    public void criarFigurinha(InputStream inputStream, String nomeArquivo) throws Exception {
        // LEITURA DA IMAGEM
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        // InputStream inputStream = new URL().openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // CRIANDO UMA NOVA IMAGEM EM MEMÓRIA COM TRANSPARÊNCIA E COM TAMANHO NOVO
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // COPIANDO A IMAGEM ORIGINAL PARA A IMAGEM NOVA (EM MEMÓRIA)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // CONFIGURANDO A FONTE 
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // ESCREVENDO UMA FRASE NA IMAGEM NOVA
        graphics.drawString("TOPZERA", 100, novaAltura - 100);

        // ESCREVENDO A NOVA IMAGEM EM UM ARQUIVO
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}
