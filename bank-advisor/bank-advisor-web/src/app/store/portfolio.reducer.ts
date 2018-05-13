import {PortfolioActions, PortfolioActionTypes} from "./portfolio.actions";
import {Portfolio} from "../models/portfolio";


export const initialState: Portfolio[] = [];

export function reducer(state = initialState, action: PortfolioActions): Portfolio[] {
  switch (action.type) {

    case PortfolioActionTypes.FETCH_PORTFOLIOS_COMPLETED: {
      return Object.assign([], action.payload);
    }
    case PortfolioActionTypes.PORTFOLIOS_EDIT_USER_COMPLETED: {

      return Object.assign(
        [],
        state.map(state => {
          let p: Portfolio = new Portfolio();
          p.id = state.id;
          p.domain = state.domain;
          p.users = state.users.map(user => {
            if (user.id === action.payload.id) {
              return Object.assign({}, action.payload)
            }
            return Object.assign({}, user);
          });
          return p;
        })
      );

    }
    case PortfolioActionTypes.PORTFOLIOS_DELETE_USER_COMPLETED: {

      const portfolioId = action.payload.portfolioId;
      const userId = action.payload.userId;

      return Object.assign(
        [],
        state.map(s => {
            if(s.id === portfolioId) {
              const userIndex = s.users.findIndex(user => user.id === userId);
              s.users.splice(userIndex, 1);
            }
            return s;
          })
      );
    }
    default:
      return state;
  }
}
