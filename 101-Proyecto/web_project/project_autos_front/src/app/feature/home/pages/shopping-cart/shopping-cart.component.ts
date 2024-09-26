import { Component } from '@angular/core';
import { CarsPurchaseDto } from "../../../../core/dto/carsPurchaseDto";
import { PurchaseRequestDto } from "../../../../core/dto/purchaseRequestDto";
import { TokenService } from "../../../../core/services/token.service";
import { PurchaseService } from "../../../../core/services/purchase.service";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrl: './shopping-cart.component.css'
})
export class ShoppingCartComponent {

  public listCarsPurchase: Array<CarsPurchaseDto>;

  public numberBill: string;

  public purchaseSaved: boolean = false;

  constructor(private tokenService: TokenService, private purchaseService: PurchaseService) {
    this.listCarsPurchase = JSON.parse(localStorage.getItem("carsPurchase"));
  }

  public registerPurchase(): void {

    let totalItems: number = 0;

    this.listCarsPurchase.forEach(car => totalItems += car.total);

    let newPurchase: PurchaseRequestDto = {
      cardIdDate: this.tokenService.getInfoToken().dni,
      date: new Date(Date.now()),
      carsPurchase: this.listCarsPurchase,
      paymentMethod: "Credito",
      total: totalItems
    }

    this.purchaseService.registerPurchase(newPurchase).subscribe({
      next: value => {
        this.numberBill = value.numberBill;
        this.purchaseSaved = true;
        localStorage.setItem("carsPurchase", "")
      }
    })
  }
}
