export class Medication {
  id: number;
  medicationName: string;
  healthCondition: string;
  description: string;
  dose: string;
  frequency: string;

  constructor(
    id: number = 0,
    medicationName: string = "",
    healthCondition: string = "",
    description: string = "",
    dose: string = "",
    frequency: string = ""
  ){
    this.id = id;
    this.medicationName = medicationName;
    this.healthCondition = healthCondition;
    this.description = description;
    this.dose = dose;
    this.frequency = frequency;
  }
}
