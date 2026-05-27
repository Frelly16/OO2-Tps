package ejercicio4;

public class PedidoBuilder {
    private Combo combo;

    public PedidoBuilder(Combo comboBase) {
        this.combo = comboBase;
    }

    public PedidoBuilder agregarTomate() {
        this.combo = new Tomate(this.combo);
        return this;
    }

    public PedidoBuilder agregarQueso() {
        this.combo = new Queso(this.combo);
        return this;
    }

    public PedidoBuilder agregarCarne() {
        this.combo = new Carne(this.combo);
        return this;
    }

    public PedidoBuilder agregarPapas() {
        this.combo = new Papas(this.combo);
        return this;
    }

    public Combo finalizarPedido() {
        return this.combo;
    }
}