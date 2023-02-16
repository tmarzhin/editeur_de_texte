package main;
import java.util.Scanner;

import command.*;
import invoker.*;
import receiver.*;
import undoRedo.*;
import memento.*;

public class MainApp {

	private CommandInvoker ci;
	private Engine engine;
	private Recorder recorder;
	private UndoRedo undoredo;
	
	private Copy copier;
	private Cut couper;
	private Delete supprimer;
	private Insert inserer;
	private Paste coller;
	private Start start;
	private Stop stop;
	private Replay replay;
	private Undo undo;
	private Redo redo;
	
	private Scanner scanner;
	
	public Scanner getScan() {
		return this.scanner;
	}
	
	public MainApp(CommandInvoker ci,Engine engine,Recorder recorder,UndoRedo undoredo) {
		this.ci = ci;
		this.engine = engine;
		this.recorder = recorder;
		this.undoredo = undoredo;
		this.initialisationCommandes();
		this.scanner = new Scanner(System.in);
	}
	
	public void initialisationCommandes() {
		this.copier = new Copy(engine,recorder,undoredo);
		this.couper = new Cut(engine,recorder,undoredo);
		this.supprimer = new Delete(engine,recorder,undoredo);
		this.inserer = new Insert(engine,recorder,undoredo);
		this.coller = new Paste(engine,recorder,undoredo);
		this.start = new Start(recorder);
		this.stop = new Stop(recorder);
		this.replay = new Replay(recorder);
		this.undo = new Undo(undoredo);
		this.redo = new Redo(undoredo);
		ci.addCommand("copier", copier);
		ci.addCommand("couper", couper);
		ci.addCommand("supprimer", supprimer);
		ci.addCommand("inserer", inserer);
		ci.addCommand("coller", coller);
		ci.addCommand("start", start);
		ci.addCommand("stop", stop);
		ci.addCommand("replay", replay);
		ci.addCommand("undo", undo);
		ci.addCommand("redo", redo);
		
	}
	
	public void runApp() {
    	while(true) {
    	System.out.print("Veuillez choisir une commande dans la liste suivante :");
    	ci.listeDesCommandes();
    	String commande = scanner.nextLine();
    	ci.executeCommand(commande);
    	commande = scanner.nextLine();
    	}
    }
	
	public static void main(String[] args){
		EngineImpl engine = new EngineImpl();
		CommandInvoker ci = new CommandInvoker();
		RecorderImpl recorder = new RecorderImpl();
		UndoRedoImpl undoredo = new UndoRedoImpl(engine);
		MainApp main = new MainApp(ci,engine,recorder,undoredo);
		main.initialisationCommandes();
		main.runApp();
	}

}
