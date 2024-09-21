import { Injectable } from '@angular/core';
import { Router } from "@angular/router";
import { TokenService } from "./token.service";

@Injectable({
  providedIn: 'root'
})
export class GuardAuthService {

  constructor(private tokenService: TokenService, private router: Router) { }

  /**
   * Guardian que redirige a las paginas respectivas de su rol si se encuentra logueado e intenta loguearse de nuevo
   */
  public canActiveLogin(): boolean {
    if (this.tokenService.getToken()) {
      this.router.navigateByUrl("/portafolio");
      return false;
    }

    return true;
  }

  /**
   * Guardian que permite acceder a una pagina si se encuentra logueado
   */
  public canActiveWithAuth(): boolean {
    if (!this.tokenService.getToken()) {
      alert("no tienes permisos");
      this.router.navigateByUrl("/autenticacion/inicio-sesion");
      return false;
    }

    return true;
  }
}