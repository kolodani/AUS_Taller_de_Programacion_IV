import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppBaseComponent } from '../../../../core/utils/AppBaseComponent';
import { AuthLoginRequestDto } from '../../../../core/dto/authLoginRequestDto';
import { AuthService } from '../../../../core/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent extends AppBaseComponent{

  /**
   * Formulario reactivo de login
   */
  public loginForm: FormGroup;

  constructor(private router: Router, private fb: FormBuilder, private authService: AuthService) {
    super();
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });

  }

  public signIn(): void {
    let dtoLogin: AuthLoginRequestDto;
    if (this.loginForm.valid){
      alert("todo correcto");
      let email= this.loginForm.get('email').value;
      let password = this.loginForm.get('password').value;
      dtoLogin = {
        "email": email,
        "password": password
      }
      this.authService.singIn(dtoLogin).subscribe(value => {
        console.log("se va a mostrarme despues");
        console.log(value);
      });

      console.log("se va a mostrar antes que el subscribe");
    } else {
      alert("hay errores en el formulario");
      console.log(this.getAllErrorsForm(this.loginForm))
    }
  }

  public signUp(): void {
    this.router.navigateByUrl("autenticacion/registro");
  }

  public getErrorForm(field: string): String {
    let message;
      if (this.isTouchedField(this.loginForm, field)) {
        if (this.loginForm.get(field).hasError('required')) {
          message = 'El campo es requerido';
        } else if (this.loginForm.get(field).hasError('email')){
          message = 'Requiere el formato de Email';
        }
      }
    return message;
  }
}
