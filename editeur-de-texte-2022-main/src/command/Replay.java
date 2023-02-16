package command;
import memento.Recorder;
import receiver.Engine;

/**
 * Commande permettant de rejouer l'enregistrement
 * n'impl�mente pas CommandOriginator pour �viter les enregistrements d'enregistrements
 */
public class Replay implements Command{
	
	private Recorder recorder;
	
	/**
	 * @param recorder le recorder � ex�cuter
	 */
	public Replay(Recorder recorder) {
		this.recorder = recorder;
	}
	
	/**
	 * rejoue les commandes enregistr�es
	 */
	public void execute() {
		recorder.replay();
	}

}
