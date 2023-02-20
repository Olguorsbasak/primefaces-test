package org.primefaces.test;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent("UIGreet")
@ResourceDependencies({
    @ResourceDependency(name = "test.js"),
    @ResourceDependency(name = "test.css")
})
public class UIGreet extends UIOutput {
    public UIGreet() {
        setRendererType(null);
    }

    protected enum PropertyKeys {
        greetText,
        size,
        style,
        styleClass,
        onclick
    }

    public String getGreetText() {
        return (String) getStateHelper().eval(PropertyKeys.greetText, "Hello");
    }

    public void setGreetText(String greetText) {
        getStateHelper().put(PropertyKeys.greetText, greetText);
    }

    public String getStyle() {
        return (String) getStateHelper().eval(PropertyKeys.style, null);
    }

    public void setStyle(String style) {
        getStateHelper().put(PropertyKeys.style, style);
    }

    public String getSize() {
        return (String) getStateHelper().eval(PropertyKeys.size, "1");
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

    public String getOnclick() {
        return (String) getStateHelper().eval(PropertyKeys.onclick, null);
    }

    public void setOnclick(String onclick) {
        getStateHelper().put(PropertyKeys.onclick, onclick);
    }
public void encodeEnd(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String greetText = getGreetText();
        String value = (String) getValue();
        String tagName = "h" + getSize();
        String styleClass = getStyleClass();
        String style = getStyle();

        writer.startElement(tagName, this);
        if (styleClass != null) {
            writer.writeAttribute("class", styleClass, null);
        }

        if (style != null) {
            writer.writeAttribute("style", style, null);
        }

        if (getOnclick() != null) {
            writer.writeAttribute("onclick", getOnclick(), null);
        }

        writer.write(greetText + " " + value);

        writer.endElement("span");
    }

}