import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Layer extends JPanel implements ActionListener {
    private final List<Shape> shapes = new ArrayList<Shape>();

    /**
     * set jpanel r.
     * dau tien : add layer thi ve lan dau tien sau do cu moi chu ky duoc tao ra boi timer thi no lai goi lai 2 ham su kien Action Listener va paintComponent
     */
    public Layer() {
        // thoi gian goi ra ActionListenr   (thoi gian de chuong trinh chay)
        Timer timer = new Timer(10, this);
        timer.start();
    }

    /**
     * Thêm một hình dạng vào danh sách.
     *
     * @param shape Hình dạng cần thêm
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Trả về thông tin của tất cả các hình trong lớp.
     * Mỗi hình sẽ được chuyển thành chuỗi và hiển thị trong một dòng riêng biệt.
     *
     * @return Chuỗi thông tin về tất cả các hình trong lớp
     */
    public String getInfo() {
        StringBuilder result = new StringBuilder("Layer of crazy shapes:");
        for (Shape shape : shapes) {
            result.append("\n").append(shape.toString());
        }
        return result.toString();
    }

    /**
     * Xóa tất cả các hình tròn trong danh sách.
     */
    public void removeCircles() {
        shapes.removeIf(shape -> shape.getClass() == Circle.class);
    }

    /**
     * Xóa các hình giống nhau trong danh sách.
     * Các hình trùng lặp sẽ bị xóa khỏi danh sách, chỉ giữ lại một bản duy nhất.
     */
    public void removeDuplicates() {
        for (int i = 0; i < shapes.size(); i++) {
//            Shape current = shapes.get(i);
//            for (int j = i + 1; j < shapes.size(); j++) {
//                if (current.equals(shapes.get(j))) {
//                    shapes.remove(j);
//                    j--; // Cập nhật lại j vì danh sách đã co lại
//                }
//            }
            shapes.remove(i);
            i--;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Shape shape : shapes) {
            shape.move(e); // ban chat la setup lai vi tri toa do cua hinh va cho ve lai voi thoi gian ngan
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // ve hinh
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

}
