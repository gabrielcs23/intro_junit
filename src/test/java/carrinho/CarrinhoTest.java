package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
    }

    @DisplayName("Testa se carrinho foi inicializado corretamente")
    @Test
    public void testInicializaCarrinhoVazio() {
        try {
            int qtdeItems = carrinho.getQtdeItems();
            assertEquals(0, qtdeItems);
        } catch (NullPointerException e) {
            fail("Carrinho não inicializado");
        }
    }

    @DisplayName("Testa adicionar um item ao carrinho")
    @Test
    public void testAdicionaUmItem() {
        Produto produto = new Produto("Machine Learning", 55.0);
        carrinho.addItem(produto);
        assertAll("carrinho",
                () -> assertEquals(1, carrinho.getQtdeItems()),
                () -> assertEquals(produto.getPreco(), carrinho.getValorTotal())
        );
    }

    @DisplayName("Testa adicionar dois itens ao carrinho")
    @Test
    public void testAdicionaDoisItens() {
        Produto livro = new Produto("Machine Learning", 55.0);
        Produto game = new Produto("Nintendo Switch", 2650.0);
        carrinho.addItem(livro);
        carrinho.addItem(game);
        assertAll("carrinho",
                () -> assertEquals(2, carrinho.getQtdeItems()),
                () -> assertEquals(livro.getPreco() + game.getPreco(), carrinho.getValorTotal())
        );
    }

    @DisplayName("Testa remover um item do carrinho")
    @Test
    public void testRemoveItem() {
        Produto livro = new Produto("Machine Learning", 55.0);
        Produto game = new Produto("Nintendo Switch", 2650.0);
        carrinho.addItem(livro);
        carrinho.addItem(game);
        try {
            carrinho.removeItem(livro);
        } catch (ProdutoNaoEncontradoException e) {
            fail("Item não foi encontrado no carrinho para remoção");
        }
        assertAll("carrinho",
                () -> assertEquals(1, carrinho.getQtdeItems()),
                () -> assertEquals(2650.0, carrinho.getValorTotal())
        );
    }

    @DisplayName("Testa remover um item inexistente no carrinho")
    @Test
    public void testRemoveItemNaoEncontrado() {
        Produto livro = new Produto("Machine Learning", 55.0);
        assertThrows(ProdutoNaoEncontradoException.class,
                () -> carrinho.removeItem(livro)
        );
    }

    @DisplayName("Testa esvaziar carrinho")
    @Test
    public void testEsvaziar() {
        Produto livro = new Produto("Machine Learning", 55.0);
        Produto game = new Produto("Nintendo Switch", 2650.0);
        carrinho.addItem(livro);
        carrinho.addItem(game);
        carrinho.esvazia();
        assertAll("carrinho",
                () -> assertEquals(0, carrinho.getQtdeItems()),
                () -> assertEquals(0.0, carrinho.getValorTotal())
        );
    }

}
