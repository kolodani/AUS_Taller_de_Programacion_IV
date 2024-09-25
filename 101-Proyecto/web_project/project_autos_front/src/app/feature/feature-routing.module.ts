import { NgModule, inject } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardAuthService } from "../core/services/guard-auth.service";

const routes: Routes = [
  {
    path: "autenticacion",
    canActivate: [() => inject(GuardAuthService).canActiveLogin()],
    loadChildren: () => import("./auth/auth.module").then(a => a.AuthModule)
  },
  {
    path: "portafolio",
    canActivate: [() => inject(GuardAuthService).canActiveWithAuth()],
    loadChildren: () => import("./home/home.module").then(a => a.HomeModule)
  },
  {
    path: "admin",
    canActivate: [() => inject(GuardAuthService).canActiveWithRolAdmin()],
    loadChildren: () => import("./admin/admin.module").then(a => a.AdminModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeatureRoutingModule { }
