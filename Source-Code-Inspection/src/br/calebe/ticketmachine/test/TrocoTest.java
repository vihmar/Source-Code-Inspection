package br.calebe.ticketmachine.test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;
import org.junit.Test;
import br.calebe.ticketmachine.core.Troco;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;


public class TrocoTest {
    

    // ============================ Cenários de Sucesso ======================== //
    @Test
    public void deveRetornarOkQuandoVerificacaoSeTemProximoEstiverCerta(){
        Troco troco = new Troco(100);
        assertThat(troco.getIterator().hasNext(), equalTo(Boolean.TRUE));

    }

    @Test
    public void deveRetornarOkQuandoVerificarNext() throws IllegalStateException{
        Troco troco = new Troco(100);
        assertThat(troco.getIterator().next().getValor(), equalTo(2));
    }

    // ============================ Cenários de Sucesso ======================== //

    // ============================ Cenários de ERRO ======================== //
    @Test(expected = IllegalStateException.class)
    public void deveRetornarErroQuandoVerificarNext() throws IllegalStateException{
        Troco troco = new Troco(100);
        assertThat(troco.getIterator().next().getValor(), equalTo(2));
        troco.getIterator().next().getValor();
        fail();
    }

        // ============================ Cenários de ERRO ======================== //


}
