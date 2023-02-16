package command;
import memento.CommandOriginator;

import memento.Memento;
import memento.Recorder;
import receiver.Engine;
import undoRedo.*;


public class Paste implements CommandOriginator {
	private Engine engine;
	private Recorder recorder;
	private UndoRedo undoredo;

	
	/**
	 * @param engine l'Engine qui ex�cutera l'action de la Commande Coller
	 * @param recorder le Recorder qui recevra un appel d'enregistrement lors de l'utilisation de la commande
	 */
	public Paste(Engine en,Recorder recorder,UndoRedo undoredo) {
		this.engine = en;
		this.recorder = recorder;
		this.undoredo = undoredo;
	} 
	
	
	public void execute() {
		engine.pasteClipboard();
		recorder.save(this);
		undoredo.store();
	}
	
	/**
     *impl�mentation ne retournant rien car l'action Coller n'a pas de sauvegarde du texte � copier
     */
	public Memento getMemento() {
		return null;
	}
	
	/**
     * impl�mentation ne retournant rien car l'action Coller n'a pas de sauvegarde du texte � copier
     */
	public void setMemento(Memento m) {
		
	}

}