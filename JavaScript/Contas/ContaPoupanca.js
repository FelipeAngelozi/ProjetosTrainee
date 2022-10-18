import { Conta } from "./Conta.js";

export class ContaPoupanca extends Conta {

    static numeroContas = 0;
    
    constructor(saldo, agencia, cliente) {
        super(saldo, agencia, cliente);
        ContaCorrente.numeroContas++;
    }
 
}