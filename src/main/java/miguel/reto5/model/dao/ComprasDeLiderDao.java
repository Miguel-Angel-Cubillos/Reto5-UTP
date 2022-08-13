/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miguel.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import miguel.reto5.model.vo.ComprasDeLiderVo;
import miguel.reto5.util.JDBCUtilities;

public class ComprasDeLiderDao {
    public List<ComprasDeLiderVo> listar() {
        ArrayList<ComprasDeLiderVo> respuesta = null;
        
        try{
            respuesta= new ArrayList<>();
            Connection conn = JDBCUtilities.getConnection();
            Statement stmt = null;
            ResultSet rset = null;
            String consulta = "SELECT l.Nombre || \" \"|| l.Primer_Apellido || \" \" || l.Segundo_Apellido AS LIDER,"
                    + " SUM(mc.Precio_Unidad * c.Cantidad) VALOR"
                    + " FROM Lider l"
                    + " INNER JOIN Proyecto p ON l.ID_Lider = p.ID_Lider"
                    + " INNER JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto"
                    + " INNER JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion"
                    + " GROUP BY l.Nombre || \" \"|| l.Primer_Apellido || \" \" || l.Segundo_Apellido"
                    + " ORDER BY VALOR DESC"
                    + " LIMIT 10";
            try{
                stmt = conn.createStatement();
                rset = stmt.executeQuery(consulta);
                while(rset.next()){
                    ComprasDeLiderVo vo = new ComprasDeLiderVo();
                    vo.setLider(rset.getString("Lider"));
                    vo.setValor(rset.getDouble("valor"));
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
            
        }   catch (SQLException ex) {
            Logger.getLogger(ComprasDeLiderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
}
