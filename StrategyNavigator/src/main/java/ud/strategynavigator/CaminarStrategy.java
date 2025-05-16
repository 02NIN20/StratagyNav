
package ud.strategynavigator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class CaminarStrategy implements RouteStrategy{

   @Override
    public int calculateCost(int startX, int startY, int endX, int endY) {
        return (int) ((Math.abs(startX - endX) + Math.abs(startY - endY)));
    }

    @Override
    public String getName() {
        return"Caminar";
    }
    
}
