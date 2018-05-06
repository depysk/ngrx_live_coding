import {PortfolioDomainEnum} from "./enum/portfolio-domain.enum";
import {User} from "./user";

export class Product {
  id: number;
  name: string;
  domain: PortfolioDomainEnum;
  users: User[];
}
