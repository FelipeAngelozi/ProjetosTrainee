import {Cliente} from "./Pessoa/Cliente.js"
import {ContaCorrente} from "./Contas/ContaCorrente.js"

import { Diretor } from "./Pessoa/Diretor.js";
import { SistemasAutenticacao } from "./SistemaAutenticacao.js";

const cliente1 = new Cliente("alex", 12);
const contaCorrente = new ContaCorrente(0, 1001, cliente1);

console.log(contaCorrente);
console.log(ContaCorrente.numeroContas);

console.log(contaCorrente.depositar(1000));
console.log(contaCorrente.sacar(500));

const funcionario = new Diretor("xela", 21, 4000);
console.log(funcionario.nome);
console.log(funcionario.idade);
console.log(funcionario.salario);
funcionario.setSenha("123");

console.log(SistemasAutenticacao.login(funcionario, "123"))

