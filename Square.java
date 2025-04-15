import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Lớp Square kế thừa từ lớp Rectangle, đại diện cho hình vuông.
 * Vì hình vuông có các cạnh bằng nhau, nên width và length sẽ có cùng giá trị.
 */
public class Square extends Rectangle {

    /**
     * Constructor không tham số, khởi tạo hình vuông với cạnh mặc định là 0.
     */
    public Square() {
        super(0, 0);
    }

    /**
     * Constructor khởi tạo hình vuông với cạnh được chỉ định.
     *
     * @param side Độ dài cạnh của hình vuông
     */
    public Square(double side) {
        super(side, side);
    }

    /**
     * Constructor khởi tạo hình vuông với cạnh, màu sắc và trạng thái tô màu.
     *
     * @param side   Độ dài cạnh của hình vuông
     * @param color  Màu sắc của hình vuông
     * @param filled Trạng thái tô màu (true: có tô màu, false: không tô màu)
     */
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    /**
     *constructor khoi toa hinh vuong voi day du cac trang thai.
     *
     * @param topLeft cua hinh vuong
     * @param side cua hinh vuong
     * @param color cua hinh vuong
     * @param filled cua hinh vuong
     */
    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    /**
     * Lấy độ dài cạnh của hình vuông.
     *
     * @return Độ dài cạnh của hình vuông
     */
    public double getSide() {
        return width;
    }

    /**
     * Thiết lập độ dài cạnh của hình vuông.
     *
     * @param side Độ dài cạnh cần thiết lập
     */
    public void setSide(double side) {
        this.width = side;
        this.length = side; // Đảm bảo chiều dài cũng được cập nhật vì đây là hình vuông
    }

    /**
     * Ghi đè phương thức setLength để đảm bảo tính đồng nhất của hình vuông.
     *
     * @param side Độ dài cạnh cần thiết lập
     */
    @Override
    public void setLength(double side) {
        setSide(side);
    }

    /**
     * Ghi đè phương thức setWidth để đảm bảo tính đồng nhất của hình vuông.
     *
     * @param side Độ dài cạnh cần thiết lập
     */
    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    /**
     * Trả về chuỗi biểu diễn thông tin của hình vuông.
     *
     * @return Chuỗi chứa thông tin về cạnh, màu sắc và trạng thái tô màu
     */
    @Override
    public String toString() {
        return String.format("Square[topLeft=%s,side=%.1f,color=%s,filled=%b]",
                topLeft.toString(), width, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int x = (int)(topLeft.getPointX() - width/2);
        int y = (int)(topLeft.getPointY() - width/2);

        g2d.setColor(super.getColorFromName(this.getColor()));
        g2d.fillRect(x, y,(int) width,(int) width);
    }

    @Override
    public void move(ActionEvent e) {
        super.move(e);
    }

    /**
     * edeg.
     *
     * @param o r
     * return  tt
     * @return rr
     */
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        return Math.abs(width - ((Square) o).width) < 0.001
                && topLeft.equals(((Square) o).getTopLeft());
    }

}
