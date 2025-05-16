
package ud.strategynavigator;

import java.awt.Point;

public class Navigator {
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy strategy) {
        this.routeStrategy = strategy;
    }

    public String buildRoute(Point start, Point end) {
        if (routeStrategy == null) {
            return "No hay una estrategia definida.";
        }
        int cost = routeStrategy.calculateCost(start.x, start.y, end.x, end.y);
        return "Tiempo estimado: " + cost + " min usando " + routeStrategy.getName();
    }
}

