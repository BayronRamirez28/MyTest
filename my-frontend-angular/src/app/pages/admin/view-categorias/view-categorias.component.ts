import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Categoria } from 'src/app/model/categoria';
import { CategoriaService } from 'src/app/services/categoria.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-categorias',
  templateUrl: './view-categorias.component.html',
  styleUrls: ['./view-categorias.component.css']
})
export class ViewCategoriasComponent implements OnInit {

  categorias!: Observable<Categoria[]>;

  columndefs: any[] = ['id', 'name', 'editar'];

  constructor(private categoriaService: CategoriaService, private router: Router) { }

  ngOnInit(): void {
    this.getCategorias();
  }

  private getCategorias(){
    this.categoriaService.listarCategorias().subscribe(
      (data:any) => {
        this.categorias = data;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', 'Error al cargar las categorias')
      }
    )
  }

  updateCategoria(id: number){
    this.router.navigate(['/admin/update-categoria', id]);
  }

}
