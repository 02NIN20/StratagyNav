package ud.strategynavigator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.*;

public class main {
    private static final int SIZE = 10;
    private static JButton[][] grid = new JButton[SIZE][SIZE];
    private static final Point[] POIS = {
        new Point(2, 2), // Biblioteca
        new Point(4, 7), // Centro Comercial
        new Point(8, 3)  // Parque
    };
    private static final String[] POI_NAMES = {"Biblioteca", "Centro Comercial", "Parque"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Navegador de Ciudad");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 800);
            frame.setLayout(new BorderLayout());

            JPanel mapPanel = new JPanel(new GridLayout(SIZE, SIZE));

            for (int y = 0; y < SIZE; y++) {
                for (int x = 0; x < SIZE; x++) {
                    JButton cell = new JButton();
                    cell.setBackground(Color.WHITE);
                    cell.setOpaque(true);
                    cell.setEnabled(false);
                    grid[y][x] = cell;
                    mapPanel.add(cell);
                }
            }

            // Marcamos los POIs
            for (int i = 0; i < POIS.length; i++) {
                Point p = POIS[i];
                grid[p.y][p.x].setBackground(Color.CYAN);
                grid[p.y][p.x].setText(POI_NAMES[i]);
            }

            JPanel controlPanel = new JPanel();
            controlPanel.setLayout(new GridLayout(6, 2));

            JTextField startX = new JTextField("0");
            JTextField startY = new JTextField("0");
            JComboBox<String> destinationBox = new JComboBox<>(POI_NAMES);
            JComboBox<String> strategyBox = new JComboBox<>(new String[]{"Caminar", "Bicicleta", "TransMilenio"});
            JButton routeButton = new JButton("Calcular Ruta");
            JLabel resultLabel = new JLabel("Resultado:");

            controlPanel.add(new JLabel("Posición X de inicio:"));
            controlPanel.add(startX);
            controlPanel.add(new JLabel("Posición Y de inicio:"));
            controlPanel.add(startY);
            controlPanel.add(new JLabel("Destino:"));
            controlPanel.add(destinationBox);
            controlPanel.add(new JLabel("Modo de transporte:"));
            controlPanel.add(strategyBox);
            controlPanel.add(routeButton);
            controlPanel.add(resultLabel);

            routeButton.addActionListener(e -> {
                int x = Integer.parseInt(startX.getText())-1;
                int y = Integer.parseInt(startY.getText())-1;
                int destIndex = destinationBox.getSelectedIndex();
                Point dest = POIS[destIndex];

                RouteStrategy strategy;
                switch (strategyBox.getSelectedItem().toString()) {
                    case "Bicicleta":
                        strategy = new BicicletaStrategy();
                        break;
                    case "TransMilenio":
                        strategy = new TransmilenioStrategy();
                        break;
                    default:
                        strategy = new CaminarStrategy();
                        break;
                }

                highlightRoute(x, y, dest.x, dest.y);
                int cost = strategy.calculateCost(x, y, dest.x, dest.y);
                resultLabel.setText("Tiempo estimado: " + cost + " min usando " + strategy.getName());
            });

            frame.add(mapPanel, BorderLayout.CENTER);
            frame.add(controlPanel, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }

    // Ruta simple: resaltamos de origen a destino en L
    private static void highlightRoute(int sx, int sy, int ex, int ey) {
        // Limpiar
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (grid[y][x].getBackground() != Color.CYAN)
                    grid[y][x].setBackground(Color.WHITE);
            }
        }

        int x = sx, y = sy;
        while (x != ex) {
            grid[y][x].setBackground(Color.YELLOW);
            x += (ex > x) ? 1 : -1;
        }
        while (y != ey) {
            grid[y][x].setBackground(Color.YELLOW);
            y += (ey > y) ? 1 : -1;
        }
        grid[ey][ex].setBackground(Color.ORANGE); // destino
    }
}
