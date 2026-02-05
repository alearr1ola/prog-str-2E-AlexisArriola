package src;

public class ShippingCalculator {
    /**
     * Calcula el subtotal del envío según peso, distancia, tipo de servicio y zona remota.
     * @param peso         Peso del paquete en kg
     * @param distancia    Distancia en km
     * @param tipoServicio 1=Estándar, 2=Express
     * @param zonaRemota   true si es zona remota, false si no
     * @return Subtotal calculado antes de IVA
     */
    public double calcularSubtotal(double peso, int distancia, int tipoServicio, boolean zonaRemota) {
        double subtotal = 0;
        if (tipoServicio == 1) {
            subtotal += 50;
        } else {
            subtotal += 90;
        }
        subtotal += peso * 12;
        if (distancia <= 50) {
            subtotal += 20;
        } else if (distancia <= 200) {
            subtotal += 60;
        } else {
            subtotal += 120;
            if (zonaRemota) {
                subtotal *= 1.10;
            }

        }
        return subtotal;
    }
    /**
     * Calcula el IVA del subtota
     * @param subtotal Valor antes de impuestos
     * @return IVA calculado (16%)
     */
    public double calcularIVA ( double subtotal){
        return subtotal * 0.16;
    }
    /**
     * Calcula el total sumando subtotal y IVA
     * @param subtotal Valor antes de impuestos
     * @param iva IVA calculado
     * @return Total final a pagar
     */
    public double calcularTotal ( double subtotal, double iva){
        return subtotal + iva;
    }
}
