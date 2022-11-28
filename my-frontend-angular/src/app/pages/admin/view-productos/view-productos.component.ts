import  Swal  from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { ProductoService } from 'src/app/services/producto.service';
import {Producto} from 'src/app/model/producto';

@Component({
  selector: 'app-view-productos',
  templateUrl: './view-productos.component.html',
  styleUrls: ['./view-productos.component.css']
})
export class ViewProductosComponent implements OnInit {

  productos:Producto[]=[];

  columndefs : any[] = ['id','name', 'quantity', 'sale_price', 'estate', 'category', 'supplier', 'borrar', 'editar'];

  constructor(private productoService:ProductoService) { }

  ngOnInit(): void {
    this.getProductos();
  }

  private getProductos(){
    this.productoService.listarProductos().subscribe(
      (data:any) => {
        this.productos = data;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al cargar los productos',)
      }
    )
  }
}
