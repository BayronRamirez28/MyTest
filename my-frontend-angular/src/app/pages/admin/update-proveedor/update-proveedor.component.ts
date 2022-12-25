import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proveedor } from 'src/app/model/proveedores';
import { ProveedorService } from 'src/app/services/proveedor.service';

@Component({
  selector: 'app-update-proveedor',
  templateUrl: './update-proveedor.component.html',
  styleUrls: ['./update-proveedor.component.css']
})
export class UpdateProveedorComponent implements OnInit {

  proveedor: Proveedor = {
    id: 0,
    name: '',
    email: '',
    telephone: 0
  }

  constructor(private proveedorService: ProveedorService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getProveedor(this.activatedRoute.snapshot.params['id']);
  }

  getProveedor(id: number): void{
    this.proveedorService.findId(id)
    .subscribe((data) => {
      console.log(data)
      this.proveedor = data;
    }, (error) => {
      console.log(error);
    }
    )
  }

  updateProveedor(): void{
    this.proveedorService.actualizarProveedor(this.proveedor.id, this.proveedor)
    .subscribe((data) => {
      console.log(data);
      this.proveedor = new Proveedor();
      this.gotoList();
    }, error => console.log(error));
  }

  onSubmit(){
    this.updateProveedor();
  }

  gotoList(){
    this.router.navigate(['/admin/proveedores']);
  }
}
