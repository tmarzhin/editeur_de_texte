package command;
import memento.Recorder;
import receiver.Engine;

/**
 * Commande permettant de mettre fin à l'enregistrement
 * n'implémente pas CommandOriginator pour éviter les enregistrements d'enregistrements
 */
public class Stop implements Command{
	
	private Recorder recorder;
	
	/**
	 * @param recorder le Recorder à appeler pour demander la fin de l'enregistrement 
	 */
	public Stop(Recorder record) {
		this.recorder = record;
	}
	
	/**
	 * stoppe l'enregistrement
	 */
	public void execute() {
		recorder.stop();
	}

}
