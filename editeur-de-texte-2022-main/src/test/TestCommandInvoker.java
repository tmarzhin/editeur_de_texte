package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

import command.*;
import command.Stop;
import invoker.CommandInvoker;
import memento.Memento;
import memento.PairCommandMemento;
import memento.Recorder;
import memento.RecorderImpl;

public class TestCommandInvoker {
	private Map<String,Command> command;
	
	@org.junit.jupiter.api.BeforeEach
    void setUp() {
        command = new HashMap<String,Command>();
        
    }
	
	@Test
    void testconstructeur() {
		Map<String,Command> commandb = new HashMap<String,Command>();
		assertEquals(command,commandb);
		
		}
	
	@Test
    void testconstructeur1() {
		CommandInvoker ci = new CommandInvoker(command);
		Recorder recorder = new RecorderImpl();
		ci.listeDesCommandes();
		assertEquals(true,command.isEmpty());
		Stop stop = new Stop(recorder); 
		ci.addCommand("stop", stop);
		assertEquals(true,command.containsKey("stop"));
		Start start = new Start(recorder); 
		ci.addCommand("stop", start);
		assertEquals(false,command.containsKey("stop"));
		ci.addCommand("start", stop);
		assertEquals(false,command.containsKey("start"));
		ci.listeDesCommandes();
		}
}
