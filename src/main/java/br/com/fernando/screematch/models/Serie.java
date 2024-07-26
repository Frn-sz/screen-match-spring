package br.com.fernando.screematch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Serie(
        @JsonAlias("Title") String title,
        String imdbRating,
        int totalSeasons) {

    @Override
    public String toString() {
        return "Serie{" +
                "title='" + title + '\'' +
                ", imdbRating=" + imdbRating +
                ", totalSeasons=" + totalSeasons +
                '}';
    }
}
