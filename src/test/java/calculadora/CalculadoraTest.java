package calculadora;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertEquals(2, divisao);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int sub = calc.subtracao(4, 5);
		Assertions.assertEquals(-1, sub);
	}

	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(2, 4);
		assertEquals(8, multiplicacao);
	}

	@DisplayName("Testa a somatória até 5")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);
		assertEquals(15, somatoria);
	}

	@DisplayName("Testa se o resultado de uma subtração é negativo")
	@Test
	public void testSubtracaoResultadoNegativo() {
		int sub = calc.subtracao(4, 5);
		assertFalse(calc.ehPositivo(sub));
	}

	@DisplayName("Testa comparação de números iguais")
	@Test
	public void testComparacaoNumerosIguais() {
		int comparacao = calc.compara(5, 5);
		assertEquals(0, comparacao);
	}

	@DisplayName("Testa comparação quando a > b")
	@Test
	public void testComparacaoAMaiorQueB() {
		int comparacao = calc.compara(7, 5);
		assertEquals(1, comparacao);
	}

	@DisplayName("Testa comparação quando a < b")
	@Test
	public void testComparacaoAMenorQueB() {
		int comparacao = calc.compara(5, 7);
		assertEquals(-1, comparacao);
	}

}
