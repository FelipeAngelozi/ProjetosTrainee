import { Pessoa } from "./Pessoa.js";

export class Cliente extends Pessoa{

    _senha;

    constructor(nome, idade) {
        return super(nome, idade);
    }

    autenticar(senha) {
        return this._senha == senha;
    }
    
}