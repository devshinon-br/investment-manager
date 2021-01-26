import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AfterViewInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-acoes',
  templateUrl: './acoes.component.html',
  styleUrls: ['./acoes.component.css']
})
export class AcoesComponent implements OnInit, AfterViewInit {

  constructor(private http: HttpClient) { }
  displayedColumns: string[] = ['simbol', 'date', 'price'];
  dataSource: any;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit(): void {
  }
  ngAfterViewInit(): void{
    ListaAcoes = [];

    this.http.get('http://localhost:8080/acoes').subscribe( acoes => {
        acoes.forEach(acao => {
          ListaAcoes.push(acao);
        });
      },
      msg => {
        console.log('Erro: ' + msg);
      },
      () => {
        this.dataSource = new MatTableDataSource<Acao>(ListaAcoes);
        this.dataSource.paginator = this.paginator;
        console.log('Complete');
      });
  }
}

let ListaAcoes: Acao[] = [];

export interface Acao{
  simbol: string;
  price: number;
  date: Date;
}
