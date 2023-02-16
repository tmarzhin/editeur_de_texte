package undoRedo;


public interface UndoRedo {
	
	/**
	 * méthode annulant la dernière commande de l'utilisateur similaire au raccourci CTRL + Z
	 */
	public void undo();
	
	 /**
     * méthode qui refait la dernière commande de l'utilisateur similaire au raccourci CTRL + Y
     */
	public void redo();
	
	/**
     * méthode qui sauvegarde la dernière commande de l'utilisateur 
     */
	public void store();
	

}
