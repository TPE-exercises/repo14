package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

public abstract class MyEisdiele {

	protected MyEis[] eiskarte;

	/**
	 * constructor with the number of ice on the card
	 * @param anzahlEis
	 */
	MyEisdiele(int anzahlEis){
		eiskarte = new MyEis[anzahlEis];
	}

	/**
	 * order your icecream
	 * @param typ the name of the icecream
	 */
	public void bestellen(String typ) {
		boolean eisVorhanden = false;
		for (int i = 0; i < eiskarte.length; i++) {
			if (eiskarte[i] != null && typ.equals(eiskarte[i].getName())) {
				eisVorhanden = true;
				this.begruessen();
				eiskarte[i].vorbereiten();
				eiskarte[i].fuellen();
				eiskarte[i].dekorieren();
				this.kassieren(eiskarte[i]);
				this.verabschieden();
			}
			if (i == eiskarte.length - 1 && eisVorhanden == false) {
				this.entschuldigen();
			}
		}
	}

	/**
	 * welcome the guest
	 */
	protected abstract void begruessen();

	/**
	 * to cash up the guest
	 * @param eis
	 */
	protected abstract void kassieren(MyEis eis);

	/**
	 * say goodbye to the guest
	 */
	protected abstract void verabschieden();

	/**
	 * say sorry to the guest
	 */
	protected abstract void entschuldigen();
	
	/**
	 * create a new ice
	 * @param typ name of the ice
	 * @return new ice
	 */
	public abstract MyEis erstellen(String typ);
	
	/**
	 * set the ice on the icecard
	 * @param eis
	 */
	protected void setEisAufEiskarte(MyEis eis){
		for(int i = 0; i < eiskarte.length; i++){
			if(eiskarte[i] == null){
				eiskarte[i] = eis;
				return;
			}
		}
	}

}
