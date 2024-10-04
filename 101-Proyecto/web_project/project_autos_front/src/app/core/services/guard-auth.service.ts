import { Injectable } from '@angular/core';
import { Router } from "@angular/router";
import { TokenService } from "./token.service";
import { Roles } from '../enums/Roles';
import Swal from 'sweetalert2';


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
      Swal.fire({
        icon: 'error',
        title: 'Denegado...',
        text: 'No tiene los permisos para ver esta pagina'
      })
      this.router.navigateByUrl("/autenticacion/inicio-sesion");
      return false;
    }

    return true;
  }

  public canActiveWithRolAdmin(): boolean {
    if (this.tokenService.getInfoToken().rol != Roles.ADMIN && !this.canActiveWithAuth()) {
      Swal.fire({
        icon: 'error',
        title: 'Denegado...',
        text: 'No tiene los permisos para ver esta pagina'
      })
      this.router.navigateByUrl("/autenticacion/inicio-sesion");
      return false;
    }

    return true;
  }
}