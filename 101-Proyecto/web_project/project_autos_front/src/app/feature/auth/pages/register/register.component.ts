import { Component } from '@angular/core';
import { AppBaseComponent } from '../../../../core/utils/AppBaseComponent';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../../../../core/services/auth.service';
import { Router } from '@angular/router';
import { CustomValidators } from '../../../../core/utils/CustomValidators';
import { ErrorForm } from '../../../../core/enums/ErrorsForm';
import { RegisterRequestDto } from '../../../../core/dto/registerRequestDto';
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent extends AppBaseComponent {

  /**
   * Formulario reactivo de registro
   */
  public registerForm: FormGroup;

  public passwordGenerated: string;

  public registered: boolean;

  constructor(private router: Router, private fb: FormBuilder, private authService: AuthService) {
    super();
    this.registered = false;
    this.registerForm = this.fb.group({
      dni: ['', [Validators.required, Validators.pattern("[0-9]*$")]],
      fullName: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.pattern("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")]],
      numberCellphone: ['', [Validators.required, Validators.pattern("[0-9]*$")]]
    });

  }

  public async register(): Promise<void> {

    let dtoRegister: RegisterRequestDto = this.registerForm.value;

    if (this.registerForm.valid) {
      await lastValueFrom(this.authService.register(dtoRegister)).then(resp => {
        this.passwordGenerated = resp.password;
      })
      this.registered = true;
    } else {
      console.log(this.getAllErrorsForm(this.registerForm));
    }
  }

  public getErrorForm(field: string): String {
    let message;

    const required: Array<String> = ["dni", "fullName", "email", "numberCellphone"];
    const formatEmail: Array<String> = ["email"];
    const onlyNumber: Array<String> = ["dni", "numberCellphone"];

    if (this.isTouchedField(this.registerForm, field)) {

      if (required.includes(field) && this.registerForm.get(field).hasError('required')) {
        message = ErrorForm.REQUIRED;
      } else if (formatEmail.includes(field) && this.registerForm.get(field).hasError('email')) {
        message = ErrorForm.EMAIL_FORMAT;
      } else if (onlyNumber.includes(field) && this.registerForm.get(field).hasError('pattern')) {
        message = ErrorForm.ONLY_NUMBER;
      }
    }
    return message;
  }
}
