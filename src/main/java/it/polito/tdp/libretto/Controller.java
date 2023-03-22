package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	private Libretto model;

	
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    //comboBox e' un contenitore
    private ComboBox<Integer> comboVotoPunti;

    @FXML
    private DatePicker data;

    @FXML
    private TextField txtNomeCorso;
    
    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	String corso = this.txtNomeCorso.getText();
    	int punteggio = this.comboVotoPunti.getValue(); 
    	LocalDate dataEsame = this.data.getValue();
    	
    	Voto v = new Voto(corso, punteggio, dataEsame);
    	this.model.add(v);	//ho aggiunto un voto
    	
    	this.txtResult.setText(this.model.toString());

    }

    @FXML
    void initialize() {
        assert comboVotoPunti != null : "fx:id=\"comboVotoPunti\" was not injected: check your FXML file 'main.fxml'.";
        assert data != null : "fx:id=\"data\" was not injected: check your FXML file 'main.fxml'.";
        assert txtNomeCorso != null : "fx:id=\"txtNomeCorso\" was not injected: check your FXML file 'main.fxml'.";
        
        for(int p = 18; p<=30; p++) {
            comboVotoPunti.getItems().add(p);;	//e' una lista a utti gli effetti
        }
        
    }
    
    public void setModel(Libretto model) {
		this.model = model;
		this.txtResult.setText(this.model.toString());
	}

}
