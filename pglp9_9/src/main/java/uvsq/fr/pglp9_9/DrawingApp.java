package uvsq.fr.pglp9_9;

public class DrawingApp {

	public static void main(String[] args) {
		DrawingApp app = new DrawingApp();
		app.run();
	}
	 public void run() {
		 boolean exit = false;
		 Invocateur invocateur = new Invocateur();
		 DrawingTUI draw = new DrawingTUI();	  
		 while(!exit){
			 Commande cmd = draw.nextCommand();
			 if (cmd == null) {
				 System.out.print("Exit....");
				 break;
				 }
			 invocateur.exec(cmd);
			 draw.Affichage(cmd);
		  };
	   }

}
