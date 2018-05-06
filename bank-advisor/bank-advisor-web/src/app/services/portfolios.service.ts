import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {WsClient} from "../utils/ws-client";
import {Portfolio} from "../models/portfolio";

@Injectable()
export class PortfoliosService {

  private portfoliosUrl: string = 'portfolios/all';
  private removeUserFromPortfolioUrl: string = 'portfolios/{portfolioId}/delete-user/{userId}';

  constructor(private wsClient: WsClient) {}

  getPortfolios(): Observable<Portfolio[]> {
    return this.wsClient.get(this.portfoliosUrl);
  }

  public removeUserFromPortfolio(portfolioId: number, userId: number): Observable<number> {
    return this.wsClient.delete(this.removeUserFromPortfolioUrl, {portfolioId, userId});
  }

}
