package dk.hungarian.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientGUIController {


    @FXML
    private TextArea displayTextArea;

    @FXML
    private TextArea inputTextArea;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {

        try
        {
            Socket s = new Socket("127.0.0.1", 8001);
            displayTextArea.appendText("\n** Er tilsluttet til serveren");

            while(true)
            {
                InputStream input = s.getInputStream();
                OutputStream output = s.getOutputStream();

                Scanner in = new Scanner(input);

                PrintWriter out = new PrintWriter(output, true);

                // Nu kan vi så sende og modtage respektivt
                displayTextArea.appendText("\nVelkomst fra svr: " + in.nextLine());

                displayTextArea.appendText("\nBesked er sendt.");
                String besked = inputTextArea.getText();
                out.println(besked);
                // Vi udskriver nu bare direkte
                displayTextArea.appendText("\nSvar fra server: " + in.nextLine());

                s.close();
                System.out.println("Forbindelsen lukket.");
            }
        }
        catch (IOException ex)
        {
            // We ignore this
            displayTextArea.appendText("\nFejl. Start serveren, hvis ikke den kører. ");
        }

    }

    @FXML
    protected void handleResetButtonAction(ActionEvent event) {
        displayTextArea.setText("Her kan du se svar fra serveren....");
    }





}
