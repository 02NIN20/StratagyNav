/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ud.strategynavigator;



/**
 *
 * @author USUARIO
 */
interface RouteStrategy {
    String getName();
    int calculateCost(int startX, int startY, int endX, int endY);
}