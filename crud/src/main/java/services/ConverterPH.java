package services;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterPH")
public class ConverterPH implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        String ESTPERCV = "";
        if (t != null) {
            ESTPERCV = (String) t;
            switch (ESTPERCV) {
                case "S":
                    ESTPERCV = "SOLTERO";
                    break;
                case "C":
                    ESTPERCV = "CASADO";
                    break;
            }
        }
        return ESTPERCV;
    }
}
