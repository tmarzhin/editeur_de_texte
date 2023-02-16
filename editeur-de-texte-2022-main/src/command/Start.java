package command;
import memento.Recorder;
import receiver.Engine;


/**
 * commande permettant de lancer l'enregistrement des mémentos et commandes
 */

public class Start implements Command{
	
	private Recorder recorder;
	
	/**
	 * @param recorder le Recorder à appeler pour demander le début de l'enregistrement 
	 */
	public Start(Recorder recorder) {
		this.recorder = recorder;
	}
	
	/**
	 * lance le début de l'enregistrement
	 */
	public void execute() {
		recorder.start();
	}

}
