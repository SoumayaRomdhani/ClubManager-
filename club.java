package YT;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class club {
	List<stagiaire> membres;

	public club(List<stagiaire> membres) {
		this.membres = membres;
	}

	public club() {
		membres=new ArrayList();
	}
	
	public int nombremembres() {
		return membres.size();
	}
	public int indicede(stagiaire membre) {
		for(int i=0;i<membres.size();i++){
			stagiaire s= membres.get(i);
			if(s.equals(membre)) 
				return i;
			}
				return -1;}
	public Boolean ajouter( stagiaire membre) {
		if (this.indicede(membre)== -1) {
			membres.add(membre);
			return true ;
		}else {
			return false;
		}
		//2eme methode
		//if(membres.contains(membre){
		//   return false;}
		//else {
		//   membres.add(membre);
		//   return true ;
		}
	
	
	public void supprimer(String ninscription ) throws Exception {
		int indice =-1;
		for(stagiaire s:membres) 
			if(s.getnInscription().equals(ninscription)) {
				indice = this.indicede(s);
			}
			if(indice== -1) {
				throw new Exception ("pas de stagiaire avec ce numero d'inscription dans le club");	
			}else {
				membres.remove(indice);
		}}
	//c'est la surcharge , deux methodes avec le meme nom mais de parameters differents
	public void supprimer (stagiaire stagiaire)throws Exception{
		int indice =-1;
		for(stagiaire s:membres) {
			if (s.equals(stagiaire)) {
				indice = this.indicede(s);
			}
			if(indice== -1) {
				throw new Exception ("pas de stagiaire avec ce numero d'inscription dans le club");	
			}else {
				membres.remove(indice);
		}
	}}
	public void enregistrer () {
		File fichier = new File("club de lecture.bin");
		FileWriter fw=null;
		try {
			fw = new FileWriter(fichier);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		for(stagiaire s:membres) {
			//il va chercher la methode tostring de l'objet stagiaire
			pw.println(s);
		}
		pw.close();
	}
	public void charger() throws FileNotFoundException ,Exception {
		File fichier = new File("club de lecture.bin");
		Scanner scan = new Scanner(fichier);
		String ninscription ="";
		String nomcomplet ="";
		while(scan.hasNext()){{
			String ligne =scan.nextLine();
			ninscription = ligne.substring(10,22);
			nomcomplet = ligne.substring(23);
			//ici il declenche une exception si le num d'inscr ne respecte pas les normes
			stagiaire s =new stagiaire(ninscription ,nomcomplet);
			this.ajouter(s);
			}
		}
	}
	@Override
	public String toString() {
		String s1 = "club de lecture:";
		String s2 = "-membres (" + this.nombremembres()+"):";
		String s3 ="";
		for(stagiaire s:membres) {
			s3+="  *"+s+"\n";
		}
		return s1+"\n"+s2+"\n"+s3;
	}       
	
	
	}
	
