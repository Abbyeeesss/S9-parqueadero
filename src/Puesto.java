/**
 * Esta clase representa un puesto en el parqueadero.
 */
public class Puesto {
private Carro carro;
private int numeroPuesto;

public Puesto(int pPuesto) {
    carro = null;
    numeroPuesto = pPuesto;
}

public Carro darCarro() {
    return carro;
}

public int darNumeroPuesto() {
    return numeroPuesto;
}

public boolean estaOcupado() {
    return carro != null;
}

public boolean tieneCarroConPlaca(String pPlaca) {
    return carro != null && carro.tienePlaca(pPlaca);
}

public void parquearCarro(Carro pCarro) {
    carro = pCarro;
}

public void sacarCarro() {
    carro = null;
}
}