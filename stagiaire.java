package YT;

public class stagiaire {
	private String nInscription;
	private String nomcomplet;
	
	
	public stagiaire(String nInscription, String nomcomplet) throws Exception {
		if(nInscription.length() == 12) {
		this.nInscription = nInscription;}
		else {
			throw new Exception("numero d'inscription invalide");
		}
		this.nomcomplet = nomcomplet;
	}
	
	public stagiaire () {}
	
	public boolean equal(stagiaire s) {
		 return this.getnInscription().equals(s.getnInscription());
	}

	@Override
	public String toString() {
		return "stagiaire [nInscription=" + nInscription + ", nomcomplet=" + nomcomplet + "]";
	}

	public String getnInscription() {
		return nInscription;
	}

	public void setnInscription(String nInscription) {
		this.nInscription = nInscription;
	}

	public String getNomcomplet() {
		return nomcomplet;
	}

	public void setNomcomplet(String nomcomplet) {
		this.nomcomplet = nomcomplet;
	}}
