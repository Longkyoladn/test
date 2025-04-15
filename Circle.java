import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Lớp Circle kế thừa từ lớp Shape, đại diện cho hình tròn.
 * Lớp này mô tả một hình tròn với các thuộc tính như bán kính và vị trí trung tâm,
 * cũng như các phương thức tính toán diện tích, chu vi và so sánh.
 */
public class Circle extends Shape {
    // Bán kính của hình tròn
    protected double radius;
    protected double velocityx = 4;
    protected double velocityy = 5;

    // Trung tâm của hình tròn, lưu trữ tọa độ
    protected Point center;

    /**
     * Constructor không tham số, khởi tạo bán kính mặc định là 0.
     * Mặc định, hình tròn không có màu sắc và không tô màu.
     */
    public Circle() {
        this.radius = 0;
    }

    /**
     * Constructor khởi tạo với tham số bán kính.
     * Màu sắc và trạng thái tô màu sẽ được khởi tạo theo giá trị mặc định trong lớp cha.
     *
     * @param radius Bán kính của hình tròn
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor khởi tạo với tham số bán kính, màu sắc và trạng thái tô màu.
     * Chấp nhận các tham số để thiết lập bán kính, màu sắc và trạng thái tô màu của hình tròn.
     *
     * @param radius Bán kính của hình tròn
     * @param color  Màu sắc của hình tròn
     * @param filled Trạng thái tô màu (true: có tô màu, false: không tô màu)
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);  // Gọi constructor của lớp cha (Shape)
        this.radius = radius;
    }

    /**
     * Constructor khởi tạo với tham số trung tâm, bán kính, màu sắc và trạng thái tô màu.
     * Cho phép thiết lập tất cả các thuộc tính của hình tròn, bao gồm cả trung tâm.
     *
     * @param center Trung tâm của hình tròn (đối tượng Point)
     * @param radius Bán kính của hình tròn
     * @param color  Màu sắc của hình tròn
     * @param filled Trạng thái tô màu (true: có tô màu, false: không tô màu)
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);  // Gọi constructor của lớp cha (Shape)
        this.radius = radius;
        this.center = center;
    }

    /**
     * Lấy trung tâm của hình tròn.
     *
     * @return Trung tâm của hình tròn (đối tượng Point)
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Thiết lập trung tâm của hình tròn.
     *
     * @param center Trung tâm mới của hình tròn
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Lấy bán kính của hình tròn.
     *
     * @return Bán kính của hình tròn
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Thiết lập bán kính của hình tròn.
     *
     * @param radius Bán kính cần thiết lập
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Tính diện tích của hình tròn.
     * Công thức tính diện tích: π * r², với r là bán kính.
     *
     * @return Diện tích của hình tròn, hoặc 0 nếu bán kính không hợp lệ (<= 0)
     */
    @Override
    public double getArea() {
        if (radius <= 0) {
            return 0;
        }
        return Math.PI * radius * radius;
    }

    /**
     * Tính chu vi của hình tròn.
     * Công thức tính chu vi: 2 * π * r, với r là bán kính.
     *
     * @return Chu vi của hình tròn, hoặc 0 nếu bán kính không hợp lệ (<= 0)
     */
    @Override
    public double getPerimeter() {
        if (radius <= 0) {
            return 0;
        }
        return 2 * Math.PI * radius;
    }

    /**
     * Trả về chuỗi biểu diễn thông tin của hình tròn.
     * Chuỗi này bao gồm các thông tin về bán kính, màu sắc và trạng thái tô màu.
     *
     * @return Chuỗi chứa thông tin về bán kính, màu sắc và trạng thái tô màu
     */
    @Override
    public String toString() {
        return String.format("Circle[center=%s,radius=%.1f,color=%s,filled=%b]",
                center.toString(), radius, color, filled);
    }

    /**
     * So sánh hai đối tượng Circle xem chúng có bằng nhau hay không.
     * Hai đối tượng Circle được coi là bằng nhau nếu bán kính và trung tâm của chúng giống nhau,
     * với độ chính xác sai số nhỏ hơn 0.001 đối với bán kính.
     *
     * @param o Đối tượng cần so sánh
     * @return true nếu hai hình tròn có bán kính và trung tâm giống nhau, false nếu không
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) { // Kiểm tra kiểu đối tượng
            return false;
        }
        if (this == o) {
            return true;
        }
        // So sánh bán kính và trung tâm với độ chính xác sai số nhỏ hơn 0.001
        return Math.abs(radius - ((Circle) o).getRadius()) < 0.001
                && center.equals(((Circle) o).getCenter()); // So sánh trung tâm bằng equals()
    }

    /**
     * af.
     */
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public void move(ActionEvent e) {
        if(center == null) return;

        center.setPointX(center.getPointX() + velocityx);
        center.setPointY(center.getPointY() + velocityy);

        double x = center.getPointX();
        double y = center.getPointY();

        if (x <= 0) {
            velocityx = -velocityx;
        }

        if (x + radius >= 2000) {
            velocityx = - velocityx;
        }

        if (y <= 0) {
            velocityy = -velocityy;
        }

        if (y + radius >= 600) {
            velocityy = -velocityy;
        }


    }

    public void draw(Graphics g) {
        if(center == null) return ;
        Graphics2D g2d = (Graphics2D) g;

        int x = (int)(center.getPointX() - radius);
        int y = (int)(center.getPointY() - radius);
        int diameter = (int)(radius*2);


        g2d.setColor(super.getColorFromName(this.getColor()));
        g2d.fillOval(x, y, diameter, diameter);

    }
}
