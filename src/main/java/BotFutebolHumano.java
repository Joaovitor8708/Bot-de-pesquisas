import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class BotFutebolHumano {

    private static final int MAX_PESQUISAS = 20;
    private static final int TEMPO_MIN = 10000;
    private static final int TEMPO_EXTRA = 3000;

    private static final String[] FRASES_JOGADOR = {
            "últimos jogos de %s",
            "estatísticas de %s",
            "gols de %s na temporada",
            "notícias recentes sobre %s",
            "carreira de %s",
            "desempenho de %s hoje",
            "quantos gols %s tem",
            "melhores momentos de %s",
            "%s jogando hoje",
            "lesão de %s"
    };

    private static final String[] FRASES_TIME = {
            "últimas notícias do %s",
            "próximo jogo do %s",
            "tabela do %s",
            "classificação do %s",
            "elenco do %s",
            "resultados recentes do %s",
            "jogos do %s hoje",
            "escalação do %s",
            "história do %s",
            "títulos do %s"
    };

    public static void main(String[] args) {

        try {
            List<String> times = Files.readAllLines(Paths.get("dados/times.txt"));
            List<String> jogadores = Files.readAllLines(Paths.get("dados/jogadores.txt"));

            System.setProperty(
                    "webdriver.edge.driver",
                    "C:\\edgedriver_win64\\msedgedriver.exe"
            );

            WebDriver driver = new EdgeDriver();
            Random random = new Random();

            driver.get("https://www.bing.com");

            for (int i = 1; i <= MAX_PESQUISAS; i++) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

                WebElement campoBusca = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.name("q"))
                );

                campoBusca.clear();

                String termo = gerarPesquisaNatural(times, jogadores, random);

                digitarComoHumano(campoBusca, termo, random);
                campoBusca.submit();

                System.out.println("Pesquisa " + i + ": " + termo);

                int espera = TEMPO_MIN + random.nextInt(TEMPO_EXTRA);
                Thread.sleep(espera);
            }

            driver.quit();
            System.out.println("Bot finalizado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Gera frases naturais para jogador ou time
    private static String gerarPesquisaNatural(
            List<String> times,
            List<String> jogadores,
            Random random
    ) {
        if (random.nextBoolean()) {
            String jogador = jogadores.get(random.nextInt(jogadores.size()));
            String frase = FRASES_JOGADOR[random.nextInt(FRASES_JOGADOR.length)];
            return String.format(frase, jogador);
        } else {
            String time = times.get(random.nextInt(times.size()));
            String frase = FRASES_TIME[random.nextInt(FRASES_TIME.length)];
            return String.format(frase, time);
        }
    }

    // Digitação humana (letra por letra)
    private static void digitarComoHumano(
            WebElement campo,
            String texto,
            Random random
    ) throws InterruptedException {

        for (char c : texto.toCharArray()) {
            campo.sendKeys(String.valueOf(c));
            Thread.sleep(80 + random.nextInt(120));
        }
    }
}



