import {Component, OnInit} from '@angular/core';
import { Store, select } from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import {addTodoAction, listTodoAction, removeTodoAction, toggleTodoAction, visibilityFilterAction} from './store/actions';
import {Todo} from './model/todo';
import {AppState} from './model/app.state';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  todos$: Observable<Todo[]>;

  constructor(private store: Store<AppState>) {}

  ngOnInit() {
    this.todos$ = this.store.pipe(select(s => s.todos));
    this.store.dispatch(listTodoAction());
  }

  removeTodo(index) {
    this.store.dispatch(removeTodoAction(index));
  }

  toggleTodo(index) {
    this.store.dispatch(toggleTodoAction(index));
  }

  addTodo(todoInput) {
    this.store.dispatch(addTodoAction(todoInput));
  }

  filterVisibility(visibility) {
    this.store.dispatch(listTodoAction());
    this.store.dispatch(visibilityFilterAction(visibility));
  }
}
