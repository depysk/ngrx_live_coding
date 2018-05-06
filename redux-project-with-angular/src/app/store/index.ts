import {ActionReducerMap} from '@ngrx/store';
import {StoreConfig} from '@ngrx/store/src/store_module';

import {todosReducer, visibilityFilterReducer} from './reducers';
import {initialState} from './state';
import {AppState} from '../model/app.state';

export const storeAppConfig: StoreConfig<AppState> = {
  initialState: initialState
};

export const storeAppReducer: ActionReducerMap<AppState> = {
  todos : todosReducer,
  visibilityFilter: visibilityFilterReducer
};
