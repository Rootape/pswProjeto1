/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Paulo
 */
public class AlunoTest {
    
    private Aluno a;
    
    public AlunoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        a = new Aluno();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of situacao method, of class Aluno.
     */
    
    //frequencia, p1, , trabalho, projetos, pf
    //M1 = 7/10 * ((P1 + Trabalho)/2) + ProjetosEmAula * 3/10
    @Test
    public void testSituacao() {
        //Aprovado sem PF (DANDO ERRO)
        assertEquals("Aprovado", a.situacao(80, 80, 80, 80, 0));
        //Reprovado por frequencia
        assertEquals("Reprovado", a.situacao(74, 80, 80, 80, 0));
        //Aprovado na PF (DANDO ERRo)
        assertEquals("Aprovado", a.situacao(80, 50, 50, 50, 50));
        //Reprovado na PF
        assertEquals("Reprovado", a.situacao(80, 50, 50, 50, 40));
        //Reprovado por nao ter media pra PF
        assertEquals("Reprovado", a.situacao(80, 20, 20, 0, 0));
    }
    
}
