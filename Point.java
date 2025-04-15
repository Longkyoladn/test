/**
 * Lớp Point đại diện cho một điểm trong không gian 2 chiều.
 * Lớp này lưu trữ tọa độ X và Y của điểm và.
 * cung cấp các phương thức để truy xuất và tính toán các thuộc tính của điểm.
 */
public class Point {
    // Tọa độ X của điểm
    private double pointX;

    // Tọa độ Y của điểm
    private double pointY;

    /**
     * Constructor khởi tạo một điểm với tọa độ X và Y.
     *
     * @param pointX Tọa độ X của điểm
     * @param pointY Tọa độ Y của điểm
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    /**
     * Lấy giá trị tọa độ X của điểm.
     *
     * @return Tọa độ X của điểm
     */
    public double getPointX() {
        return pointX;
    }

    /**
     * Thiết lập giá trị tọa độ X của điểm.
     *
     * @param pointX Tọa độ X cần thiết lập
     */
    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    /**
     * Lấy giá trị tọa độ Y của điểm.
     *
     * @return Tọa độ Y của điểm
     */
    public double getPointY() {
        return pointY;
    }

    /**
     * Thiết lập giá trị tọa độ Y của điểm.
     *
     * @param pointY Tọa độ Y cần thiết lập
     */
    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * Tính khoảng cách giữa hai điểm trong không gian 2 chiều.
     * Sử dụng công thức Pythagore để tính khoảng cách Euclid giữa hai điểm:
     * d = √((x2 - x1)² + (y2 - y1)²)
     *
     * @param newPoint Điểm thứ hai cần tính khoảng cách
     * @return Khoảng cách giữa điểm hiện tại và điểm mới
     */
    public double distance(Point newPoint) {
        // Tính sự chênh lệch giữa tọa độ X và Y
        double dx = newPoint.getPointX() - pointX;
        double dy = newPoint.getPointY() - pointY;

        // Tính khoảng cách Euclid (Pythagorean distance)
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * ham equal.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Math.abs(pointX - ((Point) o).getPointX()) < 0.001
                && Math.abs(pointY - ((Point) o).getPointY()) < 0.001;
    }

    /**
     * Trả về chuỗi mô tả tọa độ của điểm theo định dạng "(X,Y)".
     *
     * @return Chuỗi mô tả tọa độ của điểm
     */
    public String toString() {
        // Định dạng chuỗi với 2 chữ số sau dấu thập phân cho tọa độ X và Y
        return String.format("(%.1f,%.1f)", pointX, pointY);
    }
}
