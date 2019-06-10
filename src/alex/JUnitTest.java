package alex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTest {

	static ShoppingCart shop;
	static Product prod1;
	static Product prod2;

	@BeforeEach
	void setUp() throws Exception {
		shop = new ShoppingCart();
		prod1 = new Product("Rentadora", 300.00);
		shop.addItem(prod1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void productoNoExistente() {
		Product prodNou = new Product("Televisio", 155.00);
		Assertions.assertThrows(ProductNotFoundException.class, () -> {
			shop.removeItem(prodNou);
		});
	}

	@Test
	void añadirProductoMirarPreu() {
		prod2 = new Product("Nevera", 400.00);
		shop.addItem(prod2);
		assertEquals(700.00, shop.getBalance());
	}
	
	@Test
	void añadirProductoMirarNumero() {
		prod2 = new Product("Nevera", 400.00);
		shop.addItem(prod2);
		assertEquals(2, shop.getItemCount());
	}

	@Test
	void compruebaVacio() {
		shop.empty();
		assertEquals(true, shop.isEmpty());
	}
}
