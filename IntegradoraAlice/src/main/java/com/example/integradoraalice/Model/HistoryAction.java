package com.example.integradoraalice.Model;

public class HistoryAction {

    private String accion;     // LOAN_CREATED, LOAN_RETURNED, RESERVATION_CREATED
    private String detalle;

    public HistoryAction(String accion, String detalle) {
        this.accion = accion;
        this.detalle = detalle;
    }

    public String getAccion() {
        return accion;
    }

    public String getDetalle() {
        return detalle;
    }

    @Override
    public String toString() {
        return accion + " | " + detalle;
    }
}

