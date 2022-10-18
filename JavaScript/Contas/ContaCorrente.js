import { Conta } from "./Conta.js";


export class ContaCorrente extends Conta{
    
    static numeroContas = 0;
    
    constructor(saldo, agencia, cliente) {
        super (saldo, agencia, cliente);
        ContaCorrente.numeroContas++;
    }

    sacar(valor) {
        valor = valor * 1.1;
        return super.sacar(valor);
    }

}