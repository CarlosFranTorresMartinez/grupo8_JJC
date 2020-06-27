/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.PersonaM;

/**
 *
 * @author carlos
 */
public class PersonaMD extends Conexion implements CRUDinterfaces<PersonaM> {

    @Override
    public void add(PersonaM model) throws Exception {
        this.conectar();
        try {
            String sql = "insert into PERSONAM (NOMPER, APEPER, DNIPER, ESTPERCV) values(?,?,?,?)";
            try (PreparedStatement ps = this.getCn().prepareStatement(sql)) {
                ps.setString(1, model.getNOMPER());
                ps.setString(2, model.getAPEPER());
                ps.setInt(3, model.getDNIPER());
                ps.setString(4, model.getESTPERCV());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error dao addPersonaHD: " + e);
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void update(PersonaM model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(PersonaM model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaM> list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
