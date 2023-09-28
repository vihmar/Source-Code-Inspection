package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
                break; 
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<Integer> getTroco() {
        int troco = saldo - valor;
        if (troco < 0) {
            throw new IllegalStateException("Não há troco a ser fornecido.");
        }

        List<Integer> notasDeTroco = new ArrayList<>();
        for (int i = papelMoeda.length - 1; i >= 0; i--) {
            while (troco >= papelMoeda[i]) {
                notasDeTroco.add(papelMoeda[i]);
                troco -= papelMoeda[i];
            }
        }

        return notasDeTroco.iterator();
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
