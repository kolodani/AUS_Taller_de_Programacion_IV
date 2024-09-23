import { Component } from '@angular/core';
import { CarService } from '../../../../core/services/car.service';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrl: './portfolio.component.css'
})
export class PortfolioComponent {

  public listCarsPortfolio: any[];

  constructor(private carService: CarService) {
    this.carService.getAllCars().subscribe(
      {
        next: value => {
          this.listCarsPortfolio = value;
        }
      }
    )
  }
}
