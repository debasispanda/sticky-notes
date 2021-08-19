import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
    selector: 'app-auth',
    templateUrl: './auth.component.html',
    styleUrls: ['./auth.component.scss'],
})
export class AuthComponent implements OnInit {
    public error: string = '';

    constructor(private authService: AuthService, private router: Router) {}

    ngOnInit(): void {}

    public form: FormGroup = new FormGroup({
        username: new FormControl('', [Validators.required]),
        password: new FormControl('', [Validators.required]),
    });

    public submit() {
        if (this.form.valid) {
            this.authService.authenticate(this.form.value).subscribe(() => {
                this.router.navigateByUrl('/');
            });
        }
    }
}
