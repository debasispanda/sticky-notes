import { Injectable } from '@angular/core';
import {
    ActivatedRouteSnapshot,
    CanActivate,
    CanLoad,
    Route,
    Router,
    RouterStateSnapshot,
    UrlSegment,
    UrlTree,
} from '@angular/router';
import { from } from 'rxjs';
import { Observable } from 'rxjs';
import { mapTo } from 'rxjs/operators';
import { AuthService } from './auth.service';

@Injectable({
    providedIn: 'root',
})
export class AuthGuard implements CanActivate, CanLoad {
    constructor(private authService: AuthService, private router: Router) {}

    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        if (
            (state.url === '/login' && !this.authService.isAuthenticated()) ||
            (state.url !== '/login' && this.authService.isAuthenticated())
        ) {
            return true;
        }

        if (state.url === '/login' && this.authService.isAuthenticated()) {
            return from(this.router.navigate(['/'])).pipe(mapTo(false));
        }

        return from(this.router.navigate(['login'])).pipe(mapTo(false));
    }

    canLoad(
        route: Route,
        segments: UrlSegment[]
    ): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        if (
            (route.path === 'login' && !this.authService.isAuthenticated()) ||
            (route.path !== 'login' && this.authService.isAuthenticated())
        ) {
            return true;
        }

        if (route.path === 'login' && this.authService.isAuthenticated()) {
            return from(this.router.navigate(['/'])).pipe(mapTo(false));
        }

        return from(this.router.navigate(['login'])).pipe(mapTo(false));
    }
}
