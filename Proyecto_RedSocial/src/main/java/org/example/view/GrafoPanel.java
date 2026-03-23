package org.example.view;


import org.example.model.Grafo;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrafoPanel extends JPanel {

    private Grafo grafo;
    private Map<Usuario, Point> posiciones = new HashMap<>();
    private Random random = new Random();

    public GrafoPanel(Grafo grafo) {
        this.grafo = grafo;
        setBackground(Color.WHITE);
    }

    private void generarPosiciones() {

        int width = getWidth();
        int height = getHeight();

        // 🔥 FIX: evitar tamaño 0
        if (width == 0 || height == 0) return;

        for (Usuario u : grafo.getRelaciones().keySet()) {

            if (!posiciones.containsKey(u)) {

                int x = 50 + random.nextInt(width - 100);
                int y = 50 + random.nextInt(height - 100);

                posiciones.put(u, new Point(x, y));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (grafo.getRelaciones().isEmpty()) {
            g.setColor(Color.GRAY);
            g.drawString("No hay usuarios en el grafo", 20, 20);
            return;
        }

        generarPosiciones();

        Graphics2D g2 = (Graphics2D) g;

        // 🔗 RELACIONES
        for (Usuario u : grafo.getRelaciones().keySet()) {

            Point p1 = posiciones.get(u);
            if (p1 == null) continue;

            for (Usuario amigo : grafo.getRelaciones().get(u)) {

                Point p2 = posiciones.get(amigo);
                if (p2 == null) continue;

                g2.drawLine(p1.x + 20, p1.y + 20, p2.x + 20, p2.y + 20);
            }
        }

        // 👤 NODOS
        for (Usuario u : grafo.getRelaciones().keySet()) {

            Point p = posiciones.get(u);
            if (p == null) continue;

            Color color = Color.LIGHT_GRAY;

            if (u.getGrupo() != null) {
                color = u.getGrupo().getColor();
            }

            g2.setColor(color);
            g2.fillOval(p.x, p.y, 40, 40);

            g2.setColor(Color.BLACK);
            g2.drawOval(p.x, p.y, 40, 40);

            g2.drawString(u.getUsername(), p.x, p.y - 5);
        }
    }
}