import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AuthInterceptor } from './auth-interceptor';
import { AuthService } from './auth.service';

describe('AuthInterceptor', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [
                AuthService,
                { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
            ],
        });
    });

    it('should create an instance', () => {
        const interceptor = TestBed.inject(HTTP_INTERCEPTORS);
        expect(interceptor).toBeTruthy();
    });
});
