package br.com.fernando.screematch;

import br.com.fernando.screematch.models.Serie;
import br.com.fernando.screematch.service.ConsumoAPI;
import br.com.fernando.screematch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreematchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreematchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var api = new ConsumoAPI();

        var json = api.obterDados("http://omdbapi.com/?apikey=1d06cc32&t=gilmore+girls");

        ConverteDados conversor = new ConverteDados();

        Serie serie = conversor.obterDados(json, Serie.class);

        System.out.println(serie);
    }
}
