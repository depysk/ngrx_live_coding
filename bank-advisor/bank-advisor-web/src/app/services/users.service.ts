import { Injectable } from '@angular/core';
import {WsClient} from "../utils/ws-client";
import {Observable} from "rxjs/Observable";
import {User} from "../models/user";

@Injectable()
export class UsersService {

  private userUpdateUrl: string = 'users/{id}/update';

  constructor(private wsClient: WsClient) {}

  public updateUser(user: User): Observable<User> {
    return this.wsClient.post(this.userUpdateUrl, {id: user.id}, user);
  }

}
