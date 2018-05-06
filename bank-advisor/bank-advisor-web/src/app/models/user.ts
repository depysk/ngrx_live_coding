import {FamilySituationEnum} from "./enum/family-situation.enum";
import {ProfessionalSituationEnum} from "./enum/professional-situation.enum";

export class User {
  id: number;
  firstname: string;
  lastname: string;
  birthday: Date;
  gender: string;
  famillySituation: FamilySituationEnum;
  professionalSituation: ProfessionalSituationEnum;
  registrationNumber: string;

  /* Données IHM */
  editMode: boolean;
}
