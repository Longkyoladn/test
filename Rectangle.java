import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Lớp Rectangle kế thừa từ Shape, đại diện cho hình chữ nhật.
 * Cung cấp các phương thức để tính diện tích và chu vi.
 */
public class Rectangle extends Shape {

    // Chiều rộng của hình chữ nhật
    protected double width;
    // Chiều dài của hình chữ nhật
    protected double length;
    // topleft cua hinh chu nhat
    protected Point topLeft;
    // thuoc tinh toc do
    protected double velocityx = 3;
    protected double velocityy = 5;

    /**
     *Constructor khong tham so, khoi tao hinh chu nhat voi chieu dai va chieu rong mac dinh la 0.
     */
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    /**
     * Constructor khởi tạo hình chữ nhật với chiều dài và chiều rộng.
     *
     * @param width  Chiều rộng của hình chữ nhật
     * @param length Chiều dài của hình chữ nhật
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor khởi tạo hình chữ nhật với đầy đủ thuộc tính.
     *
     * @param width  Chiều rộng của hình chữ nhật
     * @param length Chiều dài của hình chữ nhật
     * @param color  Màu sắc của hình chữ nhật
     * @param filled Trạng thái tô màu (true: có tô màu, false: không tô màu)
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * constructor khoi tao hinh chu nhat day du thuoc tinh.
     *
     * @param topLeft g
     * @param width g
     * @param length gg
     * @param color gg
     * @param filled ggsdf
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
        this.topLeft = topLeft;
    }

    /**
     *  lay topleft cua hinh chu nhat.
     *
     * @return topleft
     */
    public Point getTopLeft() {
        return topLeft;
    }

    /**
     * setup gia tri topleft cua hinh chu nhat.
     *
     * @param topLeft jj
     */
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    /**
     * Lấy chiều rộng của hình chữ nhật.
     *
     * @return Chiều rộng của hình chữ nhật
     */
    public double getWidth() {
        return width;
    }

    /**
     * Thiết lập chiều rộng của hình chữ nhật.
     *
     * @param width Chiều rộng cần thiết lập
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Lấy chiều dài của hình chữ nhật.
     *
     * @return Chiều dài của hình chữ nhật
     */
    public double getLength() {
        return length;
    }

    /**
     * Thiết lập chiều dài của hình chữ nhật.
     *
     * @param length Chiều dài cần thiết lập
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Tính diện tích của hình chữ nhật.
     * Công thức: width * length
     *
     * @return Diện tích của hình chữ nhật
     */
    @Override
    public double getArea() {
        return width * length;
    }

    /**
     * Tính chu vi của hình chữ nhật.
     * Công thức: 2 * (width + length)
     *
     * @return Chu vi của hình chữ nhật
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
     * Trả về chuỗi biểu diễn thông tin của hình chữ nhật.
     *
     * @return Chuỗi chứa thông tin về kích thước, màu sắc và trạng thái tô màu
     */
    @Override
    public String toString() {
        return String.format("Rectangle[topLeft=%s,width=%.1f,length=%.1f,color=%s,filled=%b]",
                topLeft.toString(), width, length, color, filled);
    }

    /**
     * ta.
     * @param o r
     * return
     */
    public  boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        Rectangle rectangle = (Rectangle) o;
        return Math.abs(rectangle.width - width) < 0.001
                && Math.abs(length - rectangle.length) < 0.001
                && topLeft.equals(rectangle.getTopLeft()); // == chi nen dung cho cac bien nguyen thuy  cac bien dang object nen dung equals().
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x = (int)(topLeft.getPointX() - width/2);
        int y = (int)(topLeft.getPointY() - length/2);

        g2d.setColor(super.getColorFromName(this.getColor()));
        g2d.fillRect(x, y, (int)width, (int)length);
    }

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    @Override
    public void move(ActionEvent e) {
        topLeft.setPointX(topLeft.getPointX() + velocityx);
        topLeft.setPointY(topLeft.getPointY() + velocityy);

        double x = topLeft.getPointX();
        double y = topLeft.getPointY();

        if (x <= 0) {
            velocityx = -velocityx;
        }

        if (x + length >= 2000) {
            velocityx = - velocityx;
        }

        if (y <= 0) {
            velocityy = -velocityy;
        }

        if (y + width >= 620) {
            velocityy = -velocityy;
        }
    }
}
