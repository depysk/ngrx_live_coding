import {schema} from 'normalizr';

/* Users */
export const user = new schema.Entity('users');
export const users = new schema.Array(user);

/* Portfolios */
export const portfolio = new schema.Entity('portfolios', {
  users: users
});
export const portfolios = new schema.Array(portfolio, {
  users: users
});

/* Products */
export const product = new schema.Entity('products', {
  users: users
});
export const products = new schema.Array(product, {
  users: users
});
