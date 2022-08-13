/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miguel.reto5.view;

import java.util.List;
import miguel.reto5.controller.ReportesController;
import miguel.reto5.model.vo.ComprasDeLiderVo;
import miguel.reto5.model.vo.DeudasPorProyectoVo;
import miguel.reto5.model.vo.ProyectoBancoVo;

/**
 *
 * @author usuario
 */
public class ReportesView {
    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD",
                    "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            ReportesController reportesController = new ReportesController();
            List<ProyectoBancoVo> respuesta = reportesController.listarProyectosPorBanco(banco);
            for (ProyectoBancoVo proyecto : respuesta) {
                //System.out.println(String.format("%3d %-25s %-20s %-15s %7d %-30s", 
                System.out.println(String.format("%3s %-25s %-20s %-15s %7s %-30s", 
                        proyecto.getId() , proyecto.getConstructora(), proyecto.getCiudad(), 
                        proyecto.getClasificacion(), proyecto.getEstrato(), proyecto.getLider() ));
                
            }
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            ReportesController reportesController = new ReportesController();
            List<DeudasPorProyectoVo> respuesta = reportesController.listarTotalAdeudadoProyectos(limiteInferior);
            for (DeudasPorProyectoVo deuda : respuesta) {
                //System.out.println(String.format("%3d %,15.1f", 
                System.out.println(String.format("%3d %,15.1f", 
                        deuda.getId(), deuda.getValor()));
                
            }
        }
    }

    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        ReportesController reportesController = new ReportesController();
        List<ComprasDeLiderVo> respuesta = reportesController.listarLideresQueMasGastan();
        for (ComprasDeLiderVo compra : respuesta) {
            //System.out.println(String.format("%-25s %,15.1f", compra.getLider(), compra.getValor()));
            System.out.println(String.format("%-25s %,15.1f", compra.getLider(), compra.getValor()));
        }
    }
}
