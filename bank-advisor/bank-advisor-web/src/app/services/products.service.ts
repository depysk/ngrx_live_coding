import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {WsClient} from "../utils/ws-client";
import {Product} from "../models/product";

@Injectable()
export class ProductsService {

  private productsUrl: string = 'products/all';

  constructor(private wsClient: WsClient) {}

  getProducts(): Observable<Product[]> {
    return this.wsClient.get(this.productsUrl);
  }
}
