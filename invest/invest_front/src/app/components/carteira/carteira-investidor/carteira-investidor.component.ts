import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-carteira-investidor',
  templateUrl: './carteira-investidor.component.html',
  styleUrls: ['./carteira-investidor.component.css']
})

export class CarteiraInvestidorComponent implements OnInit, AfterViewInit {

  constructor(private http: HttpClient) { }

  displayedColumns: string[] = ['instrument', 'quantidade', 'data', 'tipo_operacao', 'mercado',
    'preco', 'valor_total'];
  dataSource: any;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit(): void {}

  ngAfterViewInit(): void{
    ListaCarteira = [];

    this.http.get('http://localhost:8080/carteiras').subscribe( (carteiras) => {
      carteiras.forEach( carteira => {
        ListaCarteira.push(carteira);
      });
    },
      msg => {
        console.log('Erro: ' + msg);
      },
      () => {
        this.dataSource = new MatTableDataSource<Carteira>(ListaCarteira);
        this.dataSource.paginator = this.paginator;
        console.log('Complete');
      });
  }
}

let ListaCarteira: Carteira[] = [];

export interface Carteira{
  data: Date;
  tipo_operacao: string;
  mercado: string;
  instrument: string;
  quantidade: number;
  preco: number;
  valor_total: number;
  rendimento_porc: number;
  rendimento_moeda: number;
}
