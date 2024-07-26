package br.com.fernando.screematch.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> c);
}
