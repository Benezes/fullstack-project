import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.prod';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private _URL = environment.url + 'products'

  constructor(private http: HttpClient) { }

  findAllProducts() {
    return this.http.get<Product[]>(this._URL);
  }

  saveProduct(product: Product) {
    return this.http.post<Product>(this._URL, product);
  }

  removeProduct(id: number) {
    return this.http.delete(`${this._URL}/${id}`);
  }
}
