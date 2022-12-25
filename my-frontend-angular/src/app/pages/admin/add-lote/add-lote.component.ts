import { getLocaleDateFormat, getLocaleDateTimeFormat } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Lote } from 'src/app/model/lote';
import { Producto } from 'src/app/model/producto';
import { LoteService } from 'src/app/services/lote.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-add-lote',
  templateUrl: './add-lote.component.html',
  styleUrls: ['./add-lote.component.css']
})

export class AddLoteComponent implements OnInit {

  Date1 : Date = new Date();

  LocalDate : String = new Date().toLocaleDateString();

  lote: Lote = new Lote();

  productos: Producto [] = [];

  constructor(private loteService: LoteService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.loteService.listarProductos().subscribe(
      (data:any) => {
        this.productos = data;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al cargar los productos')
      }
    )
  }

  

  crearLote(){
    this.loteService.crearLote(this.lote).subscribe(
      response => {
        console.log("Exito!");
        this.gotoList();
      }, error => console.log(error));
  }

  gotoList(){
    this.router.navigate(['/admin/lotes']);
  }

  
}

