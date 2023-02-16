package command;
import memento.Recorder;
import receiver.Engine;


/**
 * commande permettant de lancer l'enregistrement des m�mentos et commandes
 */

public class Start implements Command{
	
	private Recorder recorder;
	
	/**
	 * @param recorder le Recorder � appeler pour demander le d�but de l'enregistrement 
	 */
	public Start(Recorder recorder) {
		this.recorder = recorder;
	}
	
	/**
	 * lance le d�but de l'enregistrement
	 */
	public void execute() {
		recorder.start();
	}

}
