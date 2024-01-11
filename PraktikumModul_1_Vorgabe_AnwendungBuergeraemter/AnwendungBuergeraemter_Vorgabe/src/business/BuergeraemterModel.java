package business;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

import MyObserver.MyObservable;
import MyObserver.MyObserver;
import fabrikMethode.ConcreteCreator;
import fabrikMethode.Creator;
import fabrikMethode.Product;

public class BuergeraemterModel implements MyObservable{
LinkedList<MyObserver> liste = new LinkedList<MyObserver>();
	
	private ArrayList<Buergeramt> buergeraemterList = new ArrayList<Buergeramt>();
	
	public static BuergeraemterModel instanz=null;
	
	public static BuergeraemterModel getInstanz() {
		if(instanz == null) {
			instanz = new BuergeraemterModel();
		}
		return instanz;
	}
	
	
	public ArrayList<Buergeramt> getBuergeraemterList() {
		return buergeraemterList;
	}



	private BuergeraemterModel () {
		
	}
	
	private Buergeramt buergeramt;

	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	
	  public void addBuergeramt(Buergeramt buergeramt) {
	        buergeraemterList.add(buergeramt);
	        notifyObservers();
	    }
 		
 		
	public void schreibeBuergeraemterInCsvDatei()
	    throws IOException{
		Creator creator =new ConcreteCreator();
		Product writer = creator.factoryMethod();
		for (Buergeramt buergeramt : buergeraemterList) {
		writer.fuegeInDateiHinzu(buergeramt);
		}
		
		writer.schliessDatei();

 	}
	public void schreibeBuergeraemterInTxtDatei() throws IOException{
		Creator creator =new ConcreteCreator();
		Product writer = creator.factoryMethod();
		for (Buergeramt buergeramt : buergeraemterList) {
		writer.fuegeInDateiHinzu(buergeramt);
		}
		writer.schliessDatei();
	}

	@Override
	public void addObserver(MyObserver obs) {
		// TODO Auto-generated method stub
		liste.add(obs);
		
	}

	@Override
	public void removeObserver(MyObserver obs) {
		// TODO Auto-generated method stub
		liste.remove(obs);
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(MyObserver o:liste) {
            o.update();
        }
		
	}

}

