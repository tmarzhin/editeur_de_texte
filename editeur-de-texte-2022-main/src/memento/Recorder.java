package memento;

import command.Command;

public interface Recorder {
	
	/**
	 * m�thode permettant de lancer l'enregistrement des actions effectu�es par l'utilisateur pour les rejouer apr�s
	 */
	public void start();
	
	/**
     * m�thode devant arr�ter l'enregistrement des actions effectu�es par l'utilisateur
     */
	public void stop();
	
	 /**
     * m�thode permettant d'ajouter une CommandOriginator 
     * @param c la CommandOriginator
     */
	public void save(CommandOriginator c);
	
	/**
     * m�thode devant rejouer les commandes sauvegard�es dans l'ordre
     */
	public void replay();

}
