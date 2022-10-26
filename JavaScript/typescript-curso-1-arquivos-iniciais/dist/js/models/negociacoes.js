export class Negociacoes {
    constructor() {
        this.negociacoes = []; // ou Negociacao[]
    }
    adiciona(negociacao) {
        this.negociacoes.push(negociacao);
    }
    lista() {
        return [...this.negociacoes];
    }
}
