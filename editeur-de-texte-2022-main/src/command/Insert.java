package command;
import memento.CommandOriginator;
import java.util.Scanner;


import main.*;
import memento.Memento;
import memento.InsertMemento;
import memento.Recorder;
import receiver.Engine;
import undoRedo.*;


public class Insert implements CommandOriginator {
	private Engine engine;
	private Recorder recorder;
	private boolean memo;
	private InsertMemento im;
	private UndoRedo undoredo;
	private MainApp app;
	
	public Insert(Engine en,Recorder recorder,UndoRedo undoredo) {
		this.engine = en;
		this.recorder = recorder;
		this.undoredo = undoredo;
	}
	
	@Override
	public void execute() {
		String s = ""; 
		if (!memo) {
			Scanner scan = app.getScan();
			s=scan.nextLine();
		}else {
		s= im.getText();	
		memo = false;
		}
		engine.insert(s); 
		im = new InsertMemento(s);
		recorder.save(this);
		undoredo.store();
	}

	/**
	 * @return Un memento sauvegardant l'état de la commande insert
	 */
	public Memento getMemento() {
		return im;
		
	}
	
	public void setMemento(Memento m) {
		if (m instanceof InsertMemento){
			 this.im = (InsertMemento) m;
			 memo = true;
		}else {
			throw new IllegalArgumentException("Le mémento doit être de type InsertMemento");
		}
	}
}