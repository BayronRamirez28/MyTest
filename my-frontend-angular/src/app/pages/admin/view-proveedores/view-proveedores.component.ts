import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Proveedor } from 'src/app/model/proveedores';
import { ProveedorService } from 'src/app/services/proveedor.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-proveedores',
  templateUrl: './view-proveedores.component.html',
  styleUrls: ['./view-proveedores.component.css']
})
export class ViewProveedoresComponent implements OnInit {

  proveedores!: Observable<Proveedor[]>;

  columndefs: any[] = ['id', 'name', 'email', 'telephone', 'editar'];

  constructor(private proveedorService: ProveedorService, private router: Router) { }

  ngOnInit(): void {
    this.getProveedores();
  }

  private getProveedores(){
    this.proveedorService.listarProveedores().subscribe(
      (data:any) => {
        this.proveedores = data;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al cargar los proveedores')
      }
    )
  }

  updateProveedor(id: number){
    this.router.navigate(['/admin/update-proveedor', id]);
  }

}
