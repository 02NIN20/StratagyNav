/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud.strategynavigator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class TransmilenioStrategy implements RouteStrategy{

    @Override
    public int calculateCost(int startX, int startY, int endX, int endY) {
        return (int) ((Math.abs(startX - endX) + Math.abs(startY - endY)) * 0.3);
    }

    @Override
    public String getName() {
        return"TransMilenio";
    }
    
}
