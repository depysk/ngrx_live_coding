/**
 *  Utils function
 */
Array.prototype.unique = function() {
    return this.filter(function (value, index, self) {
        return self.indexOf(value) === index;
    });
};


window.onload = () => {

    /**
     *  Application state
     **/
    let state = {
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
    let backUpTodos = [];


    /**
     * Actions *
     **/
    const LIST_TODO = 'LIST_TODO';
    const ADD_TODO = 'ADD_TODO';
    const REMOVE_TODO = 'REMOVE_TODO';
    const TOGGLE_TODO = 'TOGGLE_TODO';
    const SET_VISIBILITY_FILTER = 'SET_VISIBILITY_FILTER';
    const VisibilityFilters = {
        SHOW_ALL: 'SHOW_ALL',
        SHOW_COMPLETED: 'SHOW_COMPLETED',
        SHOW_NOT_COMPLETED: 'SHOW_NOT_COMPLETED'
    };

    const listTodoAction = () =>{
        return {
            type: LIST_TODO
        }
    };

    const addTodoAction = (data) =>{
        return {
            type: ADD_TODO,
            payload: data
        }
    };

    const removeTodoAction = (data) =>{
        return {
            type: REMOVE_TODO,
            payload: data
        }
    };

    const toggleTodoAction = (data) =>{
        return {
            type: TOGGLE_TODO,
            payload: data
        }
    };

    const visibilityFilterAction = (data) => {
        return {
            type: SET_VISIBILITY_FILTER,
            payload: data
        }
    };


    /**
     * Reducers
     **/
    const appReducer = (state = {}, action) => {
        return {
            todos: todos(state.todos, action),
            visibilityFilter: visibilityFilter(state.visibilityFilter, action)
        }
    };

    const visibilityFilter = (visibilityState = state.visibilityFilter, action) => {
        if (action.type === SET_VISIBILITY_FILTER) {
            return action.payload;
        }
        return visibilityState;
    };

    const todos = (todoState = state.todos, action) => {
        console.log(action);
        switch (action.type) {
            case ADD_TODO:
                return [
                    ...todoState,
                    { text: action.payload, completed: false }
                ];
            case REMOVE_TODO:
                return Object.assign([], todoState.filter((_, index) => index.toString() !== action.payload));
            case TOGGLE_TODO:
                return Object.assign(
                    [],
                    todoState.map((todo, index) => action.payload === index.toString()
                        ? { text: todo.text, completed: !todo.completed }
                        : todo)
                );
            case SET_VISIBILITY_FILTER:
                backUpTodos = [...todoState];
                const todoVisibility = checkVisibility(action.payload);
                return Object.assign(
                    [],
                    todoState.filter(todo => todoVisibility(todo))
                );
            default:
                return [...backUpTodos, ...todoState].unique();
        }
    };

    const checkVisibility = payload => todo => {
        if(payload === VisibilityFilters.SHOW_ALL) {
            return true;
        } else if (todo.completed) {
            return payload === VisibilityFilters.SHOW_COMPLETED;
        } else if (!todo.completed) {
            return payload === VisibilityFilters.SHOW_NOT_COMPLETED;
        }
    };


    /**
     *  Tuyauterie
     **/

    const init = () => {
        store.dispatch(listTodoAction());
    };

    const updateView = () => {
        document.querySelector('#add-todo-input').value = '';
        document.querySelector('#todo-list').innerHTML = store.getState().todos.map((todo, index) =>
            `
                <tr>
                    <td class="${todo.completed ? 'strike' : ''}">${todo.text}</td>
                    <td>${todo.completed ? 'Oui' : 'Non'}</td>
                    <td>
                        <button type="button" class="btn btn-primary" id="sw-todo-${index}" data-index="${index}">Switcher</button>
                        <button type="button" class="btn btn-danger" id="dl-todo-${index}" data-index="${index}">Supprimer</button>
                    </td>
                </tr>
            `
        ).join(' ');

        document.querySelectorAll('button[id^="dl-todo-"]').forEach( elt => elt.onclick = ($event) => {
            const index = $event.srcElement.attributes['data-index'].value;
            store.dispatch(removeTodoAction(index));
        });
        document.querySelectorAll('button[id^="sw-todo-"]').forEach( elt => elt.onclick = ($event) => {
            const index = $event.srcElement.attributes['data-index'].value;
            store.dispatch(toggleTodoAction(index));
        });
    };

    document.querySelector('#add-todo-btn').onclick = () => {
        const todoInput = document.querySelector('#add-todo-input').value;
        store.dispatch(addTodoAction(todoInput));
    };

    const select = document.querySelector('#todos-visibility');
    select.addEventListener('change', function() {
        store.dispatch(listTodoAction());
        const visibility = this.value;
        store.dispatch(visibilityFilterAction(visibility));
    });


    /** Initialisation **/
    const store = Redux.createStore(appReducer);
    store.subscribe(updateView);
    init();
};