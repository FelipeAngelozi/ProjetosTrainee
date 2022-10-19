export class SistemasAutenticacao {

    static login(autenticavel, senha) {
        return autenticavel.autenticar(senha);
    }
}