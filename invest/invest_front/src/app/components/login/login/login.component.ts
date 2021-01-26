import { Component, OnInit } from '@angular/core';
import {Form, FormControl, FormGroup, Validators} from '@angular/forms';
import {UsuarioService} from '../../../services/usuario.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  esconderSenha = true;
  formularioLogin: FormGroup;
  mensagemErro: string;

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email
  ]);

  senhaFormControl = new FormControl('', [
    Validators.required,
  ]);

  constructor(private usuarioService: UsuarioService,
              private router: Router,
              private activeRouter: ActivatedRoute) {}

  // executado ao rodar a applicacao
  ngOnInit(): void {
    this.formularioLogin = new FormGroup({
      email     : this.emailFormControl,
      senha     : this.senhaFormControl,
    });
  }

  onSubmit(): void{
    this.IsSucces();
    if (this.IsSucces()){
      this.router.navigate(['acoes']);
    }
  }

  IsSucces(): boolean{
    const emailInformado = this.formularioLogin.value.email;
    const senhaInformada = this.formularioLogin.value.senha;

    const loginSucces = this.usuarioService.realizarLogin(emailInformado, senhaInformada);

    if (loginSucces){
      return true;
    }
    else{
      this.mensagemErro = 'Credenciais incorretas!';
      return false;
    }
  }

  onDigit(): void{
    this.mensagemErro = '';
  }
}


