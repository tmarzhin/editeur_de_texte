package memento;


import java.util.*;

public class RecorderImpl implements Recorder {
	
	private boolean isRecording; // true si on est en train de sauvegarder les mementos false sinon
	private List<Memento> mementos;  // liste des mémentos sauvegardés
	private List<CommandOriginator> commands; // liste des commandes sauvegardées
	
	public RecorderImpl() {
		this.isRecording = false;
		this.mementos = new ArrayList<Memento>();
		this.commands = new ArrayList<CommandOriginator>();
	}
	
	public RecorderImpl(boolean record,ArrayList<Memento> m,ArrayList<CommandOriginator>cm) {
		this.isRecording = false;
		if(m.size()==cm.size()) {
			this.mementos = m;
			this.commands = cm;
		}
	}
	
	/**
	 * 
	 * @return true si on est en train d'enregistrer false sinon
	 */
	public boolean getRecording() {
		return this.isRecording;
	}
	
	/**
	 * 
	 * @return la liste des mémentos sauvegardés
	 */
	public List<Memento> getListMementos(){
		return this.mementos;
	}
	
	/**
	 * 
	 * @return la liste des commandes sauvegardées
	 */
	public List<CommandOriginator> getListCommands(){
		return this.commands;
	}
	
	/**
	 * démarre l'enregistrement et supprime le précédent
	 */
	public void start() {
		this.mementos.clear();
		this.commands.clear();
		this.isRecording = true;
		
	}
	
	/**
	 * stoppe l'enregistrement
	 */
	public void stop() {
		this.isRecording = false;
	}
	
	/**
	 * sauvegarde la commande et le mémento
	 */
	public void save(CommandOriginator commOrig) {
		if(this.getRecording()) {
			this.commands.add(commOrig);
			this.mementos.add(commOrig.getMemento());
		}
		
	}
	
	/**
	 * rejoue l'ensemble des commandes et mémentos enregistrés depuis le début
	 */
	public void replay() {
       this.stop();
       
       for(int i=0;i<this.commands.size();i++) {
    	   Memento m = mementos.get(i);
    	   commands.get(i).setMemento(m);
       }
       
	}

}
