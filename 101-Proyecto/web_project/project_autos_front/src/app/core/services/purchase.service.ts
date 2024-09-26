import { Injectable } from '@angular/core';
import { environment } from "../../../environments/environment.development";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { PurchaseRequestDto } from '../dto/purchaseRequestDto';
const { apiUrl } = environment;

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  constructor(private http: HttpClient) { }

  public registerPurchase(newPurchase: PurchaseRequestDto): Observable<any>{
    return this.http.post(`${apiUrl}compras`, newPurchase);
  }
}
