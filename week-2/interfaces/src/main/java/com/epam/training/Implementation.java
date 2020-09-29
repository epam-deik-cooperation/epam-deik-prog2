package com.epam.training;

/* Java 8-tól az interfészekben lehetővé vált default metódus implementációk megadása.
 * Erre azért volt szükség, hogy könnyebben tudják biztosítani a visszafele kompatibilitást
 * az ebben a verzióban megjelent újításokkal kapcsolatban. Ezzel azonban egyfajta többszörös
 * öröklődési problémát is bevezettek. Ahogy ebben a példában is látható az InterfaceA és InterfaceB
 * is egyaránt rendelkezik egy method nevezetű metódussal, amire vonatkozóan biztosítanak default
 * implementációt. Az Implementation osztály implementálja mindkét interfészt, így annak ellenére,
 * hogy létezik default implementáció erre a metódusra, kénytelenek vagyunk explicit felüldefiniálni
 * a method nevű metódust és meghatárzni melyik default implementációt szeretnénk használni.
 * 
 */
public class Implementation implements InterfaceA, InterfaceB {

	@Override
	public void method() {
		InterfaceA.super.method();
	}

}
