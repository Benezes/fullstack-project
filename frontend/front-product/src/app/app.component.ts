import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ProductService } from './service/product.service';
import { Product } from './model/product';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {

  products: Product[] = [];

  productForm = this.fb.group({
    id: [],
    name: [null, Validators.required],
    value: [null, Validators.required],
    description: [],
  });

  constructor(
    private fb: FormBuilder,
    private productService: ProductService
  ) { 
    this.findProducts();
  }

  findProducts() {
    this.productService.findAllProducts().subscribe({
      next: (res) => {
        this.products = res;
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  createProduct(): Product {
    return {
      id: this.productForm.get('id')?.value,
      name: this.productForm.get('name')?.value,
      value: this.productForm.get('value')?.value,
      description: this.productForm.get('description')?.value,
    }
  }

  save() {
    if(this.productForm.valid) {
      const product = this.createProduct();
      console.log('product', product);
      this.productService.saveProduct(product).subscribe(
        {
          next: (res) => {
            this.productForm.reset();
            this.findProducts();
            alert("Product save successfully");
          },
          error: (error) => {
            alert("An error occurred: " + error);
          }
        }
      );
    }
  }

  remove(product: Product) {
    const confimacao = confirm("Do you really want to delete this product? " + product.name)
    if(confimacao) {
      this.productService.removeProduct(product.id ?? 0).subscribe(
        {
          next: (res) => {
            alert("Product removed successfully");
          },
          error: (error) => {
            alert("An error occurred: " + error);
          }
        }        
      )
    }
  }
}
