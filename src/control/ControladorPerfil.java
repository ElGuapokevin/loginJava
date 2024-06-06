package control;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import login.conecion;
import model.perfil;

public class ControladorPerfil {
    
    String sql;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    public boolean insertarPerfil(perfil perfil) {
        sql = "INSERT INTO perfil(profileCod, nombre, apellido, telefono) VALUES (?,?,?,?)";
        
        boolean inserted = false;
        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, perfil.getPerfilCod());
            pstmt.setString(2, perfil.getNombre());
            pstmt.setString(3, perfil.getApellido());
            pstmt.setInt(4, perfil.getTelefono());

            int success = pstmt.executeUpdate();
            if (success > 0) {
                inserted = true;            }
        } catch (SQLException e) {
            System.out.println("Error al insertar paciente: " + e.getMessage());
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
    
    
    public boolean eliminarPerfil(int idPerfil) {
        sql = "DELETE FROM perfil WHERE profileCod=?";
        boolean deleted = false;

        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idPerfil);

            int success = pstmt.executeUpdate();
            if (success > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar perfil: " + e.getMessage());
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


    public boolean modificarPerfil(perfil perfil) {
        sql = "UPDATE perfil SET profileCod=?,nombre=?,apellido=?,telefono=? WHERE profilecod=?";
        boolean updated = false;
        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, perfil.getPerfilCod());
            pstmt.setString(2, perfil.getNombre());
            pstmt.setString(3, perfil.getApellido());
            pstmt.setInt(4, perfil.getTelefono());
            pstmt.setInt(5, perfil.getPerfilCod());
            int success = pstmt.executeUpdate();
            if (success > 0) {
                updated = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar perfil: " + e.getMessage());
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

    public perfil buscarPerfil(int idPerfil) {
        sql = "SELECT * FROM perfil WHERE profileCod=?";
        perfil perfilEncontrado = null;

        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idPerfil);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                perfilEncontrado = new perfil();
                perfilEncontrado.setPerfilCod(rs.getInt("profileCod"));
                perfilEncontrado.setNombre(rs.getString("nombre"));
                perfilEncontrado.setApellido(rs.getString("apellido"));
                perfilEncontrado.setTelefono(rs.getInt("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar perfil: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        return perfilEncontrado;
    }

    public ArrayList<perfil> listarPerfiles() {
        sql = "SELECT * FROM perfil";
        ArrayList<perfil> perfiles = new ArrayList<>();

        try {
            conn = conecion.obtenerConexion();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                perfil p = new perfil();
                p.setPerfilCod(rs.getInt("profileCod"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTelefono(rs.getInt("telefono"));
                perfiles.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar perfiles: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexiones: " + ex.getMessage());
            }
        }
        return perfiles;
    }
    
}
