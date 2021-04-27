import java.beans.*;
import java.awt.*;


public class ButtonEditor extends PropertyEditorSupport{

    /** Return the list of value names for the enumerated type. */
    public String[] getTags() {
        return new String[] { "Hello world!", "12 group", "Hello world again!" };
    }

    /** Convert each of those value names into the actual value. */
    public void setAsText(String s) {
        setValue(s);
    }

    /** This is an important method for code generation. */
    public String getJavaInitializationString() {
        // Object o = getValue();


        return (String)getValue();
    }
}
