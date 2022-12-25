import  Swal  from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/model/categoria';
import { Proveedor } from 'src/app/model/proveedores';
import { Producto } from 'src/app/model/producto';
import { ProductoService } from 'src/app/services/producto.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-producto',
  templateUrl: './add-producto.component.html',
  styleUrls: ['./add-producto.component.css']
})
export class AddProductoComponent implements OnInit {

  producto: Producto = new Producto();

  categorias: Categoria [] = [];

  proveedores: Proveedor [] = [];

  constructor(private productoService:ProductoService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.productoService.listarCategorias().subscribe(
      (data:any) => {
        this.categorias = data;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al cargar las categorias')
      }
    )

    this.productoService.listarProveedores().subscribe(
      (data:any) => {
        this.proveedores = data;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al cargar los proveedores')
      }
    )

  }

  crearProducto(){
    this.productoService.crearProducto(this.producto).subscribe(
      response => {
      console.log("Exito!");
      this.gotoList();
    }, error => console.log(error));
}

gotoList(){
  this.router.navigate(['/admin/productos']);
}
}