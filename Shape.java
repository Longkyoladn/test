import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

/**
 * Lớp trừu tượng Shape đại diện cho một hình học cơ bản.
 * Các lớp con phải triển khai các phương thức tính diện tích và chu vi.
 */
public abstract class Shape {
    // Thuộc tính màu sắc của hình
    protected String color;
    // Thuộc tính cho biết hình có được tô màu hay không
    protected boolean filled;

    /**
     * Constructor không tham số, khởi tạo giá trị mặc định.
     */
    public Shape() {
        this.color = null;
        this.filled = false;
    }

    /**
     * Constructor khởi tạo với tham số màu sắc và trạng thái tô màu.
     *
     * @param color  Màu sắc của hình
     * @param filled Trạng thái tô màu (true: có tô màu, false: không tô màu)
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Constructor khởi tạo với tham số trạng thái tô màu.
     *
     * @param filled Trạng thái tô màu (true: có tô màu, false: không tô màu)
     */
    public Shape(boolean filled) {
        this.filled = filled;
    }

    /**
     * Lấy màu sắc của hình.
     *
     * @return Màu sắc của hình
     */
    public String getColor() {
        return color;
    }

    /**
     * Thiết lập màu sắc của hình.
     *
     * @param color Màu sắc cần thiết lập
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Kiểm tra xem hình có được tô màu không.
     *
     * @return true nếu hình được tô màu, ngược lại false
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Thiết lập trạng thái tô màu của hình.
     *
     * @param filled Giá trị trạng thái tô màu cần thiết lập
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Phương thức trừu tượng để tính diện tích của hình.
     * Các lớp con bắt buộc phải triển khai phương thức này.
     *
     * @return Diện tích của hình
     */
    public abstract double getArea();

    /**
     * Phương thức trừu tượng để tính chu vi của hình.
     * Các lớp con bắt buộc phải triển khai phương thức này.
     *
     * @return Chu vi của hình
     */
    public abstract double getPerimeter();

    /**
     * Phương thức trả về chuỗi biểu diễn thông tin của hình.
     *
     * @return Chuỗi chứa thông tin màu sắc và trạng thái tô màu
     */
    @Override
    public String toString() {
        return "color=" + color + ",filled=" + filled;
    }

    public abstract void draw(Graphics g);
    public abstract  void move(ActionEvent e);

    public Color getColorFromName(String color) {
        try {
            Field field = Color.class.getField(color.toUpperCase());
            return (Color) field.get(null);
        } catch (Exception e) {
            return Color.black;
        }
    }

}
