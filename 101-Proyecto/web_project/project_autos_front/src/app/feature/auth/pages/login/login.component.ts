import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppBaseComponent } from '../../../../core/utils/AppBaseComponent';

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

  constructor(private router: Router, private fb: FormBuilder) {
    super();
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });

  }

  public signIn(): void {
    if (this.loginForm.valid){
      alert("todo correcto");
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
