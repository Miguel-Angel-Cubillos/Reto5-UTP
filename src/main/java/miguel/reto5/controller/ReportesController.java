/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miguel.reto5.controller;

import java.util.List;
import miguel.reto5.model.dao.ComprasDeLiderDao;
import miguel.reto5.model.dao.DeudasPorProyectoDao;
import miguel.reto5.model.dao.ProyectoBancoDao;
import miguel.reto5.model.vo.ComprasDeLiderVo;
import miguel.reto5.model.vo.DeudasPorProyectoVo;
import miguel.reto5.model.vo.ProyectoBancoVo;

/**
 *
 * @author usuario
 */
public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    private ComprasDeLiderDao comprasDeLiderDao;
    private DeudasPorProyectoDao pagadoPorProyectoDao;

    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
        pagadoPorProyectoDao = new DeudasPorProyectoDao();
    }

    public List<ProyectoBancoVo> listarProyectosPorBanco (String banco) {
        return proyectoBancoDao.listar(banco);

    }

    public List<ComprasDeLiderVo> listarLideresQueMasGastan () {
        return comprasDeLiderDao.listar();
    }

    public List<DeudasPorProyectoVo> listarTotalAdeudadoProyectos (Double limite) {
        return pagadoPorProyectoDao.listar(limite);

    }
}
