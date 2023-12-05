package guiStaedtischeEinrichtungen;

import MyObserver.MyObserver;
import business.BuergeraemterModel;
import guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;



public class StaedtischeEinrichtungenControl implements MyObserver {
	
	private StaedtischeEinrichtungenView staedtischeEinrichtungenView;
	private BuergeraemterModel buergeraemterModel;

	public StaedtischeEinrichtungenControl(Stage primaryStage){
		this.buergeraemterModel = BuergeraemterModel.getInstanz();
		this.staedtischeEinrichtungenView = new StaedtischeEinrichtungenView(this, primaryStage,buergeraemterModel);
		buergeraemterModel.addObserver(this);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		staedtischeEinrichtungenView.zeigeBuergeraemterAn();

		
	}
}
	