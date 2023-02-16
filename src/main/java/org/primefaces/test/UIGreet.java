package org.primefaces.test;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent("UIGreet")
public class UIGreet extends UIOutput {
    public UIGreet() {
        setRendererType(null);
    }

    protected enum PropertyKeys {
        greetText,
        size,
        styleClass,
        style
    }

    public String getGreetText() {
        return (String) getStateHelper().eval(PropertyKeys.greetText, "Hello");
    }

    public void setGreetText(String greetText) {
        getStateHelper().put(PropertyKeys.greetText, greetText);
    }

    public String getSize() {
        return (String) getStateHelper().eval(PropertyKeys.size, null);
    }

    public void setSize(String size) {
        getStateHelper().put(PropertyKeys.size, size);
    }
    public String getStyleClass() {
        return (String) getStateHelper().eval(PropertyKeys.styleClass, null);
    }
    
    public void setStyleClass(String styleClass) {
        getStateHelper().put(PropertyKeys.styleClass, styleClass);
    }
    
    public String getStyle() {
        return (String) getStateHelper().eval(PropertyKeys.style, null);
    }
    
    public void setStyle(String style) {
        getStateHelper().put(PropertyKeys.style, style);
    }
    

    public void encodeEnd(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String greetText = getGreetText();
        String value = (String) getValue();
        String size = getSize();
        String styleClass=getStyleClass();
        String style=getStyle();

        if(size !=null){
            int headerSize=Integer.parseInt(size);
            if(headerSize>=1 && headerSize<=6){
                writer.startElement("h"+headerSize, this);
                writer.write(greetText + " " + value);
                writer.endElement("h"+headerSize);
                return;
            }
        }

        writer.startElement("span", this);
        if(styleClass !=null){
            writer.writeAttribute("class",styleClass,null);
        }
        if(style !=null){
            writer.writeAttribute("style",style,null);
        }
        writer.write(greetText + " " + value);
        writer.endElement("span");

    }

}
