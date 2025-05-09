import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class project extends JFrame {
    public project() {
        this.setLayout(null);// khi da khai bao null thi them bat cu thanh phan nao cung phai setBounds

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("animation shapes");
        this.setSize(screenSize.width,screenSize.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(0, 600, (int)screenSize.getWidth(), 2); // x, y, width, height
        this.add(separator);

    }
    public static void main(String[] args) {
        // tao swing
        project exam = new project();
        Layer layer = new Layer();
        //ve hinh cua lop
        // hinh tron
        JButton buttonCircle = new JButton("new circle");
        buttonCircle.setBounds(200,800,150, 100);
        exam.add(buttonCircle);
        buttonCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xc = (int)(Math.random()*500);
                int yc = (int)(Math.random()*500);
                int radius = (int)(Math.random()*100);
                Point pointCircle = new Point(xc, yc);
                Shape Circle = new Circle(pointCircle,radius,"cyan", true);
                layer.addShape(Circle);
                //
            }
        });
        // hinh chu nhat
        JButton buttonRec = new JButton("new Rectangle");
        buttonRec.setBounds(400,800,150, 100);
        exam.add(buttonRec);
        buttonRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = (int)(Math.random()* 100);
                int width = (int)(Math.random()* 100);
                int xc = (int)(Math.random()*1000);
                int yc = (int)(Math.random()*500);
                Point pointRectangle1 = new Point(xc, yc);
                Shape rectangle1 = new Rectangle(pointRectangle1,length,width,"yellow",true);
                layer.addShape(rectangle1);
            }
        });
        // hinh vuong
        JButton buttonSq = new JButton("new square");
        buttonSq.setBounds(600,800,150, 100);
        exam.add(buttonSq);
        buttonSq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = (int)(Math.random()* 100);
                int xc = (int)(Math.random()*1000);
                int yc = (int)(Math.random()*500);
                Point pointSquare = new Point(xc,yc);
                Shape Square = new Rectangle(pointSquare,length,length,"red",true);
                layer.addShape(Square);
            }
        });
        JButton buttonDel = new JButton("delete");
        buttonDel.setBounds(800,800,150,100);
        exam.add(buttonDel);
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layer.removeCircles();
                layer.removeDuplicates();
            }
        });
        layer.setBounds(0, 0, 2000, 600);
        exam.add(buttonRec);
        exam.add(buttonCircle);
        exam.add(buttonSq);
        exam.add(layer);

        // lang nghe khi cua so thay doi kich thuoc
        exam.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                layer.setBounds(0,0, layer.getWidth(), layer.getHeight());
                layer.repaint();
            }
        });

    }
}