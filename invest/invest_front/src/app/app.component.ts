import { Component } from '@angular/core';
import { LoginComponent} from './components/login/login/login.component';
import {UsuarioService} from './services/usuario.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'zgInvestFront';

  constructor(private usuarioService: UsuarioService) {}

  nomeUsuarioLogado(): string{
    return this.usuarioService.getNomeUsuarioLogado();
  }

  existeUsuarioAutenticado(): boolean{
    return this.usuarioService.existeUsuarioAutenticado();
  }

  realizarLogout(): void{
    this.usuarioService.realizarLogout();
  }
}
