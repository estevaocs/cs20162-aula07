/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.construcao.calendario;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Estevao
 */
public class CalendarioTest {

    Calendario c;

    public CalendarioTest() {
        c = new Calendario();
    }

    /**
     * Teste com data Desconhecida invalida com ano menor que 999
     *
     * @throws Exception
     */
    @Test
    public void testDataDesconhecidaInvalida() throws Exception {
        assertEquals(-1, Calendario.diaSemana(2010101, 2016, 20160928, 2));
    }

    /**
     * Teste com data Desconhecida invalida com ano maior que 10000
     *
     * @throws Exception
     */
    @Test
    public void testDataDesconhecidaInvalida2() throws Exception {
        assertEquals(-1, Calendario.diaSemana(100000101, 2016, 20160928, 2));
    }

    /**
     * Teste com data Desconhecida com mes invalido maior que 12;
     *
     * @throws Exception
     */
    @Test
    public void testDataDesconhecidaInvalida3() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20161301, 2016, 20160928, 2));
    }

    /**
     * Teste com data Desconhecida com mes invalido menor que 1;
     *
     * @throws Exception
     */
    @Test
    public void testDataDesconhecidaInvalida4() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160001, 2016, 20160928, 2));
    }

    /**
     * Teste com data Desconhecida com dia invalido maior que quantidades de dia
     * no mes; 31 dias em outubro
     *
     * @throws Exception
     */
    @Test
    public void testDataDesconhecidaInvalida5() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160931, 2016, 20160928, 2));
    }

    /**
     * Teste com data Desconhecida com dia invalido maior que a qntidades de dia
     * no mes; 29 dias em fevereiro de umo nao bissexto
     *
     * @throws Exception
     */
    @Test
    public void testDataDesconhecidaInvalida6() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20150229, 2016, 20160928, 2));
    }

    /**
     * Teste com data Desconhecida com dia invalido menor que 1;
     *
     * @throws Exception
     */
    @Test
    public void testDataDesconhecidaInvalida7() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160900, 2016, 20160928, 2));
    }

    /**
     * Teste com ano bissexto igual a 0;
     *
     * @throws Exception
     */
    @Test
    public void testAnoBissextoIgualAZero() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20150228, 0, 20160928, 2));
    }

    /**
     * Teste com ano bissexto negativo
     *
     * @throws Exception
     */
    @Test
    public void testAnoBissextoMenorQueZero() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20150228, -100, 20160928, 2));
    }

    /**
     * Teste com data Conhecida invalida com ano menor que 999
     *
     * @throws Exception
     */
    @Test
    public void testDataConhecidaInvalida() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 2010101, 2));
    }

    /**
     * Teste com data Conhecida invalida com ano maior que 10000
     *
     * @throws Exception
     */
    @Test
    public void testDataConhecidaInvalida2() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 100000101, 2));
    }

    /**
     * Teste com data conhecida com mes invalido maior que 12;
     *
     * @throws Exception
     */
    @Test
    public void testDataConhecidaInvalida3() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20161301, 2));
    }

    /**
     * Teste com data conhecida com mes invalido menor que 1;
     *
     * @throws Exception
     */
    @Test
    public void testDataConhecidaInvalida4() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160001, 2));
    }

    /**
     * Teste com data Conhecida com dia invalido maior que quantidades de dia no
     * mes; 31 dias em outubro
     *
     * @throws Exception
     */
    @Test
    public void testDataConhecidaInvalida5() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160931, 2));
    }

    /**
     * Teste com data Conhecida com dia invalido maior que a qntidades de dia no
     * mes; 29 dias em fevereiro de umo nao bissexto
     *
     * @throws Exception
     */
    @Test
    public void testDataConhecidaInvalida6() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20150229, 2));
    }

    /**
     * Teste com data Conhecida com dia invalido menor que 1;
     *
     * @throws Exception
     */
    @Test
    public void testDataConhecidaInvalida7() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160900, 2));
    }

    /**
     * Teste com dia da semana menor que 0
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDiaDaSemanaMenorQueZero() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160901, -1));
    }

    /**
     * Teste com dia da semana maior que 6
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDiaDaSemanaMaiorQueSeis() throws Exception {
        assertEquals(-1, Calendario.diaSemana(20160928, 2016, 20160901, 7));
    }

    /**
     * Test com data desconhecida igual a data conhecida
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDatasIguais() throws Exception {
        assertEquals(2, Calendario.diaSemana(20160928, 2016, 20160928, 2));
    }

    /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida() throws Exception {
        assertEquals(3, Calendario.diaSemana(20160928, 2016, 20160901, 4));
    }

    /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida2() throws Exception {
        assertEquals(0, Calendario.diaSemana(20160228, 2016, 20161201, 4));
    }

    /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida3() throws Exception {
        assertEquals(2, Calendario.diaSemana(20201201, 2016, 20161010, 1));
    }

   

    /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida4() throws Exception {
        assertEquals(0, Calendario.diaSemana(20160110, 2016, 20161010, 1));
    }

    /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida6() throws Exception {
        assertEquals(1, Calendario.diaSemana(20161010, 2016, 20160110, 0));
    }
    
    /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida7() throws Exception {
        assertEquals(0, Calendario.diaSemana(20160110, 2016, 20171010, 2));
    }
    
     /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida8() throws Exception {
        assertEquals(0, Calendario.diaSemana(20160110, 2016, 20160112, 2));
    }
    
     /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida9() throws Exception {
        assertEquals(4, Calendario.diaSemana(20160114, 2016, 20161022, 6));
    }
    
     /**
     * Test com datas validas
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDataValida10() throws Exception {
        assertEquals(3, Calendario.diaSemana(20160114, 2015, 20161022, 6));
    }
    
    @Test
    public void testDataValida11() throws Exception {
        assertEquals(4, Calendario.diaSemana(20160114, 2016, 20161022, 6));
    }
    
    @Test
    public void testDataValida12() throws Exception {
        assertEquals(4, Calendario.diaSemana(20160114, 2000, 20161022, 6));
    }
    
    @Test
    public void testDataValida13() throws Exception {
        assertEquals(0, Calendario.diaSemana(20160110, 2000, 20171010, 2));
    }
    
    @Test
    public void testDataValida14() throws Exception {
        assertEquals(5, Calendario.diaSemana(20000114, 2000, 20161022, 6));
    }
   
    @Test
    public void testDataValida15() throws Exception {
        assertEquals(5, Calendario.diaSemana(20000114, 2016, 20161022, 6));
    }
    
    @Test
    public void testDataValida16() throws Exception {
        assertEquals(4, Calendario.diaSemana(20000114, 2015, 20161022, 6));
    }
    
    @Test
    public void testDataValida17() throws Exception {
        assertEquals(4, Calendario.diaSemana(19970114, 2015, 20161022, 6));
    }
}
