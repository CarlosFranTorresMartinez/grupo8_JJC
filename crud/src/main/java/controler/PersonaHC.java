package controler;

import dao.PersonaHD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.PersonaH;

@Named(value = "personaHC")
@SessionScoped
public class PersonaHC implements Serializable {

    private final PersonaHD dao;
    private PersonaH model;
    private List<PersonaH> lista_hombre;

    public PersonaHC() {
        dao = new PersonaHD();
        model = new PersonaH();
        lista_hombre = new ArrayList();
    }

    @PostConstruct
    public void init() {
        listado();
    }

    public void addPersonaH() {
        try {
            dao.add(model);
            listado();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha registrado ", "Correctamente"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error controller PersonaHC: " + e);
        }
    }

    public void listado() {
        try {
            lista_hombre = dao.list();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        model = new PersonaH();
    }

    public PersonaH getModel() {
        return model;
    }

    public void setModel(PersonaH model) {
        this.model = model;
    }

    public List<PersonaH> getLista_hombre() {
        return lista_hombre;
    }

    public void setLista_hombre(List<PersonaH> lista_hombre) {
        this.lista_hombre = lista_hombre;
    }

}
