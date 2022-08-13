/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miguel.reto5.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import miguel.reto5.model.vo.ProyectoBancoVo;
import miguel.reto5.util.JDBCUtilities;


public class ProyectoBancoDao {
    public List<ProyectoBancoVo> listar (String banco) {
        
        ArrayList<ProyectoBancoVo> respuesta = null;
        
        try {
            respuesta = new ArrayList<> ();
            Connection conn = JDBCUtilities.getConnection();
            PreparedStatement stmt = null;
            ResultSet rset = null;
            String consulta = "SELECT p.ID_Proyecto ID, p.Constructora, p.Ciudad, p.Clasificacion, t.Estrato,"
                    + " l.Nombre || \" \"|| l.Primer_Apellido || \" \" || l.Segundo_Apellido AS LIDER"
                    + " FROM Proyecto p INNER JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo"
                    + " INNER JOIN Lider l ON p.ID_Lider = l.ID_Lider"
                    + " WHERE p.Banco_Vinculado = ?"
                    + " ORDER BY p.Fecha_Inicio DESC , p.Ciudad, p.Constructora";
            try{
                stmt = conn.prepareStatement(consulta);
                stmt.setString(1, banco);
                rset = stmt.executeQuery();
                while(rset.next()){
                    ProyectoBancoVo vo = new ProyectoBancoVo();
                    vo.setId(rset.getInt("ID"));
                    vo.setCiudad(rset.getString("Ciudad"));
                    vo.setClasificacion(rset.getString("Clasificacion"));
                    vo.setConstructora(rset.getString("Constructora"));
                    vo.setEstrato(rset.getInt("Estrato"));
                    vo.setLider(rset.getString("Lider"));
                    respuesta.add(vo);
                }
            } finally {
                if (rset != null){
                    rset.close();
                }
                if (stmt != null){
                    stmt.close();
                }
                if (conn != null){
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoBancoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
}
