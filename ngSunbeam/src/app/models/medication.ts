export class Medication {
  id: number;
  medication: string;
  healthCondition: string;
  description: string;
  dose: string;
  frequency: string;

  constructor(
    id: number = 0,
    medication: string = "",
    healthCondition: string = "",
    description: string = "",
    dose: string = "",
    frequency: string = ""
  ){
    this.id = id;
    this.medication = medication;
    this.healthCondition = healthCondition;
    this.description = description;
    this.dose = dose;
    this.frequency = frequency;
  }
}
