import {PortfolioDomainEnum} from "./enum/portfolio-domain.enum";
import {User} from "./user";

export class Portfolio {
  id: number;
  domain: PortfolioDomainEnum;
  users: User[];
}
