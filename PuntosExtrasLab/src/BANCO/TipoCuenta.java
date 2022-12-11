package BANCO;

public enum TipoCuenta {
    NORMAL(0.02,500), VIP(0.04,1000), PLANILLA(0,200);

    private double tasaInteres;
    private double miniSaldo;

    private TipoCuenta(double tasaInteres, double miniSaldo){
        this.tasaInteres = tasaInteres;
        this.miniSaldo = miniSaldo;
    }
    public double getTasa(){
        return tasaInteres;
    }
    public double getMiniSaldo(){
        return miniSaldo;
    }
}