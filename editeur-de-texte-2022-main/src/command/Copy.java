package command;
import memento.CommandOriginator;
import undoRedo.*;
import memento.Memento;
import memento.Recorder;
import receiver.Engine;


public class Copy implements CommandOriginator{
	
	private Engine engine;
	private Recorder recorder;
	private UndoRedo undoredo;
	
	/**
	 * @param engine l'Engine qui ex�cutera l'action de la Commande Copier
	 * @param recorder le Recorder qui recevra un appel d'enregistrement lors de l'utilisation de la commande
	 */
	public Copy(Engine en,Recorder recorder,UndoRedo undoredo) {
		this.engine = en;
		this.recorder = recorder;
		this.undoredo = undoredo;
	}
	
	
	@Override
	public void execute() {
		engine.copySelectedText();
		recorder.save(this);
		undoredo.store();
	}
	
	/**
     *impl�mentation ne retournant rien car l'action Copier n'a pas de sauvegarde du texte � copier
     */
	public Memento getMemento() {
		return null;
	}
	
	/**
     * impl�mentation ne retournant rien car l'action Copier n'a pas de sauvegarde du texte � copier
     */
	public void setMemento(Memento m) {
		
	}

}