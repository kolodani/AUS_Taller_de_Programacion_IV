import { Injectable } from '@angular/core';
import { AuthLoginRequestDto } from '../dto/authLoginRequestDto';
import { Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { AuthLoginResponseDto } from '../dto/authLoginResponseDto';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl: string = environment.apiUrl;

  constructor(private http: HttpClient, private tokenService: TokenService) { }

  public singIn(authDto: AuthLoginRequestDto): Observable<AuthLoginResponseDto> {
    return this.http.post<AuthLoginResponseDto>(`${this.apiUrl}auth/sign-in`, authDto).pipe(
      tap(response => {
        this.tokenService.saveToken(response.jwt);
      })
    );
  }
}
