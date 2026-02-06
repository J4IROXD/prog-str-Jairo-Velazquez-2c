public class ShippingCalculator {
    public ShippingCalculator() {
    }

    private final double IVA = 0.16;
    private final double PRECIO_EXPRES = 90;
    private final double PRECIO_ESTANDAR = 50;

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota) {
        double totalParcial = 0;
        if (tipoServicio == 1) totalParcial = PRECIO_ESTANDAR;
        else totalParcial = PRECIO_EXPRES;
        totalParcial += (pesoKg * 12);
        if (distanciaKm <= 50) {
            totalParcial += 20;
        } else if (distanciaKm <= 200) {
            totalParcial += 60;
        } else {
            totalParcial += 120;
        }
        if (esZonaRemota) {
            totalParcial *= 1.10;
        }
        return totalParcial;
    }
    public double calcularIVA(double subtotal) {
        return subtotal * IVA;
    }

    public double calcularTotal(double subtotal, double iva){
        return subtotal + iva;
    }
}

