public record Order(int orderId, String shoeType, int quantity) {
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", shoeType='" + shoeType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
