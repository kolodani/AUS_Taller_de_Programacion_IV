import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppBaseComponent } from '../../../../core/utils/AppBaseComponent';
import { AuthLoginRequestDto } from '../../../../core/dto/authLoginRequestDto';
import { AuthService } from '../../../../core/services/auth.service';
import { lastValueFrom } from 'rxjs';
import { TokenService } from '../../../../core/services/token.service';
import { ErrorForm } from '../../../../core/enums/ErrorsForm';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent extends AppBaseComponent {

  /**
   * Formulario reactivo de login
   */
  public loginForm: FormGroup;

  constructor(private router: Router, private fb: FormBuilder, private authService: AuthService, private tokenService: TokenService) {
    super();
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });

  }

  public async signIn(): Promise<void> {
    let dtoLogin: AuthLoginRequestDto;
    if (this.loginForm.valid) {
      alert("todo correcto");
      let email = this.loginForm.get('email').value;
      let password = this.loginForm.get('password').value;
      dtoLogin = {
        "email": email,
        "password": password
      }
      await lastValueFrom(this.authService.singIn(dtoLogin));

      console.log(this.tokenService.getToken());

      await this.router.navigateByUrl("portafolio");

    } else {
      alert("hay errores en el formulario");
      console.log(this.getAllErrorsForm(this.loginForm));
      this.loginForm.markAllAsTouched();
    }
  }

  public signUp(): void {
    this.router.navigateByUrl("autenticacion/registro");
  }

  public getErrorForm(field: string): String {
    let message;
    if (this.isTouchedField(this.loginForm, field)) {
      if (this.loginForm.get(field).hasError('required')) {
        message = ErrorForm.REQUIRED;
      } else if (this.loginForm.get(field).hasError('email')) {
        message = ErrorForm.EMAIL_FORMAT;
      }
    }
    return message;
  }
}
