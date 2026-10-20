package com.dmd.testinterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    private Contador contadorObj;

    @FXML private TextField txtClics;        
    @FXML private Button btnContar;      
    @FXML private ProgressBar progressBar;    
    @FXML private Button btnEsperar;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contadorObj = new Contador();
        txtClics.setText(String.valueOf(contadorObj.getNumeroClics()));
    }

    @FXML
    private void contarClic() {
        
        contadorObj.incrementarClic();
        txtClics.setText(String.valueOf(contadorObj.getNumeroClics()));
        
    }

    @FXML
    private void iniciarEspera() {
        
        btnEsperar.setDisable(true);
        progressBar.setProgress(0.0);

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(100);
                        
                        double avance = i / 100.0;
                        
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(avance);
                            }
                        });
                    }
                    
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            btnEsperar.setDisable(false);
                        }
                    });
                    
                } catch (InterruptedException e) {
                    System.out.println("Error en el hilo");
                }
            }
        });
        
        hilo.start();
    }
}