import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { UserService } from '../core/user.service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
    public userDetails: any;

    constructor(
        private userService: UserService,
        private authService: AuthService,
        private router: Router
    ) {}

    ngOnInit(): void {
        this.userService.getCurrentUserDetails().subscribe((res) => {
            this.userDetails = res;
        });
    }

    public logout() {
        this.authService.logout();
        this.router.navigateByUrl('/login');
    }
}
