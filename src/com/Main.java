package com;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();

     /*   String[] fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String s :fonts) {
            System.out.println(s);
        }*/
        jFrame.add(new MyComponent());

    }

    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Font font = new Font("Bahnschrift", Font.BOLD, 20);
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(font);
            g2.drawString("Hello World !!!", 20, 30);
            Point2D p1 = new Point2D.Double(70, 70);
            Point2D p2 = new Point2D.Double(170, 170);
            Line2D l2 = new Line2D.Double(p1, p2);
            g2.draw(l2);
            Ellipse2D e2 = new Ellipse2D.Double(70, 70, 170, 170);
            Ellipse2D e3 = new Ellipse2D.Double();
            e3.setFrameFromDiagonal(p1,p2);
            g2.setPaint(Color.RED);
            g2.draw(e2);
            g2.setPaint(Color.GREEN);
            g2.draw(e3);
            Rectangle2D r2 = new Rectangle2D.Double(70, 70, 170, 170);
            g2.draw(r2);
            try {
                URL url = new URL("https://bit.ly/2P2BUHt");
                Image image = new ImageIcon(url).getImage();
                g2.drawImage(image, 150, 100, null);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Image image = new ImageIcon("img/images.png").getImage();
            g2.drawImage(image, 10, 100, null);
        }
    }


    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 500);
        return jFrame;

    }
}
