import { Funcionario } from "./Funcionario.js";

export class Diretor extends Funcionario {

    constructor(nome, idade, salario) {
        super(nome, idade, salario);
        this._bonificacao = 2;
    }

}