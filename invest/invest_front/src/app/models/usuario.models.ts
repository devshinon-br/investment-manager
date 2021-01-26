export class Usuario{
  nome: string;
  senha: string;
  dataNascimento: Date;
  email: string;

  constructor(nome: string, senha: string, dataNascimento: Date, email: string) {
    this.nome = nome;
    this.senha = senha;
    this.dataNascimento = dataNascimento;
    this.email = email;
  }
}


