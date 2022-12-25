import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Lote } from 'src/app/model/lote';
import { LoteService } from 'src/app/services/lote.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-lotes',
  templateUrl: './view-lotes.component.html',
  styleUrls: ['./view-lotes.component.css']
})
export class ViewLotesComponent implements OnInit {

  lotes!: Observable<Lote[]>;

  columndefs : any[] = [ 'id', 'quantity', 'price_shopping', 'registration_date', 'expiration_date', 'product', 'editar'];

  constructor(private loteService: LoteService, private router: Router) { }

  ngOnInit(): void {
    this.getLotes();
  }

  private getLotes(){
    this.loteService.listarLotes().subscribe(
      (data:any) => {
        this.lotes = data;
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!', ' Error al cargar los lotes')
      }
    )
  }

  updateLote(id: number){
    this.router.navigate(['/admin/update-lote', id]);
  }

}
