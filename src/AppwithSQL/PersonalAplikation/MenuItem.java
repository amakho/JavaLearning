package AppwithSQL.PersonalAplikation;


record MenuItem(String name, double price, boolean isDeliveryAvailable) {

    @Override
    public String toString() {
        String deliveryInfo = isDeliveryAvailable ? "(Delivery)" : "(Only inside)";
        return String.format("%-25s | %6.2f PLN | %s", name, price, deliveryInfo);
    }
}
