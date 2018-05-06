import {AppState} from '../model/app.state';

/**
 *  Application state
 **/
export const initialState: AppState = {
  todos: [
    {
      text: 'Apprendre Javascript',
      completed: true
    },
    {
      text: 'Apprendre Redux/Ngrx',
      completed: true
    },
    {
      text: 'Apprendre Java',
      completed: true
    },
    {
      text: 'Apprendre Scala',
      completed: false
    },
    {
      text: 'Apprendre Big Data',
      completed: false
    }
  ],
  visibilityFilter: 'SHOW_ALL'
};

