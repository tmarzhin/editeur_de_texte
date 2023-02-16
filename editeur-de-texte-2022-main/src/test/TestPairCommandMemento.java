package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import command.Command;
import command.Stop;
import memento.*;

public class TestPairCommandMemento {

	private Command command;

	private Memento memento;
	
	@org.junit.jupiter.api.BeforeEach
    void setUp() {
        command = null;
        memento = null;
    }
	
	@Test
    void testconstructeur() {
		PairCommandMemento pcm = new PairCommandMemento();
		Command c = pcm.getCommand();
		Memento m = pcm.getMemento();
		assertEquals(c,null);
		assertEquals(m,null);
		}
	
	@Test
    void testconstructeur1() {
		PairCommandMemento pcm = new PairCommandMemento();
		
		Recorder recorder = new RecorderImpl();
		Stop stop = new Stop(recorder); 
		
		InsertMemento im = new InsertMemento();
		
		pcm.setCommand(stop);
		pcm.setMemento(im);
		assertEquals(pcm.getCommand(),stop);
		assertEquals(pcm.getMemento(),im);
		}
	
	@Test
    void testconstructeur2() {
		
		Recorder recorder = new RecorderImpl();
		Stop stop = new Stop(recorder); 
		
		InsertMemento im = new InsertMemento();
		PairCommandMemento pcm = new PairCommandMemento(stop,im);
	
		assertEquals(pcm.getCommand(),stop);
		assertEquals(pcm.getMemento(),im);
		}
}
