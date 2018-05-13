import {Component, OnInit} from '@angular/core';
import {PortfoliosService} from '../../services/portfolios.service';
import {Portfolio} from '../../models/portfolio';
import {User} from "../../models/user";
import {UsersService} from "../../services/users.service";
import {Observable} from "rxjs/Observable";
import {Product} from "../../models/product";
import {ProductsService} from "../../services/products.service";
import {AppState} from "../../store";
import {Store} from "@ngrx/store";
import * as actionsPortfolio from '../../store/portfolio.actions';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  portfolios$: Observable<Portfolio[]>;
  products$: Observable<Product[]>;
  currentUserToView: User;

  constructor(private store: Store<AppState>,
              private portfoliosService: PortfoliosService,
              private productsService: ProductsService,
              private usersService: UsersService) { }

  ngOnInit() {
    this.store.dispatch(new actionsPortfolio.FetchPortfolios());
    this.portfolios$ = this.store.select(s => s.portfolios);
    this.products$ = this.productsService.getProducts();
  }

  onEditUser(user: User) {
    user.editMode = true;
  }

  onViewUser(user: User) {
    this.currentUserToView = user;
  }

  onRemoveUserFromPortfolio(portfolio: Portfolio, user: User) {
    this.store.dispatch(new actionsPortfolio.PortfoliosDeleteUser({portfolioId: portfolio.id, userId: user.id}));
    // this.portfoliosService.removeUserFromPortfolio(portfolio.id, user.id).subscribe(
    //   (userId: number) => {
    //     _.remove(portfolio.users, (user: User) => {
    //       return user.id === userId;
    //     });
    //
    // });
  }

  onUpdateUser(user: User) {
    user.editMode = false;
    this.store.dispatch(new actionsPortfolio.PortfoliosEditUser(user));
    // this.usersService.updateUser(user).subscribe(
    //   (u: User) => user = u
    // );
  }

}
