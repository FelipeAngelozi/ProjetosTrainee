import { Pessoa } from "./Pessoa.js";

export class Funcionario extends Pessoa {
    
    _salario;
    _bonificacao = 1;
    _senha;

    constructor (nome, idade, salario) {
        super(nome, idade);
        this._salario = salario;
    }

    get salario() {return this._salario}
    set salario(salario) {this._salario = salario}
    get senha() {return this._senha}
    setSenha(senha) {this._senha = senha}

    autenticar(senha) {
        return this._senha == senha;
    }
}