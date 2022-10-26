export class Negociacao {
 

    constructor(private _data :Date, private _quantidade :number,private _valor :number) {
      
    }

    get data(): Date{
        return this._data;
    }

    set data(data) {
        this._data = data;
    }

    get quantidade(): number {
        return this._quantidade;
    }

    set quantidade(quantidade) {
        this._quantidade = quantidade;
    }

    get valor(): number{
        return this._valor;
    }

    set valor(valor) {
        this._valor = valor;
    }

    get volume() : number {
        return (this._quantidade * this._valor);
    }


}