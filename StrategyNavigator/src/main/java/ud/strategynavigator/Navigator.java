/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud.strategynavigator;

/**
 *
 * @author USUARIO
 */
public class Navigator {
    private RouteStrategy routestrategy;
    
    public void setRouteStrategy(RouteStrategy routestrategy){
    
        this.routestrategy = routestrategy; 
    
    }
    
    public void buildRoute(String A, String B){
    
        if(routestrategy == null){
            System.out.println("No se ha definido una estrategia de ruta aún. ");
            return;
            
        }
        routestrategy.buildRoute(A, B);
        
    }
}
