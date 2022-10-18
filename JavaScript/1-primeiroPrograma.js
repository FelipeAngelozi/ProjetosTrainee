import {Cliente} from "./Pessoa/Cliente.js"
import {ContaCorrente} from "./Contas/ContaCorrente.js"

const cliente1 = new Cliente("alex", 12);
const contaCorrente = new ContaCorrente(0, 1001, cliente1);

console.log(contaCorrente);
console.log(ContaCorrente.numeroContas);

console.log(contaCorrente.depositar(1000));
console.log(contaCorrente.sacar(500));

