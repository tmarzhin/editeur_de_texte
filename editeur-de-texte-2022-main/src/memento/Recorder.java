package memento;

import command.Command;

public interface Recorder {
	
	/**
	 * méthode permettant de lancer l'enregistrement des actions effectuées par l'utilisateur pour les rejouer après
	 */
	public void start();
	
	/**
     * méthode devant arrêter l'enregistrement des actions effectuées par l'utilisateur
     */
	public void stop();
	
	 /**
     * méthode permettant d'ajouter une CommandOriginator 
     * @param c la CommandOriginator
     */
	public void save(CommandOriginator c);
	
	/**
     * méthode devant rejouer les commandes sauvegardées dans l'ordre
     */
	public void replay();

}
