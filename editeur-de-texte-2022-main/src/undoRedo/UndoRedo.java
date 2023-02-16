package undoRedo;


public interface UndoRedo {
	
	/**
	 * m�thode annulant la derni�re commande de l'utilisateur similaire au raccourci CTRL + Z
	 */
	public void undo();
	
	 /**
     * m�thode qui refait la derni�re commande de l'utilisateur similaire au raccourci CTRL + Y
     */
	public void redo();
	
	/**
     * m�thode qui sauvegarde la derni�re commande de l'utilisateur 
     */
	public void store();
	

}
