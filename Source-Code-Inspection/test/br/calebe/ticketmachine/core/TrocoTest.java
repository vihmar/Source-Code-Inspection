package br.calebe.ticketmachine.core;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;

public class TrocoTest {

    private Troco troco;

    @Before
    public void setUp() {
        troco = new Troco(187);
    }
    
    @Test
    public void testTrocoIterator() {
        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertTrue(iterator.hasNext());
        assertEquals(100, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(50, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next().getValor());

        assertFalse(iterator.hasNext());
    }

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
