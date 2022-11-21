import { Component, OnInit } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public person = {
    name: '',
    lastname: '',
    document_type: '',
    dni: '',
    cellphone: '',
    telephone: ''
  }

  constructor(private personService:PersonService, private snack:MatSnackBar) { }

  ngOnInit(): void {
  }

  formSubmit() {
    console.log(this.person);
    if (this.person.dni == '' || this.person.dni == null) {
      this.snack.open('El documento de identidad es obligatorio !!', 'Aceptar', {
        duration: 3000,
        verticalPosition: 'top',
        horizontalPosition: 'right'
      });
      return;
    }

    this.personService.registrarPersona(this.person).subscribe(
      (data) => {
        console.log(data);
        this.snack.open('Persona registrada', 'Persona registrada con exito en el sistema');
      }, (error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!', 'Aceptar', {
          duration: 3000
        });
      }
    )
}

}

