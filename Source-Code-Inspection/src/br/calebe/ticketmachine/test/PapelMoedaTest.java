package br.calebe.ticketmachine.test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import br.calebe.ticketmachine.core.PapelMoeda;


public class PapelMoedaTest {
    
    @Test
    public void deveRetornarOkQuandoValorZerado(){
        PapelMoeda papelMoeda = new PapelMoeda(0, 0);
        assertThat(papelMoeda.getValor(), equalTo(0));
    }

    @Test
    public void deveRetornarOkQuandoQuantidadeZerada(){
        PapelMoeda papelMoeda = new PapelMoeda(0, 0);
        assertThat(papelMoeda.getQuantidade(), equalTo(0));
    }

}
