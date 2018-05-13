import {Action} from '@ngrx/store';

export enum PortfolioActionTypes {
  FETCH_PORTFOLIOS = '[Portfolio] FETCH_PORTFOLIOS',
  FETCH_PORTFOLIOS_COMPLETED = '[Portfolio] FETCH_PORTFOLIOS_COMPLETED',
  PORTFOLIOS_EDIT_USER = '[Portfolio] PORTFOLIOS_EDIT_USER',
  PORTFOLIOS_EDIT_USER_COMPLETED = '[Portfolio] PORTFOLIOS_EDIT_USER_COMPLETED',
  PORTFOLIOS_DELETE_USER = '[Portfolio] PORTFOLIOS_DELETE_USER',
  PORTFOLIOS_DELETE_USER_COMPLETED = '[Portfolio] PORTFOLIOS_DELETE_USER_COMPLETED'
}

export class FetchPortfolios implements Action {
  readonly type = PortfolioActionTypes.FETCH_PORTFOLIOS;
  constructor(public payload: any = {}) {}
}

export class FetchPortfoliosCompleted implements Action {
  readonly type = PortfolioActionTypes.FETCH_PORTFOLIOS_COMPLETED;
  constructor(public payload: any = {}) {}
}

export class PortfoliosEditUser implements Action {
  readonly type = PortfolioActionTypes.PORTFOLIOS_EDIT_USER;
  constructor(public payload: any = {}) {}
}

export class PortfoliosEditUserCompleted implements Action {
  readonly type = PortfolioActionTypes.PORTFOLIOS_EDIT_USER_COMPLETED;
  constructor(public payload: any = {}) {}
}

export class PortfoliosDeleteUser implements Action {
  readonly type = PortfolioActionTypes.PORTFOLIOS_DELETE_USER;
  constructor(public payload: any = {}) {}
}

export class PortfoliosDeleteUserCompleted implements Action {
  readonly type = PortfolioActionTypes.PORTFOLIOS_DELETE_USER_COMPLETED;
  constructor(public payload: any = {}) {}
}

export type PortfolioActions = FetchPortfolios | PortfoliosEditUser | PortfoliosDeleteUser
  | FetchPortfoliosCompleted | PortfoliosEditUserCompleted | PortfoliosDeleteUserCompleted;
