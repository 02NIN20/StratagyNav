
package ud.strategynavigator;

interface RouteStrategy {
    String getName();
    int calculateCost(int startX, int startY, int endX, int endY);
}
