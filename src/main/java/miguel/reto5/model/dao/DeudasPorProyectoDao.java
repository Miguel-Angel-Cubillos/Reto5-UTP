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
import miguel.reto5.model.vo.DeudasPorProyectoVo;
import miguel.reto5.util.JDBCUtilities;


public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listar(Double limite){
        ArrayList<DeudasPorProyectoVo> respuesta = null;
        
        try {
            respuesta = new ArrayList<> ();
            Connection conn = JDBCUtilities.getConnection();
            PreparedStatement stmt = null;
            ResultSet rset = null;
            String consulta = "SELECT p.ID_Proyecto AS ID, SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR"
                    + " FROM Proyecto p INNER JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto"
                    + " INNER JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion"
                    + " WHERE c.Pagado = 'No' "
                    + " GROUP BY p.ID_Proyecto"
                    + " HAVING SUM(mc.Precio_Unidad * c.Cantidad) > ?"
                    + " ORDER BY VALOR DESC";
            try{
                stmt = conn.prepareStatement(consulta);
                stmt.setDouble(1, limite);
                rset = stmt.executeQuery();
                while(rset.next()){
                    DeudasPorProyectoVo vo = new DeudasPorProyectoVo();
                    vo.setId(rset.getInt("ID"));
                    vo.setValor(rset.getDouble("VALOR"));
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
