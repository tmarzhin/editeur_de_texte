package command;
import memento.CommandOriginator;
import memento.Memento;
import memento.Recorder;
import receiver.Engine;
import undoRedo.UndoRedo;


public class Delete implements CommandOriginator {
	Engine engine;
	private Recorder recorder;
	private UndoRedo undoredo;
	
	/**
	 * @param engine l'Engine qui exécutera l'action de la Commande Supprimer
	 * @param recorder le Recorder qui recevra un appel d'enregistrement lors de l'utilisation de la commande
	 */
	public Delete(Engine en,Recorder recorder,UndoRedo undoredo) {
		this.engine = en;
		this.recorder = recorder;
		this.undoredo = undoredo;
	}
	
	@Override
	public void execute() {
		engine.delete();
		recorder.save(this);
		undoredo.store();
	}
	
	/**
     *implémentation ne retournant rien car l'action Supprimer n'a pas de sauvegarde du texte à copier
     */
	public Memento getMemento() {
		return null;
	}
	
	/**
     *implémentation ne retournant rien car l'action Supprimer n'a pas de sauvegarde du texte à copier
     */
	public void setMemento(Memento m){
		
	}

}