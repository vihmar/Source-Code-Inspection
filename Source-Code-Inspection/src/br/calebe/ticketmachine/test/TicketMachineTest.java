package br.calebe.ticketmachine.test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;
import org.junit.Test;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;


public class TicketMachineTest  {

    // ============================ Cenários de Sucesso ======================== //
    @Test
    public void deveRetornarOkQuandoObjetoExistir(){
        TicketMachine ticketMachine = new TicketMachine(0);
        assertThat(ticketMachine.getSaldo(), equalTo(0));
        assertThat(ticketMachine.getClass(), notNullValue());

    }

    @Test
    public void deveRetornarOkQuandoInserirQuantia() throws PapelMoedaInvalidaException{
        TicketMachine ticketMachine = new TicketMachine(5);
        ticketMachine.inserir(10);

        assertThat(ticketMachine.getSaldo(), equalTo(10));
    }

    @Test
    public void deveRetornarOkQuandoSolicitarTroco() throws PapelMoedaInvalidaException{
        TicketMachine ticketMachine = new TicketMachine(5);
        ticketMachine.inserir(10);
        ticketMachine.getTroco();

        assertThat(ticketMachine.getTroco().next(), equalTo(5));
    }

    @Test
    public void deveRetornarOkQuandoSolicitarImpressao() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        TicketMachine ticketMachine = new TicketMachine(5);
        ticketMachine.inserir(10);
        ticketMachine.imprimir();

        assertThat(ticketMachine.getSaldo(), equalTo(10));
    }
   // ============================ Cenários de Sucesso ======================== //

   // ======================================================================== //

    // ============================ Cenários de Erro ======================== //
    @Test(expected = PapelMoedaInvalidaException.class)
    public void deveRetornarErroQuandoInserirQuantia() throws PapelMoedaInvalidaException{
        TicketMachine ticketMachine = new TicketMachine(5);
        ticketMachine.inserir(18);

        fail();
    }

    @Test(expected = IllegalStateException.class)
    public void deveRetornarErroQuandoSolicitarTroco() throws IllegalStateException{
        TicketMachine ticketMachine = new TicketMachine(5);
        ticketMachine.getTroco();

        fail();
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void deveRetornarErroQuandoSolicitarImpressao() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        TicketMachine ticketMachine = new TicketMachine(5);
        ticketMachine.imprimir();

        fail();
    }
     // ============================ Cenários de Erro ======================== //
}

