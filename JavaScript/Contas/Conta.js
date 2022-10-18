import { Cliente } from "../Pessoa/Cliente.js";

export class Conta {
    _agencia;
    _saldo;
    _cliente;

    constructor(saldo, agencia, cliente) {
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    get agencia() {return this._agencia}
    set agencia(agencia) {this._agencia = agencia}

    get saldo() {return this._saldo}
    set saldo(saldo) {this._saldo = saldo}

    get cliente() {return this._cliente}
    set cliente(cliente) {if (cliente instanceof Cliente) {this._cliente = cliente}}

    depositar(valor) {
        if(valor <= 0) return;
        this._saldo += valor;
        return this._saldo;
    }

    sacar(valor) {
        if (valor > this._saldo) return;
        this._saldo -= valor;
        return this._saldo;
    }

    tranferir(valor, conta) {
        let valorSacado = this.sacar(valor);
        conta.depositar(valorSacado);
        return "Transferencia realizada com sucesso."
    }
}