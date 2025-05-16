/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud.strategynavigator;

/**
 *
 * @author USUARIO
 */
public class TransmilenioStrategy implements RouteStrategy{

    @Override
    public void buildRoute(String A, String B) {
        System.out.println("Generando ruta para usar transmilenio");
    }
    
}
