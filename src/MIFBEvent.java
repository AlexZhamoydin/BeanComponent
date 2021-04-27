public class MIFBEvent extends java.util.EventObject{
    public static boolean NOT_PRESSED = false, PRESSED = true;

    protected boolean pressed;
    protected String inputText;
    public MIFBEvent(Object source, boolean pressed, String inputText) {
        super(source);
        this.pressed = pressed;
        this.inputText = inputText;
    }
    public boolean getPressed() {
        return pressed;
    }
    public String getInputText(){
        return inputText;
    }
}
