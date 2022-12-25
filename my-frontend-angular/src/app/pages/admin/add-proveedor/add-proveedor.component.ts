import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proveedor } from 'src/app/model/proveedores';
import { ProveedorService } from 'src/app/services/proveedor.service';

@Component({
  selector: 'app-add-proveedor',
  templateUrl: './add-proveedor.component.html',
  styleUrls: ['./add-proveedor.component.css']
})
export class AddProveedorComponent implements OnInit {

  proveedor: Proveedor = new Proveedor();

  constructor(private proveedorService:ProveedorService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  crearProveedor(){
    this.proveedorService.crearProveedor(this.proveedor).subscribe(
      response => {
        console.log("Exito!");
        this.gotoList();
      }, error => console.log(error));
  }

  gotoList(){
    this.router.navigate(['/admin/proveedores']);
  }
}
