package br.com.british.ocorrencia.sistemOccurrence.application.controllers;

public class NoContentException extends Exception {
    public NoContentException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "NoContentException: " + getMessage();
    }
}
