import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomValidators } from '../../../../core/utils/CustomValidators';
import { CarDto } from '../../../../core/dto/carDto';
import Swal from 'sweetalert2';
import { AppBaseComponent } from '../../../../core/utils/AppBaseComponent';
import { CarService } from '../../../../core/services/car.service';


@Component({
  selector: 'app-register-car',
  templateUrl: './register-car.component.html',
  styleUrl: './register-car.component.css'
})
export class RegisterCarComponent extends AppBaseComponent{

  public registerCarForm: FormGroup;

  constructor(private fb: FormBuilder, private carService: CarService) {
    super();
    this.registerCarForm = this.fb.group(
      {
        infoBasicForm: this.fb.group({
          codeCar: ['', Validators.required],
          brandCarId: ['', Validators.required],
          brandCarString: ['', Validators.required],
          reference: ['', Validators.required],
          price: ['', Validators.required],
          modelYear: ['', [Validators.required, CustomValidators.numberDateFuture]],
          category: ['', Validators.required],
          stock: ['', Validators.required]
        }),
        infoMechForm: this.fb.group({
          horsepower: ['', Validators.required],
          engineDisplacement: ['', Validators.required],
          transmission: ['', Validators.required],
          fuelType: ['', Validators.required],
          traction: ['', Validators.required],
          steering: ['', Validators.required]
        }),
        infoAestheticForm: this.fb.group({
          color: ['', Validators.required],
          numberDoor: ['', Validators.required],
          numberSeat: ['', Validators.required],
          pathImage: ['', Validators.required]
        })
      }
    );
  }

  public async registerCar(): Promise<void> {

    if(!this.registerCarForm.valid){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Hay errores en el Formulario, reviselo por favor'
      })
      console.log(this.getAllErrorsForm(this.registerCarForm));
      this.registerCarForm.markAllAsTouched();
    }

    let formData = this.registerCarForm.value;

    let formBasic = formData["infoBasicForm"];
    let formMech = formData["infoMechForm"];
    let formAesthetic = formData["infoAestheticForm"];

    let dtoRegisterCar: CarDto = {
      ...formBasic,
      ...formMech,
      ...formAesthetic
    }

    this.carService.registerCar(dtoRegisterCar).subscribe(
      {
        next: value => {
          Swal.fire({
            icon: 'success',
            title: 'Registro Exitoso',
            text: 'Se registro el carro correctamente'
          })
          console.log("carro guardado", value);
        }, error: err => {
          Swal.fire({
            icon: 'error',
            title: 'Algo ha ocurrido',
            text: 'Hubo un problema al guardar el carro'
          })
          console.log(err);
        }
      }
    )
  }
}
