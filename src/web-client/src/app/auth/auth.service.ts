import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthRequest, AuthResponse } from './index';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

export const AUTH_URL = '/api/login';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    constructor(private http: HttpClient) {}

    public authenticate(payload: AuthRequest): Observable<any> {
        return this.http.post(AUTH_URL, payload).pipe(
            map((res: any) => {
                this.saveToken(res.token);
            })
        );
    }

    private saveToken(token: string): void {
        localStorage.setItem('token', token);
    }

    public logout(): void {
        localStorage.removeItem('token');
    }

    public isAuthenticated(): boolean {
        return !!this.getToken();
    }

    public getToken(): string | null {
        return localStorage.getItem('token');
    }
}
