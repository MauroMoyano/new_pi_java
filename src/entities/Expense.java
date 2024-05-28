package entities;

import java.util.Date;

public interface Expense {
    public String obtenerMonto();
    public Date obtenerFecha();
    public String obtenerCategoria();
    public String obtenerTotalCategoria();
    public String obtenerDescipcion();
}
