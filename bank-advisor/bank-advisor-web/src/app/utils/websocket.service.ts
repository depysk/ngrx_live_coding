import {Injectable} from '@angular/core';

declare const SockJS: any;
declare const Stomp: any;

@Injectable()
export class WebsocketService {

  private bankAdvisorWebSocketUrl = 'http://localhost:8080/ws/bank-advisor-websocket';
  private stompClient;

  constructor() {}

  connect() {
    const socket = new SockJS(this.bankAdvisorWebSocketUrl);
    this.stompClient = Stomp.over(socket);
    this.stompClient.debug = null;
    this.stompClient.connect({}, () => {
      this.stompClient.subscribe(
        '/topic/schedule-task-1',
        (message) => {
          console.log('websocket msg : ' + message.body);
        });
      this.stompClient.subscribe(
        '/topic/errors',
        (message) => {
          console.log('websocket error : ' + message.body);
        });
    }, () => {
      console.log('websocket technical error');
    });
  }

  send(url: string, data?: any) {
    this.stompClient.send(url, {}, data);
  }

  disconnect() {
    if (this.stompClient) {
      this.stompClient.unsubscribe();
    }
  }
}
