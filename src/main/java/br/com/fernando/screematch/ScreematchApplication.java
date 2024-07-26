package br.com.fernando.screematch;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.fernando.screematch.models.Season;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.fernando.screematch.models.Serie;
import br.com.fernando.screematch.service.ConsumoAPI;
import br.com.fernando.screematch.service.ConverteDados;

@SpringBootApplication
public class ScreematchApplication implements CommandLineRunner {

    private final String URL = "http://omdbapi.com/?apikey=1d06cc32&";
    private final ConsumoAPI api = new ConsumoAPI();
    private final ConverteDados conversor = new ConverteDados();

    public static void main(String[] args) {
        SpringApplication.run(ScreematchApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner keyboard = new Scanner(System.in);

        String name = keyboard.nextLine();

        Serie serie = buscaSeries(name);

        ArrayList<Season> seasons = new ArrayList<>();

        for (int i = 1; i <= serie.totalSeasons(); ++i)
            seasons.add(buscaTemporada(serie, i));

        seasons.forEach(s -> s.totalEpisodes().forEach(e -> System.out.println(e.title())));
    }

    public Serie buscaSeries(String name) {
        return conversor.obterDados(this.api.obterDados(URL + "t=" + URLEncoder.encode(name, StandardCharsets.UTF_8)), Serie.class);
    }

    public Season buscaTemporada(Serie serie, int season) {
        return conversor.obterDados(this.api.obterDados(URL + "t=" + URLEncoder.encode(serie.title(), StandardCharsets.UTF_8) + "&season=" + season), Season.class);
    }
}
