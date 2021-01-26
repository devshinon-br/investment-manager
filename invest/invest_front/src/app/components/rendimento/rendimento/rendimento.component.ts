import {AfterViewInit, Component, OnInit, QueryList, ViewChild, ViewChildren} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {DatePipe, formatDate} from '@angular/common';

@Component({
  selector: 'app-rendimento',
  templateUrl: './rendimento.component.html',
  styleUrls: ['./rendimento.component.css']
})
export class RendimentoComponent implements OnInit, AfterViewInit {

  constructor(private http: HttpClient) { }

  formDatasFiltro: FormGroup;
  dataInicioFormControl = new FormControl();
  dataFimFormControl = new FormControl();

  displayedColumnsInfo: string[] = ['instrumentInfo', 'quantidadeInfo'];
  displayedColumnsRend: string[] = ['quantidade', 'valor_total_acoes', 'rendimento_dinheiro', 'rendimento_porcentagem', 'data'];

  dataSourceRend: any;
  dataSourceInfo: any;

  urlRend = 'http://localhost:8080/rendimento';
  total = 0;

  @ViewChildren(MatPaginator) paginator = new QueryList();

  ngOnInit(): void {
    this.formDatasFiltro = new FormGroup({
      dataInicio : this.dataInicioFormControl,
      dataFim    : this.dataFimFormControl
    });
  }
  ngAfterViewInit(): void{
    this.exibirInfo();
    this.exibirRend();
  }

  exibirInfo(): void{
    ListaInfo = [];
    this.http.get('http://localhost:8080/acoesTotal').subscribe( (infos) => {
        infos.forEach( info => {
          let auxInfo = {} as Informacao;
          this.total += info[1];
          auxInfo.instrumentInfo = info[0];
          auxInfo.quantidadeInfo = info[1];
          ListaInfo.push(auxInfo);
        });
      },
      msg => {
        console.log('Erro: ' + msg);
      },
      () => {
        this.dataSourceInfo = new MatTableDataSource<Informacao>(ListaInfo);
        this.dataSourceInfo.paginator = this.paginator.toArray()[1];
        console.log('Complete Info');
      });
  }

  exibirRend(): void{
    ListaRend = [];
    this.http.get(this.urlRend).subscribe( (rends) => {
        rends.forEach( rend => {
          let aux = {} as Rendimento;
          aux.quantidade = rend[0].toFixed(0);
          aux.valor_total_acoes = rend[1].toFixed(2);
          aux.rendimento_dinheiro = rend[2].toFixed(2);
          aux.rendimento_porcentagem = rend[3].toFixed(2);
          aux.data = rend[4];
          ListaRend.push(aux);
        });
      },
      msg => {
        console.log('Erro: ' + msg);
      },
      () => {
        this.dataSourceRend = new MatTableDataSource<Rendimento>(ListaRend);
        this.dataSourceRend.paginator = this.paginator.toArray()[0];
        console.log('Complete');
      });
  }

  filtrar(): void{
    this.urlRend = 'http://localhost:8080/rendimento';
    let pipe = new DatePipe('en-US');

    let dataInicioFormatada = pipe.transform(this.dataInicioFormControl.value, 'yyyy/MM/dd');
    let dataFimFormatada = pipe.transform(this.dataFimFormControl.value, 'yyyy/MM/dd');

    if (dataInicioFormatada === null && dataFimFormatada !== null) {
      this.urlRend += '?dataFim=' + dataFimFormatada;
    }
    else if (dataInicioFormatada !== null && dataFimFormatada === null) {
      this.urlRend += '?dataInicio=' + dataInicioFormatada;
    }
    else if (dataInicioFormatada !== null && dataFimFormatada !== null) {
      this.urlRend += '?dataInicio=' + dataInicioFormatada + '&' + 'dataFim=' + dataFimFormatada;
    }
    this.exibirRend();
    console.log(this.urlRend);
  }
}

let ListaInfo: Informacao[] = [];
let ListaRend: Rendimento[] = [];

export interface Rendimento{
  quantidade: number;
  valor_total_acoes: number;
  rendimento_dinheiro: number;
  rendimento_porcentagem: number;
  data: Date;
}

export interface Informacao{
  instrumentInfo: string;
  quantidadeInfo: number;
}
