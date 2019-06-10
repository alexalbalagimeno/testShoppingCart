package alex;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String missatge) {
		super(missatge);
	}
}