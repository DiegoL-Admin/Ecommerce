package org.ecommerce;

public class SistemConfig {

    private static SistemConfig instancia;

    // Ejemplo de configuraciones
    private String urlBaseDatos;
    private String temaUI;
    private boolean modoDebug;

    // 🔒 Constructor privado
    private SistemConfig() {
        this.urlBaseDatos = "jdbc:mysql://localhost:3306/ecommerce";
        this.temaUI = "modo-claro";
        this.modoDebug = false;
    }

    public static SistemConfig getInstancia() {
        if (instancia == null) {
            instancia = new SistemConfig();
        }
        return instancia;
    }

    // Getters y Setters
    public String getUrlBaseDatos() { return urlBaseDatos; }
    public void setUrlBaseDatos(String urlBaseDatos) { this.urlBaseDatos = urlBaseDatos; }

    public String getTemaUI() { return temaUI; }
    public void setTemaUI(String temaUI) { this.temaUI = temaUI; }

    public boolean isModoDebug() { return modoDebug; }
    public void setModoDebug(boolean modoDebug) { this.modoDebug = modoDebug; }

    @Override
    public String toString() {
        return "ConfiguracionSistema{" +
                "urlBaseDatos='" + urlBaseDatos + '\'' +
                ", temaUI='" + temaUI + '\'' +
                ", modoDebug=" + modoDebug +
                '}';
    }
}
