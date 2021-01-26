import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CadastroUsuarioComponent} from './components/usuarios/cadastro-usuario/cadastro-usuario.component';
import {LoginComponent} from './components/login/login/login.component';
import {AcoesComponent} from './components/acoes/acoes/acoes.component';
import {CarteiraInvestidorComponent} from './components/carteira/carteira-investidor/carteira-investidor.component';
import {HomeComponent} from './components/home/home/home.component';
import {RendimentoComponent} from './components/rendimento/rendimento/rendimento.component';

let routes: Routes;
routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'cadastro', component: CadastroUsuarioComponent},
  {path: 'login', component: LoginComponent},
  {path: 'acoes', component: AcoesComponent},
  {path: 'carteira', component: CarteiraInvestidorComponent},
  {path: 'rendimento', component: RendimentoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
