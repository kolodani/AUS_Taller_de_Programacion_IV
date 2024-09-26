import { CarsPurchaseDto } from "./carsPurchaseDto";

export interface PurchaseRequestDto {

  cardIdDate: number;

  date: Date;

  total: number;

  paymentMethod: string;

  carsPurchase: Array<CarsPurchaseDto>;
}