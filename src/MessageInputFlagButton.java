import java.awt.*;
import java.util.Vector;


public class MessageInputFlagButton extends Panel {
    protected String messageText;
    protected String flagText;
    protected String buttonText;

    protected Label message;
    protected TextField input;
    protected Checkbox flag;
    protected Button button;


    public MessageInputFlagButton() {
        this("Message");
    }

    public MessageInputFlagButton(String messageText) {
        this(messageText, "Flag", "Button");
    }

    public MessageInputFlagButton(String messageText, String flagText, String buttonText) {
        setLayout(new BorderLayout(40, 15));


        message = new Label();
        input = new TextField();
        Panel panelMessageInput = new Panel();
        panelMessageInput.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 15));
        panelMessageInput.add(message);
        panelMessageInput.add(input);

        add(panelMessageInput, BorderLayout.CENTER);

        Panel buttonBox = new Panel();
        flag = new Checkbox();
        button = new Button();
        buttonBox.add(flag);
        buttonBox.add(button);
        add(buttonBox, BorderLayout.SOUTH);



        try {
            setMessageText(messageText);
            setButtonText(buttonText);
            setFlagText(flagText);
        } catch (Exception ignored) {

        }
    }

    protected Vector<MIFBListener> listeners = new Vector<>();

    public void addMIFBListener(MIFBListener l) {
        listeners.addElement(l);
    }

    public void removeAnswerListener(MIFBListener l) {
        listeners.removeElement(l);
    }

    public void fireEvent(MIFBEvent e) {
        Vector list = (Vector) listeners.clone();
        for (int i = 0; i < list.size(); i++) {
            MIFBListener listener = (MIFBListener) list.elementAt(i);
            listener.click(e);

        }

    }

    public String getMessageText() {
        return messageText;
    }

    public String getFlagText() {
        return flagText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setMessageText(String messageText) {
        try {
            this.messageText = messageText;
            message.setText(messageText);
            message.setVisible((messageText != null) && (messageText.length() > 0));
            validate();
        } catch (Exception e){

        }
    }

    public void setInputText(String inputText) {
        try {
            input.setText(inputText);
            input.setVisible((inputText != null) && (inputText.length() > 0));
            validate();
        } catch (Exception e) {

        }

    }

    public void setFlagText(String flagText) {
        try {
            this.flagText = flagText;
            flag.setLabel(flagText);
            flag.setVisible((flagText != null) && (flagText.length() > 0));
            validate();
        } catch (Exception e) {

        }

    }

    public void setButtonText(String buttonText) {
        try {
            this.buttonText = buttonText;
            button.setLabel(buttonText);
            button.setVisible((buttonText != null) && (buttonText.length() > 0));
            validate();
        } catch (Exception e) {

        }

    }


}
