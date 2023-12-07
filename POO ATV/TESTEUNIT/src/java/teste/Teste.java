import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class VendaItemTest {

    private Venda venda;
    private ItemVenda item1;
    private ItemVenda item2;

    @Before
    public void setUp() {
        venda = new Venda("Cliente A");
        item1 = new ItemVenda("Produto X", 50.0, 2);
        item2 = new ItemVenda("Serviço Y", 30.0, 1);

        venda.adicionarItem(item1);
        venda.adicionarItem(item2);
    }

    @Test
    public void testCalcularValorVenda() {
        double expected = (50.0 * 2) + 30.0; // (valorProduto1 * quantidade1) + valorProduto2
        assertEquals(expected, venda.calcularValorVenda(), 0.01);
    }

    @Test
    public void testCalcularValorDesconto() {
        venda.setValorDesconto(10.0);
        double expected = 10.0;
        assertEquals(expected, venda.calcularValorDesconto(), 0.01);
    }

    @Test
    public void testCalcularValorFinal() {
        venda.setValorDesconto(10.0);
        double expected = ((50.0 * 2) + 30.0) - 10.0; // (valorProduto1 * quantidade1) + valorProduto2 - valorDesconto
        assertEquals(expected, venda.calcularValorFinal(), 0.01);
    }
}
