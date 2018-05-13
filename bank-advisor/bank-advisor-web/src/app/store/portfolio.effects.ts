import {Injectable} from '@angular/core';
import {Actions, Effect, ofType} from '@ngrx/effects';
import {
  FetchPortfoliosCompleted,
  PortfolioActionTypes,
  PortfoliosDeleteUser,
  PortfoliosDeleteUserCompleted,
  PortfoliosEditUser,
  PortfoliosEditUserCompleted
} from "./portfolio.actions";
import {exhaustMap, map} from "rxjs/operators";
import {PortfoliosService} from "../services/portfolios.service";
import {Observable} from "rxjs/Observable";
import {Action} from "@ngrx/store";
import {Portfolio} from "../models/portfolio";
import {UsersService} from "../services/users.service";
import {User} from "../models/user";


@Injectable()
export class PortfolioEffects {

  constructor(private actions$: Actions,
              private portfoliosService: PortfoliosService,
              private usersService: UsersService) {}

  @Effect() fetchPortfolios$: Observable<Action> = this.actions$.pipe(
    ofType(PortfolioActionTypes.FETCH_PORTFOLIOS),
    exhaustMap(_ =>
      this.portfoliosService
        .getPortfolios()
        .pipe(map((portfolios: Portfolio[]) => new FetchPortfoliosCompleted(portfolios)))
    )
  );

  @Effect() updateUser$: Observable<Action> = this.actions$.pipe(
    ofType(PortfolioActionTypes.PORTFOLIOS_EDIT_USER),
    exhaustMap((action: PortfoliosEditUser)  =>
      this.usersService
        .updateUser(action.payload)
        .pipe(map((u: User) => new PortfoliosEditUserCompleted(u)))
    )
  );

  @Effect() removeUser$: Observable<Action> = this.actions$.pipe(
    ofType(PortfolioActionTypes.PORTFOLIOS_DELETE_USER),
    exhaustMap((action: PortfoliosDeleteUser)  =>
      this.portfoliosService
        .removeUserFromPortfolio(action.payload.portfolioId, action.payload.userId)
        .pipe(map((userId: number) => new PortfoliosDeleteUserCompleted({
          portfolioId: action.payload.portfolioId,
          userId: action.payload.userId}))
        )
    )
  );


}
