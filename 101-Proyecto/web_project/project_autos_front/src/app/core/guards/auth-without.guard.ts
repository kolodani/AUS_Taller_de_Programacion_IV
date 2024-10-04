import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenService } from "../services/token.service";
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AuthWithoutGuard implements CanActivate {

  constructor(private tokenService: TokenService, private router: Router) {
  }


  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

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

}