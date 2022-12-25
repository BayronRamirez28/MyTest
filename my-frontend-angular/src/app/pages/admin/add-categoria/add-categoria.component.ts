import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/model/categoria';
import { CategoriaService } from 'src/app/services/categoria.service';

@Component({
  selector: 'app-add-categoria',
  templateUrl: './add-categoria.component.html',
  styleUrls: ['./add-categoria.component.css']
})
export class AddCategoriaComponent implements OnInit {

  categoria: Categoria = new Categoria();

  constructor(private categoriaService:CategoriaService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void { 
  }

  crearCategoria(){
    this.categoriaService.crearCategoria(this.categoria).subscribe(
      response => {
        console.log("Exito!");
        this.gotoList();
      }, error => console.log(error));
  }

  gotoList(){
    this.router.navigate(['/admin/categorias']);
  }

}
