import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';

import {Observable} from 'rxjs';

/** Inject With Credentials into the request */
@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {

    const clonedRequest = req.clone({
      headers: new HttpHeaders({}),
      withCredentials: true
    });

    return next.handle(clonedRequest);
  }
}
