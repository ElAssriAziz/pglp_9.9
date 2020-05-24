package uvsq.fr.pglp9_9;

public class Invocateur {
	Commande commande;

	public void exec(Commande commande) {
		this.commande = commande;
		commande.execute();
	}
}
