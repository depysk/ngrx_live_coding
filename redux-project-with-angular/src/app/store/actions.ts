/**
 * Actions *
 **/
export const LIST_TODO = 'LIST_TODO';
export const ADD_TODO = 'ADD_TODO';
export const REMOVE_TODO = 'REMOVE_TODO';
export const TOGGLE_TODO = 'TOGGLE_TODO';
export const SET_VISIBILITY_FILTER = 'SET_VISIBILITY_FILTER';
export const VisibilityFilters = {
  SHOW_ALL: 'SHOW_ALL',
  SHOW_COMPLETED: 'SHOW_COMPLETED',
  SHOW_NOT_COMPLETED: 'SHOW_NOT_COMPLETED'
};

export const listTodoAction = () =>{
  return {
    type: LIST_TODO
  };
};

export const addTodoAction = (data) =>{
  return {
    type: ADD_TODO,
    payload: data
  };
};

export const removeTodoAction = (data) =>{
  return {
    type: REMOVE_TODO,
    payload: data
  };
};

export const toggleTodoAction = (data) =>{
  return {
    type: TOGGLE_TODO,
    payload: data
  };
};

export const visibilityFilterAction = (data) => {
  return {
    type: SET_VISIBILITY_FILTER,
    payload: data
  };
};
