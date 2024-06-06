package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import login.conecion;
import model.correo;

public class ControlCorreo {
    String sql;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    public boolean insertarCorreo(correo correo) {
        sql = "INSERT INTO correo(correoId, profileCod, correo, contracena)  VALUES (?,?,?,?)";
        
        boolean inserted = false;
        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, correo.getCorreoID());
            pstmt.setInt(2,correo.getPerfilID());
            pstmt.setString(3, correo.getCorreo());
            pstmt.setString(4, correo.getContracena());         

            int success = pstmt.executeUpdate();
            if (success > 0) {
                inserted = true;            }
        } catch (SQLException e) {
            System.out.println("Error al insertar Correo: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        return inserted;
    }
    
    
    public boolean eliminarCorreo(int idCorreo) {
        sql = "DELETE FROM correo WHERE correoId=?";
        boolean deleted = false;

        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idCorreo);

            int success = pstmt.executeUpdate();
            if (success > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar correo: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        return deleted;
    }


    public boolean modificarCorreo(correo correo) {
        sql = "UPDATE correo SET  correo=?, contracena=? WHERE correoId=?";
        boolean updated = false;
        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, correo.getCorreo());
            pstmt.setString(2, correo.getContracena());
            pstmt.setInt(3, correo.getCorreoID());
            int success = pstmt.executeUpdate();
            if (success > 0) {
                updated = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar correo: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        return updated;
    }


    public correo buscarCorreo(String idCorreo) {
        sql = "SELECT * FROM correo WHERE correo=?";
        correo correoEncontrado = null;

        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idCorreo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                correoEncontrado = new correo();
                correoEncontrado.setCorreoID(rs.getInt("correoId"));
                correoEncontrado.setPerfilID(rs.getInt("profileCod"));
                correoEncontrado.setCorreo(rs.getString("correo"));
                correoEncontrado.setContracena(rs.getString("contracena"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar correo: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        return correoEncontrado;
    }

   /* public ArrayList<correo> listarCorreo() {
        sql = "SELECT * FROM correo";
        ArrayList<correo> correos = new ArrayList<>();

        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                correo c = new correo();
                c.setCorreoID(rs.getInt("correoId"));
                c.setPerfilID(rs.getInt("profileCod"));
                c.setCorreo(rs.getString("correo"));
                c.setContracena(rs.getString("contracena"));
                correos.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar correo: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        return correos;
    }
    */
/*-----------------------------------------------------------------------------------------------------------------------------------*/
public boolean validarCredenciales(String correo, String contrasena) {
        String sql = "SELECT * FROM correo WHERE correo = ? AND contracena = ?";
       
        boolean valido = false;

        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, correo);
            pstmt.setString(2, contrasena);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                valido = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al validar credenciales: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        return valido;
    }    
}
