
package ud.strategynavigator;

public class BicicletaStrategy implements RouteStrategy{


    @Override
    public int calculateCost(int startX, int startY, int endX, int endY) {
        return (int) ((Math.abs(startX - endX) + Math.abs(startY - endY)) * 0.6);
    }

    @Override
    public String getName() {
        return"Bicicletas";
    }

  
    
}
