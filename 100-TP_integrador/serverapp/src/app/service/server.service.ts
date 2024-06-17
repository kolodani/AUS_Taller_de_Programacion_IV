import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { CustomResponse } from '../interface/custom-response';

@Injectable({
    providedIn: 'root',
})
export class ServerService {
    constructor(private http: HttpClient) {}

    // getServers(): Observable<CustomResponse> {
    //     return this.http.get<CustomResponse>(
    //         'http://localhost:8080/server/list'
    //     );
    // }

    private readonly apiUrl = 'any';

    server$ = <Observable<CustomResponse>>(
        this.http
            .get<CustomResponse>(`${this.apiUrl}/server/list`)
            .pipe(tap(console.log), catchError(this.handleError))
    );

    handleError(handleError: any): Observable<never> {
        return throwError('Method not implemented.');
    }
}
