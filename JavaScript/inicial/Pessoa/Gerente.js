import { Funcionario } from "./Funcionario.js";

export class Gerente extends Funcionario {

        constructor(nome, idade, salario){
            super(nome, idade, salario);
            this._bonificacao = 2;
        }
    }