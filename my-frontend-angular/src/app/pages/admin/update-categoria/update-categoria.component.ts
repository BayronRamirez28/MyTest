import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/model/categoria';
import { CategoriaService } from 'src/app/services/categoria.service';

@Component({
  selector: 'app-update-categoria',
  templateUrl: './update-categoria.component.html',
  styleUrls: ['./update-categoria.component.css']
})
export class UpdateCategoriaComponent implements OnInit {

  categoria: Categoria = {
    id: 0,
    name: ''
  }

  constructor(private categoriaService: CategoriaService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getCategoria(this.activatedRoute.snapshot.params['id']);
  }

  getCategoria(id: number): void{
    this.categoriaService.findId(id)
    .subscribe((data) => {
      console.log(data)
      this.categoria = data;
    }, (error) => {
      console.log(error);
    }
    )
  }

  updateCategoria(): void{
    this.categoriaService.actualizarCategoria(this.categoria.id, this.categoria)
    .subscribe((data) => {
      console.log(data);
      this.categoria = new Categoria();
      this.gotoList();
    }, error => console.log(error));
  }

  onSubmit(){
    this.updateCategoria();
  }

  gotoList(){
    this.router.navigate(['/admin/categorias']);
  }
}
