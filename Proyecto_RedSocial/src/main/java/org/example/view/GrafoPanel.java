package org.example.view;

import org.example.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrafoPanel extends JPanel {

    private Grafo grafo;
    private Map<Usuario, Point> posiciones = new HashMap<>();

    public GrafoPanel(Grafo grafo) {
        this.grafo = grafo;
        generarPosiciones();
    }

    private void generarPosiciones() {
        Random r = new Random();

        for (Usuario u : grafo.getRelaciones().keySet()) {
            posiciones.put(u, new Point(r.nextInt(600), r.nextInt(400)));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar relaciones (líneas)
        for (Usuario u : grafo.getRelaciones().keySet()) {
            Point p1 = posiciones.get(u);

            for (Usuario amigo : grafo.getRelaciones().get(u)) {
                Point p2 = posiciones.get(amigo);

                g.setColor(Color.BLACK);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        // Dibujar nodos (usuarios)
        for (Usuario u : grafo.getRelaciones().keySet()) {
            Point p = posiciones.get(u);

            Color color = Color.GRAY;

            if (u.getGrupo() != null) {
                color = u.getGrupo().getColor();
            }

            g.setColor(color);
            g.fillOval(p.x, p.y, 40, 40);

            g.setColor(Color.BLACK);
            g.drawString(u.getUsername(), p.x, p.y);
        }
    }
}