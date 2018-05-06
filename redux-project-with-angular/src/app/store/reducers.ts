import {ADD_TODO, LIST_TODO, REMOVE_TODO, SET_VISIBILITY_FILTER, TOGGLE_TODO, VisibilityFilters} from './actions';
import {Todo} from '../model/todo';
import {initialState} from './state';

/**
 * Reducers
 **/
export const visibilityFilterReducer = (visibilityState: string = 'SHOW_ALL', action) => {
  if (action.type === SET_VISIBILITY_FILTER) {
    return action.payload;
  }
  return visibilityState;
};

export const todosReducer = (todoState: Todo[] = [], action) => {
  console.log(action);
  switch (action.type) {
    case LIST_TODO:
      return Object.assign([], initialState.todos);
    case ADD_TODO:
      return [
        ...todoState,
        { text: action.payload, completed: false }
      ];
    case REMOVE_TODO:
      return Object.assign([], todoState.filter((_, index) => index !== action.payload));
    case TOGGLE_TODO:
      return Object.assign(
        [],
        todoState.map((todo, index) => action.payload === index
          ? { text: todo.text, completed: !todo.completed }
          : todo)
      );
    case SET_VISIBILITY_FILTER:
      return Object.assign(
        [],
        todoState.filter(todo => checkVisibility(action.payload, todo))
      );
    default:
      return todoState;
  }
};

const checkVisibility = (payload, todo) => {
  if (payload === VisibilityFilters.SHOW_ALL) {
    return true;
  } else if (todo.completed) {
    return payload === VisibilityFilters.SHOW_COMPLETED;
  } else if (!todo.completed) {
    return payload === VisibilityFilters.SHOW_NOT_COMPLETED;
  }
};
