package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.PersonaH;

public class PersonaHD extends Conexion implements CRUDinterfaces<PersonaH> {

    @Override
    public void add(PersonaH model) throws Exception {
        this.conectar();
        try {
            String sql = "insert into PERSONAH (NOMPER, APEPER, DNIPER, ESTPERCV) values(?,?,?,?)";
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
    public void update(PersonaH model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(PersonaH model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaH> list() throws Exception {
        this.conectar();
        List<PersonaH> lista_hombre = null;
        PersonaH model;
        try {
            String sql = "SELECT * FROM PERSONAH \n"
                    + "ORDER BY ESTPERCV, NOMPER";
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista_hombre = new ArrayList();
            while (rs.next()) {
                model = new PersonaH();
                model.setIDPER(rs.getInt("IDPER"));
                model.setNOMPER(rs.getString("NOMPER"));
                model.setAPEPER(rs.getString("APEPER"));
                model.setDNIPER(rs.getInt("DNIPER"));
                model.setESTPERCV(rs.getString("ESTPERCV"));
                lista_hombre.add(model);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error dao_listaHombre: " + e);
        } finally {
            this.Cerrar();
        }
        return lista_hombre;
    }
}
