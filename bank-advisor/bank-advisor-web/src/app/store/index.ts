import {
  ActionReducer,
  ActionReducerMap,
  createFeatureSelector,
  createSelector,
  MetaReducer
} from '@ngrx/store';
import { environment } from '../../environments/environment';
import * as fromPortfolio from './portfolio.reducer';
import {Portfolio} from "../models/portfolio";

export interface AppState {

  portfolios: Portfolio[];
}

export const reducers: ActionReducerMap<AppState> = {

  portfolios: fromPortfolio.reducer,
};


export const metaReducers: MetaReducer<AppState>[] = !environment.production ? [] : [];
