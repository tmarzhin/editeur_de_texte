package command;
import memento.Recorder;
import receiver.Engine;

/**
 * Commande permettant de rejouer l'enregistrement
 * n'implémente pas CommandOriginator pour éviter les enregistrements d'enregistrements
 */
public class Replay implements Command{
	
	private Recorder recorder;
	
	/**
	 * @param recorder le recorder à exécuter
	 */
	public Replay(Recorder recorder) {
		this.recorder = recorder;
	}
	
	/**
	 * rejoue les commandes enregistrées
	 */
	public void execute() {
		recorder.replay();
	}

}
