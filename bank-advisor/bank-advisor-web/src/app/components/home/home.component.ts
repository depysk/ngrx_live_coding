import {Component, OnInit} from '@angular/core';
import {PortfoliosService} from '../../services/portfolios.service';
import {Portfolio} from '../../models/portfolio';
import {User} from "../../models/user";
import {UsersService} from "../../services/users.service";
import * as _ from "lodash";
import {Observable} from "rxjs/Observable";
import {Product} from "../../models/product";
import {ProductsService} from "../../services/products.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  portfolios$: Observable<Portfolio[]>;
  products$: Observable<Product[]>;
  currentUserToView: User;

  constructor(private portfoliosService: PortfoliosService,
              private productsService: ProductsService,
              private usersService: UsersService) { }

  ngOnInit() {
    this.portfolios$ = this.portfoliosService.getPortfolios();
    this.products$ = this.productsService.getProducts();
  }

  onEditUser(user: User) {
    user.editMode = true;
  }

  onViewUser(user: User) {
    this.currentUserToView = user;
  }

  onRemoveUserFromPortfolio(portfolio: Portfolio, user: User) {
    this.portfoliosService.removeUserFromPortfolio(portfolio.id, user.id).subscribe(
      (userId: number) => {
        _.remove(portfolio.users, (user: User) => {
          return user.id === userId;
        });

    });
  }

  onUpdateUser(user: User) {
    user.editMode = false;
    this.usersService.updateUser(user).subscribe(
      (u: User) => user = u
    );
  }

}
