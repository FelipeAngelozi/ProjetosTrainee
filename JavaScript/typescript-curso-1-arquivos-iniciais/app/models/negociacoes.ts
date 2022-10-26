import { Negociacao } from "./negociacao.js";

export class Negociacoes {
    private negociacoes : Array<Negociacao>= [];  // ou Negociacao[]

    adiciona(negociacao : Negociacao) {
        this.negociacoes.push(negociacao)
    }

    lista() : ReadonlyArray<Negociacao> { // ou readonly Negociacao[]
        return [...this.negociacoes];
    }
}

