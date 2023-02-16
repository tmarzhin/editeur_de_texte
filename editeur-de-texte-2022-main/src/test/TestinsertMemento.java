package test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import memento.*;
import receiver.EngineImpl;
import receiver.Selection;

public class TestinsertMemento {

	private String texte;
	
	@org.junit.jupiter.api.BeforeEach
    void setUp() {
        texte = "";
    }
	
	@Test
    void testconstructeur() {
		InsertMemento im = new InsertMemento();
		String s = im.getText();
		assertEquals(s,"");
		}
	
	@Test
    void testconstructeur1() {
		InsertMemento im = new InsertMemento("");
		String s = im.getText();
		assertEquals(s,"");
		}
	
	@Test
    void testconstructeur2() {
		InsertMemento im = new InsertMemento("a");
		String s = im.getText();
		assertEquals(s,"a");
		}
	
	@Test
    void testconstructeur3() {
		InsertMemento im = new InsertMemento();
		im.setText("a");
		assertEquals(im.getText(),"a");
		}
}
