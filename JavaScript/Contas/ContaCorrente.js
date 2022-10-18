import { Conta } from "./Conta.js";


export class ContaCorrente extends Conta{
    
    static numeroContas = 0;
    _taxa = 1.1;
    
    constructor(saldo, agencia, cliente) {
        super (saldo, agencia, cliente);
        ContaCorrente.numeroContas++;
    }

    sacar(valor) {
        return super._sacar(valor, this._taxa);
    }

}