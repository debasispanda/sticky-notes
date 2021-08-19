import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export const ME_URL = '/api/v1/user/_me';

@Injectable({
    providedIn: 'root',
})
export class UserService {
    constructor(private http: HttpClient) {}

    public getCurrentUserDetails() {
        return this.http.get(ME_URL);
    }
}
