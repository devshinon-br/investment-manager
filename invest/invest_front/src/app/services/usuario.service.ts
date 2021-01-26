import { Injectable } from '@angular/core';
import {Usuario} from '../models/usuario.models';

@Injectable({
  providedIn: 'root'
})

export class UsuarioService {

  private usuarioLogado: Usuario;
  usuarios: Usuario[] = [
    new Usuario('Keyla Rezende', '123', new Date(), 'rezendekeyla126@gmail.com')
  ];

  constructor() { }

  adicionarUsuario(usuario: Usuario): void{
    this.usuarios.push(usuario);
  }

  realizarLogin(email: string, senha: string): boolean{
    const usuarioValido = this.usuarios.find(usuario => usuario.email === email && usuario.senha === senha);
    if (usuarioValido){
      this.usuarioLogado = usuarioValido;

    }
    return usuarioValido !== undefined;
  }

  getNomeUsuarioLogado(): string{
    return this.usuarioLogado.nome;
  }

  existeUsuarioAutenticado(): boolean{
    return this.usuarioLogado !== undefined;
  }

  realizarLogout(): void{
    this.usuarioLogado = undefined;
  }
}
