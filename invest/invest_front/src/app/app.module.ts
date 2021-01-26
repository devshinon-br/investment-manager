import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import {NgxMaskModule} from 'ngx-mask';
import {AngularMaterialModule} from './angular-material.module';
import { CadastroUsuarioComponent } from './components/usuarios/cadastro-usuario/cadastro-usuario.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MAT_DATE_LOCALE} from '@angular/material/core';
import { LoginComponent } from './components/login/login/login.component';
import { CarteiraInvestidorComponent } from './components/carteira/carteira-investidor/carteira-investidor.component';
import { AcoesComponent } from './components/acoes/acoes/acoes.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { HomeComponent } from './components/home/home/home.component';
import { RendimentoComponent } from './components/rendimento/rendimento/rendimento.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroUsuarioComponent,
    LoginComponent,
    CarteiraInvestidorComponent,
    AcoesComponent,
    HomeComponent,
    RendimentoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    FlexLayoutModule,
    NgxMaskModule.forRoot(),
    MatPaginatorModule
  ],
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'pt-BR'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
