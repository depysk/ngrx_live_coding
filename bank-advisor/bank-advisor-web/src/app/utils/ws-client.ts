import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {UriBuilderService} from './uri-builder.service';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {ErrorObservable} from "rxjs/observable/ErrorObservable";
import {catchError} from "rxjs/operators";

@Injectable()
export class WsClient {

  constructor(private http: HttpClient,
              private uriBuilder: UriBuilderService) {
  }

  private static handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(`Backend returned code ${error.status}, body was: ${error.error}`);
    }
    return new ErrorObservable(
      'Something bad happened; please try again later.');
  };

  get(uriTemplate: string, urlParams: any = {}): Observable<any> {
    let url = this.uriBuilder.buildUrl(uriTemplate, urlParams);
    return this.http.get(url).pipe(catchError(WsClient.handleError));
  }

  put(uriTemplate: string, urlParams: any, body: any): Observable<any> {
    let url = this.uriBuilder.buildUrl(uriTemplate, urlParams);
    return this.http.put(url, body).pipe(catchError(WsClient.handleError));
  }

  post(uriTemplate: string, urlParams: any, body: any): Observable<any> {
    let url = this.uriBuilder.buildUrl(uriTemplate, urlParams);
    return this.http.post(url, body).pipe(catchError(WsClient.handleError));
  }

  delete(uriTemplate: string, urlParams: any): Observable<any> {
    let url = this.uriBuilder.buildUrl(uriTemplate, urlParams);
    return this.http.delete(url).pipe(catchError(WsClient.handleError));
  }

  patch(uriTemplate: string, urlParams: any, body: any): Observable<any> {
    let url = this.uriBuilder.buildUrl(uriTemplate, urlParams);
    return this.http.patch(url, body).pipe(catchError(WsClient.handleError));
  }
}
