import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';
import {Usuario} from '../../../models/usuario.models';
import {UsuarioService} from '../../../services/usuario.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent implements OnInit {
  formularioCadastro: FormGroup;
  esconderSenha            = true;
  esconderConfirmacaoSenha = true;
  dataInicio               = new Date();
  dataMin                  = new Date(1930, 0, 1);
  dataMax                  = new Date(); // mesma funcionalidade que o now()

  nomeFormControl = new FormControl('', [
    Validators.required,
  ]);

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  senhaFormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(8),
  ]);

  confirmarSenhaFormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(8),
  ]);

  dataNascimentoFormControl = new FormControl('', [
    Validators.required,
  ]);

  // Injetando o service
  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    // é executado toda vez que a aplicacao carrega
    this.formularioCadastro = new FormGroup({
      nome          : this.nomeFormControl,
      email         : this.emailFormControl,
      senha         : this.senhaFormControl,
      dataNascimento: this.dataNascimentoFormControl,
      confirmarSenha: this.confirmarSenhaFormControl,
    }, {validators: validarSenhas}); // adicionando validator "personalizado"
  }
  onDigitarSenha(): void{
    if (this.formularioCadastro.hasError('senhasNaoConferem')){
      this.confirmarSenhaFormControl.setErrors([{senhasNaoConferem: true}]);
    }else {
      this.confirmarSenhaFormControl.setErrors(null);
    }
  }

  onSubmit(): void{
    const nome = this.formularioCadastro.value.nome;
    const email = this.formularioCadastro.value.email;
    const senha = this.formularioCadastro.value.senha;
    const dataNascimento = this.formularioCadastro.value.dataNascimento;

    const usuario = new Usuario(nome, senha, dataNascimento, email);
    this.usuarioService.adicionarUsuario(usuario);
    this.formularioCadastro.reset();

    // console.log(this.usuarioService.usuarios.length);
  }
}

export const validarSenhas: ValidatorFn = (formGroup: FormGroup): ValidationErrors | null => {
  if (formGroup.get('senha').value === formGroup.get('confirmarSenha').value){
    return null;
  }else{
    return {senhasNaoConferem: true};
  }
};
