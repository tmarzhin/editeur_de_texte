package invoker;
import java.util.HashMap;
import java.util.Map;

import command.Command;
import java.util.Scanner;
public class CommandInvoker {
	
	/**
	 * hashmap ayant pour clé un string correspondant au nom de la commande 
   	 *               pour valeur la commande associée    
	 */
	private Map<String,Command> command;
	
	public CommandInvoker() {
		this.command = new HashMap<String, Command>();
	}
	
	public CommandInvoker(Map<String,Command> map) {
		this.command = map;
	}
	
	/**
	 * 
	 * @param s le nom de la commande
	 * @param c la commande associée
	 * ajoute une nouvelle commande dans la map
	 */
	public void addCommand(String s ,Command c) {
		if((!command.containsKey(s)) && (!command.containsValue(c))) {
			command.put(s, c);
		}
	}
	
	/**
	 * 
	 * @param s le nom de la commande
	 * appelle la fonction execute() correspondant à la commande
	 */
	public void executeCommand(String s) {
		if(command.containsKey(s)) {
			Command comm = command.get(s);
			comm.execute();
		}else {
			System.out.println("la commande n'existe pas");
		}
	}
	
	/**
	 * liste de toutes les commandes enregistrées dans la map
	 */
    public void listeDesCommandes() {
        if (!command.isEmpty()) {
            for (Map.Entry<String, Command> c : command.entrySet()) {
                System.out.println(c.getKey());
            }
        }else{
            System.out.println("Aucune commande n'a été ajoutée");
        }
    }


}
