import { Component, OnInit } from '@angular/core';
import { ProductoService } from 'src/app/services/producto.service';
import { Producto } from 'src/app/model/producto';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/model/categoria';
import { Proveedor } from 'src/app/model/proveedores';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-producto',
  templateUrl: './update-producto.component.html',
  styleUrls: ['./update-producto.component.css']
})
export class UpdateProductoComponent implements OnInit {

 

  producto: Producto = {
    id: 0,
    name: '',
    quantity: 0,
    sale_price: 0,
    estate: '',
    detail: '',
    minimun_quantity: 0,
    category: new Categoria,
    supplier: new Proveedor
  }

  categorias: Categoria [] = [];

  proveedores: Proveedor [] = [];

  constructor( private productoService: ProductoService, private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.getProducto(this.activatedRoute.snapshot.params['id']);
 
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
  
    getProducto(id: number): void{
      this.productoService.findId(id)
    .subscribe((data) => {
      console.log(data)
      this.producto = data;
    }, (error) => {
      console.log(error);
    }
    )
    }
    

    

  updateProducto(): void{
    this.productoService.actualizarProduct(this.producto.id, this.producto)
    .subscribe((data) => {
      console.log(data);
      this.producto = new Producto();
      this.gotoList();
    }, error => console.log(error));
  }

  onSubmit(){
    this.updateProducto();
  }

  gotoList(){
    this.router.navigate(['/admin/productos']);
  }
 

}
