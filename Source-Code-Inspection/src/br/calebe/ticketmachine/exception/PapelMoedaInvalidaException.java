package br.calebe.ticketmachine.exception;

public class PapelMoedaInvalidaException extends Exception {

    public PapelMoedaInvalidaException() {
        super("Papel moeda não aceito.");
    }

    public PapelMoedaInvalidaException(String message) {
        super(message);
    }
}
