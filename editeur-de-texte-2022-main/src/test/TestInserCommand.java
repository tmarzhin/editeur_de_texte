package test;


import org.junit.jupiter.api.Test;

import command.*;
import memento.InsertMemento;
import memento.RecorderImpl;
import receiver.EngineImpl;
import undoRedo.UndoRedoImpl;
import static org.junit.Assert.*;

public class TestInserCommand {
	
	private Insert test;
	
	@org.junit.jupiter.api.BeforeEach
    void setUp() {
		EngineImpl engine = new EngineImpl();
		RecorderImpl recorder = new RecorderImpl();
		UndoRedoImpl undoredo = new UndoRedoImpl(engine);
        test = new Insert(engine,recorder,undoredo);
        
    }
	
	@Test
	public void testsetMemento()  {
		InsertMemento m = new InsertMemento("test");
		test.setMemento(m);
		InsertMemento insmemento = (InsertMemento) test.getMemento();
		assertTrue(insmemento.getText() == "test");
		m = new InsertMemento("");
		test.setMemento(m);
		insmemento = (InsertMemento) test.getMemento();
		assertTrue(insmemento.getText() == "");
	}
	
	@Test
	public void testgetMemento1()  {
		test.getMemento();
		EngineImpl engine = new EngineImpl();
		RecorderImpl recorder = new RecorderImpl();
		UndoRedoImpl undoredo = new UndoRedoImpl(engine);
        Insert test1 = new Insert(engine,recorder,undoredo);
        
        assertEquals(test,test1);
	}
		
	
	
}
