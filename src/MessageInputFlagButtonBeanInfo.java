import java.beans.*;
import java.lang.reflect.*;
import java.awt.*;
public class MessageInputFlagButtonBeanInfo extends SimpleBeanInfo {

    public Image getIcon(int kind) {
        return loadImage("MessageInputFlagButton.jpg");
    }

    static PropertyDescriptor prop(String name, String description) {
        try {
            PropertyDescriptor p =
                    new PropertyDescriptor(name, MessageInputFlagButton.class);
            p.setShortDescription(description);
            return p;
        } catch (IntrospectionException e) {
            return null;
        }
    }

    static PropertyDescriptor[] props = {
        prop("messageText", "The message text that appears in the bean body"),
        prop("flagText", "The checkbox text"),
        prop("buttonText", "The button text"),
        prop("background", "The background color"),
        prop("foreground", "The foreground color"),
    };
    static {
        props[0].setPropertyEditorClass(MessageEditor.class);
        props[1].setPropertyEditorClass(FlagEditor.class);
        props[2].setPropertyEditorClass(ButtonEditor.class);
    }

    public PropertyDescriptor[] getPropertyDescriptors() {
        return props;
    }



    public int getDefaultPropertyIndex() {
        return 0;
    }
}
